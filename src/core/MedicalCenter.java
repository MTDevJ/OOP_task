package core;

import core.person.stuff.medical.*;
import core.person.stuff.management.ManagementType;
import core.journal.Journal;
import core.person.stuff.management.Administrator;
import core.person.stuff.management.ManagementStaff;
import core.service.analysis.Analysis;
import core.service.analysis.BloodAnalysis;
import core.service.board.Board;
import core.service.board.BoardType;
import core.service.board.specialBoard.DriveLicenceBoard;
import core.service.board.specialBoard.WeaponBoard;
import core.service.board.specialBoard.WorkBoard;
import core.service.examination.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MedicalCenter {

    Map<ManagementType, ManagementStaff> management = new HashMap<ManagementType, ManagementStaff>();
    Map<DoctorType, MedicalStaff> medical = new HashMap<DoctorType, MedicalStaff>();
    Map<BoardType, Board> medicalPackage = new HashMap<BoardType, Board>();
    Journal journal;

    public MedicalCenter(Journal journal) {
        this.journal = journal;
        initStaff();
        initPackages();
    }

    private void initPackages() {
        medicalPackage.put(BoardType.WORK, makeWorkPackage());
        medicalPackage.put(BoardType.WEAPON, makeWeaponPackage());
        medicalPackage.put(BoardType.DRIVE_LICENCE, makeDriveLicencePackage());
    }

    private static Board makeWorkPackage() {

        ArrayList<Analysis> analysis = new ArrayList<Analysis>();
        analysis.add(new BloodAnalysis());

        ArrayList<Examination> examinations = new ArrayList<Examination>();
        examinations.add(new RegularCheck());
        examinations.add(new EyesCheck());
        examinations.add(new XrayCheck());
        examinations.add(new HeartCheck());

        Board board = new WorkBoard();
        board.setAnalysis(analysis);
        board.setExaminations(examinations);
        board.setPrice(100);
        return board;
    }

    private Board makeDriveLicencePackage() {

        Board board = new DriveLicenceBoard();
        ArrayList<Examination> examinations = new ArrayList<Examination>();
        examinations.add(new EyesCheck());

        board.setExaminations(examinations);
        board.setPrice(100);
        return board;
    }

    private Board makeWeaponPackage() {

        Board board = new WeaponBoard();
        ArrayList<Examination> examinations = new ArrayList<Examination>();
        examinations.add(new PsychiatristCheck());
        examinations.add(new EyesCheck());

        board.setExaminations(examinations);
        board.setPrice(200);
        return board;
    }

    private void initStaff() {
        MedicalStaff therapist = new Therapist();
        therapist.setName("Mr.Therapist");
        medical.put(therapist.getType(), therapist);

        MedicalStaff ophthalmologist = new Ophthalmologist();
        ophthalmologist.setName("Mr.Ophthalmologist");
        medical.put(ophthalmologist.getType(), ophthalmologist);

        MedicalStaff cardiologist = new Cardiologist();
        cardiologist.setName("Mr.Cardiologist");
        medical.put(cardiologist.getType(), cardiologist);

        MedicalStaff psychiatrist = new Psychiatrist();
        psychiatrist.setName("Mr.Psychiatrist");
        medical.put(psychiatrist.getType(), psychiatrist);

        MedicalStaff radiologist = new Radiologist();
        radiologist.setName("Mr.Radiologist");
        medical.put(radiologist.getType(), radiologist);

        MedicalStaff ultrasoundDoctor = new UltrasoundDoctor();
        ultrasoundDoctor.setName("Mr.UltrasoundDoctor");
        medical.put(ultrasoundDoctor.getType(), ultrasoundDoctor);

        MedicalStaff hematologist = new Hematologist();
        hematologist.setName("Mr.Hematologist");
        medical.put(hematologist.getType(), hematologist);

        ManagementStaff administrator = new Administrator();
        administrator.setName("Mr.Admin");
        management.put(administrator.getType(), administrator);
    }

    public Map<ManagementType, ManagementStaff> getManagement() {
        return management;
    }

    public Map<DoctorType, MedicalStaff> getMedical() {
        return medical;
    }

    public Journal getJournal() {
        return journal;
    }

    public Map<BoardType, Board> getMedicalPackage() {
        return medicalPackage;
    }
}
