import core.appointment.AppointmentList;
import core.appointment.AppointmentResult;
import core.person.Patient;
import core.person.stuff.medical.DoctorType;
import core.person.stuff.medical.MedicalStaff;
import core.person.stuff.management.strategy.ManagementRegistrationStrategy;
import core.person.stuff.medical.strategy.MedicalAppointmentStrategy;
import core.person.stuff.medical.strategy.TherapistAppointmentStrategy;
import core.service.board.BoardType;
import core.person.stuff.management.ManagementType;
import core.journal.Journal;
import core.journal.ProxyJournal;
import core.medicalCard.MedicalCardProxy;
import core.MedicalCenter;
import core.person.client.ClientRequest;
import core.person.client.Client;
import core.person.stuff.management.ManagementStaff;
import core.medicalCard.MedicalCardService;

public class Main {

    public static void main(String[] args) {
        MedicalCenter medicalCenter = new MedicalCenter(Journal.getJournalInstance());
        Client client = preparePatient();

        ManagementStaff administrator = medicalCenter.getManagement().get(ManagementType.ADMINISTRATOR);
        administrator.setStrategy(new ManagementRegistrationStrategy());
        Patient patient = administrator.doJob(
                new ProxyJournal(medicalCenter.getJournal()),
                client,
                administrator,
                medicalCenter.getMedicalPackage(),
                medicalCenter.getMedical()
        );

        if (patient != null && !patient.getAppointmentList().isEmpty()) {
            medicalCenter.getJournal().printJournal();
            startMedicalExamination(patient);
        }
    }

    private static Client preparePatient() {
        Client patient = new Client();
        patient.setName("TEST Patient");
        patient.setAge(90);
        patient.setRequest(new ClientRequest(BoardType.WORK));
        return patient;
    }

    private static void startMedicalExamination(Patient patient) {
        patient.printAppointmentList();
        System.out.println("***Appointment started***");

        for (AppointmentList appointmentList : patient.getAppointmentList()) {
            MedicalStaff doctor = appointmentList.getAppointment().getDoctor();
            doctor.setStrategy(getStrategyByMedicalService(appointmentList));

            MedicalCardService.makeMedicalCardRecord(
                    new MedicalCardProxy(patient.getMedicalCard()),
                    doctor,
                    new AppointmentResult(
                            appointmentList.getAppointment(), doctor.doAppointment(patient)
                    )
            );
            System.out.println(appointmentList.getMedicalService().getClass().getName().substring(appointmentList.getMedicalService().getClass().getName().lastIndexOf('.')+1) + " has been done");

        }
        System.out.println();
        System.out.println("Analyse patient data...");
        System.out.println();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        patient.getMedicalCard().print();
    }

    private static MedicalAppointmentStrategy getStrategyByMedicalService(AppointmentList appointmentList) {
        MedicalAppointmentStrategy strategy = null;
        if (appointmentList.getAppointment().getDoctor().getType() == DoctorType.THERAPIST){
            strategy = new TherapistAppointmentStrategy();
        };
        //TODO add other strategy for other doctors;
        return strategy;
    }

}