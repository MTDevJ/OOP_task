package core.person.stuff.management.strategy;

import core.MedicalCenter;
import core.appointment.Appointment;
import core.appointment.AppointmentList;
import core.journal.Journal;
import core.journal.JournalRecord;
import core.journal.JournalRecordType;
import core.journal.ProxyJournal;
import core.medicalCard.MedicalCard;
import core.person.Patient;
import core.person.Person;
import core.person.client.Client;
import core.person.stuff.management.ManagementStaff;
import core.person.stuff.medical.DoctorType;
import core.person.stuff.medical.MedicalStaff;
import core.service.analysis.Analysis;
import core.service.board.Board;
import core.service.board.BoardType;
import core.service.board.specialBoard.OtherBoard;
import core.service.examination.Examination;
import core.service.payment.Order;
import core.service.payment.PaymentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ManagementRegistrationStrategy implements ManagementStrategy {

    @Override
    public Patient execute(MedicalCenter medicalCenter, Client client, ManagementStaff person) {
        Patient patient = null;
        Board board = providePackage(client, medicalCenter.getMedicalPackage());
        if (board != null) {
            board.printBoard();
            Order order = makePayment(client, board);
            if (order.isPaid()) {
                MedicalCard medicalCard = medicalCenter.getMedicalCard(person, client);
                patient = new Patient(client, medicalCard);
                patient.setAppointmentList(
                        makeAppointments(patient, medicalCenter.getJournal(), person, board, medicalCenter.getMedicalPersonal())
                );
                registerPatient(medicalCenter.getJournal(), person, patient);
            }
        }
        return patient;
    }

    protected void registerPatient(Journal journal, ManagementStaff staff, Person person) {
        journal.addRecord(new JournalRecord(staff, person, JournalRecordType.REGISTRATION));
    }

    protected Board providePackage(Client client, Map<BoardType, Board> packages) {
        return packages.containsKey(client.getRequest().getType()) ?
                packages.get(client.getRequest().getType())
                : buildBoard(client);
    }

    private Board buildBoard(Client patient) {
        Board board = new OtherBoard();
        for (Analysis analysis : patient.getRequest().getAnalysis()) {
            board.getAnalysis().add(analysis);
        }
        for (Examination examination : patient.getRequest().getExaminations()) {
            board.getExaminations().add(examination);
        }
        return board;
    }

    protected Order makePayment(Client client, Board board) {
        return PaymentService.makePayment(client, board);
    }

    protected List<AppointmentList> makeAppointments(Patient patient, Journal journal, ManagementStaff administrator, Board board, Map<DoctorType, MedicalStaff> regularStaff) {
        List<AppointmentList> appointmentList = new ArrayList<>();

        for (Analysis analysis : board.getAnalysis()) {
            Optional<MedicalStaff> doctorOptional = regularStaff.values().stream().filter(
                    regularStaffPersona -> regularStaffPersona.getType() == analysis.getDoctorType()
            ).findFirst();
            MedicalStaff doctor = doctorOptional.orElse(null);
            Appointment appointment = new Appointment(
                    patient,
                    doctor,
                    analysis.getAppointmentDuration()
            );
            new ProxyJournal(journal).addRecord(new JournalRecord(
                    administrator,
                    patient,
                    appointment,
                    JournalRecordType.APPOINTMENT
            ));
            appointmentList.add(new AppointmentList(patient, appointment, analysis));
        }
        for (Examination examination : board.getExaminations()) {
            Appointment appointment = new Appointment(
                    patient,
                    regularStaff.get(examination.getDoctorType()),
                    examination.getAppointmentDuration()
            );
            new ProxyJournal(journal).addRecord(
                    new JournalRecord(
                            administrator,
                            patient,
                            appointment,
                            JournalRecordType.APPOINTMENT
                    )
            );
            appointmentList.add(new AppointmentList(patient, appointment, examination));
        }
        return appointmentList;
    }

}
