import Core.Enums.BoardType;
import Core.Enums.DoctorType;
import Core.Enums.ManagementType;
import Core.Journal.Journal;
import Core.Journal.ProxyJournal;
import Core.MedicalCard.MedicalCard;
import Core.MedicalCard.MedicalCardProxy;
import Core.MedicalPackages.Director;
import Core.MedicalPackages.SpecialPackages.DriveLicencePackageBuilder;
import Core.MedicalPackages.SpecialPackages.WeaponBoardPackageBuilder;
import Core.MedicalPackages.SpecialPackages.WorkBoardPackageBuilder;
import Core.Order;
import Core.PatientRequest;
import Core.PaymentService;
import Core.Person.Patient;
import Core.Person.Stuff.Management.Administrator;
import Core.Person.Stuff.Management.ManagementStaff;
import Core.Person.Stuff.Medical.MedicalStaff;
import Core.Person.Stuff.Medical.Therapist;
import Core.Person.Stuff.Staff;
import Core.Service.Analysis.Analysis;
import Core.Service.Board.Board;
import Core.Service.Examination.Examination;
import Core.Service.ManagementService;
import Core.Service.MedicalService;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    static HashMap<ManagementType, Staff> management = new HashMap<ManagementType, Staff>();
    static HashMap<DoctorType, Staff> medical = new HashMap<DoctorType, Staff>();

    static Journal journal;

    public static void main(String[] args) {
        initMedicalCenter();
        Patient patient = preparePatient();

        ManagementService.registerPatient(
                new ProxyJournal(journal),
                management.get(ManagementType.ADMINISTRATOR),
                patient
        );
        Board board = ManagementService.providePackage(patient);//TODO should i register it in MC or J?

        if (board != null){
            Order order = ManagementService.makePayment(board);
            if (order.isPaid()) {
                ArrayList<Analysis> analysis = board.getAnalysis();
                ArrayList<Examination> examinations = board.getExaminations();
                //loop over it
                //make record in medical card;
                MedicalService.makeMedicalCardRecord(new MedicalCardProxy(MedicalCard.getMedicalCardInstance()), doctor, patient);
            }
        }
    }

    private static void initMedicalCenter() {
        MedicalStaff therapist = new Therapist();
        therapist.setName("Mr.Therapist");
        medical.put(therapist.getType(), therapist);
        //TODO add other doctors

        ManagementStaff administrator = new Administrator();
        administrator.setName("Mr.Admin");
        management.put(administrator.getType(), therapist);

        journal = Journal.getJournalInstance();
    }

    private static Patient preparePatient() {
        Patient patient = new Patient();
        patient.setName("TEST Patient");
        patient.setRequest(new PatientRequest(BoardType.WORK));
        System.out.println(patient.getName());
        return patient;
    }

}