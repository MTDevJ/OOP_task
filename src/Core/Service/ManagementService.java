package Core.Service;

import Core.Enums.BoardType;
import Core.Journal.Journal;
import Core.Journal.ProxyJournal;
import Core.MedicalCard.MedicalCard;
import Core.MedicalPackages.Director;
import Core.MedicalPackages.SpecialPackages.DriveLicencePackageBuilder;
import Core.MedicalPackages.SpecialPackages.WeaponBoardPackageBuilder;
import Core.MedicalPackages.SpecialPackages.WorkBoardPackageBuilder;
import Core.Order;
import Core.PaymentService;
import Core.Person.Patient;
import Core.Person.Stuff.Staff;
import Core.Service.Board.Board;

public class ManagementService {

    public static void registerPatient(ProxyJournal journal, Staff person, Patient patient){
        journal.addRow(person, patient);
    }

    public static Board providePackage(Patient patient){
        Director director = new Director();
        Board board = null;
        if (patient.getRequest().getType().equals(BoardType.WORK)){
            board = director.makeWorkPackage(new WorkBoardPackageBuilder(), patient);
        } else if (patient.getRequest().getType().equals(BoardType.WEAPON)){
            board = director.makeWorkPackage(new WeaponBoardPackageBuilder(), patient);
        } else if(patient.getRequest().getType().equals(BoardType.DRIVE_LICENCE)){
            board = director.makeWorkPackage(new DriveLicencePackageBuilder(), patient);
        }
        return board;
    }

    public static Order makePayment(Board board){
        return PaymentService.makePayment(board);
    }

    public static MedicalCard getPatientMedical(Patient patient){
        MedicalCard medicalCardInstance = MedicalCard.getMedicalCardInstance();
        medicalCardInstance.setPatient(patient);
        return medicalCardInstance;
    }
}
