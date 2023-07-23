package core.person.stuff.management.strategy;

import core.appointment.Appointment;
import core.appointment.AppointmentList;
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
import core.service.examination.Examination;
import core.service.payment.Order;
import core.service.payment.PaymentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ManagementRegistrationStrategy implements ManagementStrategy {

    @Override
    public Patient execute(ProxyJournal journal, Client client, ManagementStaff person, Map<BoardType, Board> packages, Map<DoctorType, MedicalStaff> medicalStaff) {
        Patient patient = null;
        Board board = providePackage(client, packages);
        if (board != null) {
            board.printBoard();
            Order order = makePayment(client, board);
            if (order.isPaid()) {
                MedicalCard medicalCard = getPatientMedicalCard(person, client);
                patient = new Patient(client, medicalCard);
                patient.setAppointmentList(
                        makeAppointments(patient, journal, person, board, medicalStaff)
                );
                registerPatient(journal, person, client);
            }
        }
        return patient;
    }

    protected void registerPatient(ProxyJournal journal, ManagementStaff staff, Person person) {
        journal.addRecord(new JournalRecord(staff, person, JournalRecordType.REGISTRATION));
    }

    protected Board providePackage(Client patient, Map<BoardType, Board> packages) {
        return packages.get(patient.getRequest().getType());
    }

    protected Order makePayment(Client client, Board board) {
        return PaymentService.makePayment(client, board);
    }

    protected MedicalCard getPatientMedicalCard(ManagementStaff person, Client patient) {
        return MedicalCard.getMedicalCardInstance(person, patient);
    }

    protected List<AppointmentList> makeAppointments(Patient patient, ProxyJournal journal, ManagementStaff administrator, Board board, Map<DoctorType, MedicalStaff> medicalStuff) {
        List<AppointmentList> appointmentList = new ArrayList<>();

        for (Analysis analysis : board.getAnalysis()) {
            Appointment appointment = new Appointment(
                    patient,
                    medicalStuff.get(analysis.getDoctorType()),
                    analysis.getAppointmentDuration()
            );
            journal.addRecord(
                    new JournalRecord(
                            administrator,
                            patient,
                            appointment,
                            JournalRecordType.APPOINTMENT
                    )
            );
            appointmentList.add(new AppointmentList(patient, appointment, analysis));
        }
        for (Examination examination : board.getExaminations()) {
            Appointment appointment = new Appointment(
                    patient,
                    medicalStuff.get(examination.getDoctorType()),
                    examination.getAppointmentDuration()
            );
            journal.addRecord(
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
