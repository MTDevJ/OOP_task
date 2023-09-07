package core;

import core.appointment.AppointmentList;
import core.appointment.AppointmentResult;
import core.medicalCard.MedicalCard;
import core.person.Patient;
import core.person.client.Client;
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

import java.util.*;

public class MedicalCenter {

    private static MedicalCenter instance;
    private Map<ManagementType, ManagementStaff> management = new HashMap<ManagementType, ManagementStaff>();
    private Map<DoctorType, MedicalStaff> medicalPersonal = new HashMap<DoctorType, MedicalStaff>();
    private Map<DoctorType, MedicalStaff> seniorMedicalPersonal = new HashMap<DoctorType, MedicalStaff>();
    private Map<BoardType, Board> medicalPackage = new HashMap<BoardType, Board>();

    private List<MedicalCard> medicalCards = new ArrayList<>();
    Journal journal;

    private MedicalCenter() {
        this.journal = Journal.getJournalInstance();
        initStaff();
        initPackages();
    }

    public static MedicalCenter getMedicalCenter(){
        if (instance == null) return new MedicalCenter();
        return instance;
    }

    public static void startMedicalExamination(Patient patient) {
        patient.printAppointmentList();
        System.out.println("***Appointment started***");
        //MedicalDirection medicalDirection;
        for (AppointmentList appointmentList : patient.getAppointmentList()) {
            MedicalStaff doctor = appointmentList.getAppointment().getDoctor();
            String appointmentResult = doctor.doAppointment(patient);

            if (appointmentResult == null) {
                /*ClientRequest clientRequest = new ClientRequest();
                if (appointmentList.getMedicalService() instanceof Analysis){
                    ArrayList<Analysis> analyses = new ArrayList<>();
                    analyses.add((Analysis) appointmentList.getMedicalService());
                    clientRequest.setAnalysis(analyses);
                } else if(appointmentList.getMedicalService() instanceof Examination){
                    ArrayList<Examination> examinations = new ArrayList<>();
                    examinations.add((Examination) appointmentList.getMedicalService());
                    clientRequest.setExaminations(examinations);
                }
                medicalDirection = new MedicalDirection(patient);*/
                //Return wrapper MedicalDirection {
                //patient, analysys\examination, toSenior
                // }
                //Patient
                //make appointment
                //start examinations again
            } else {
                doctor.makeMedicalCardRecord(
                        patient.getMedicalCard(),
                        doctor,
                        new AppointmentResult(
                                appointmentList.getAppointment(), appointmentResult
                        )
                );
                System.out.println(
                        appointmentList.getMedicalService().getClass().getName()
                                .substring(appointmentList.getMedicalService().getClass().getName()
                                        .lastIndexOf('.')+1) + " has been done"
                );
            }
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
        return board;
    }

    private Board makeDriveLicencePackage() {

        Board board = new DriveLicenceBoard();
        ArrayList<Examination> examinations = new ArrayList<Examination>();
        examinations.add(new EyesCheck());

        board.setExaminations(examinations);
        return board;
    }

    private Board makeWeaponPackage() {

        Board board = new WeaponBoard();
        ArrayList<Examination> examinations = new ArrayList<Examination>();
        examinations.add(new PsychiatristCheck());
        examinations.add(new EyesCheck());

        board.setExaminations(examinations);
        return board;
    }

    private void initStaff() {
        MedicalStaff therapist = new Therapist();
        therapist.setName("Mr.Therapist");
        medicalPersonal.put(therapist.getType(), therapist);

        MedicalStaff ophthalmologist = new Ophthalmologist();
        ophthalmologist.setName("Mr.Ophthalmologist");
        medicalPersonal.put(ophthalmologist.getType(), ophthalmologist);

        MedicalStaff cardiologist = new Cardiologist();
        cardiologist.setName("Mr.Cardiologist");
        medicalPersonal.put(cardiologist.getType(), cardiologist);

        MedicalStaff seniorCardiologist = new SeniorCardiologist(cardiologist);
        seniorMedicalPersonal.put(seniorCardiologist.getType(), seniorCardiologist);

        MedicalStaff psychiatrist = new Psychiatrist();
        psychiatrist.setName("Mr.Psychiatrist");
        medicalPersonal.put(psychiatrist.getType(), psychiatrist);

        MedicalStaff radiologist = new Radiologist();
        radiologist.setName("Mr.Radiologist");
        medicalPersonal.put(radiologist.getType(), radiologist);

        MedicalStaff ultrasoundDoctor = new UltrasoundDoctor();
        ultrasoundDoctor.setName("Mr.UltrasoundDoctor");
        medicalPersonal.put(ultrasoundDoctor.getType(), ultrasoundDoctor);

        MedicalStaff hematologist = new Hematologist();
        hematologist.setName("Mr.Hematologist");
        medicalPersonal.put(hematologist.getType(), hematologist);

        ManagementStaff administrator = new Administrator(this);
        administrator.setName("Mr.Admin");
        management.put(administrator.getType(), administrator);
    }

    public Map<ManagementType, ManagementStaff> getManagement() {
        return management;
    }

    public Map<DoctorType, MedicalStaff> getMedicalPersonal() {
        return medicalPersonal;
    }

    public Journal getJournal() {
        return journal;
    }

    public Map<BoardType, Board> getMedicalPackage() {
        return medicalPackage;
    }

    public MedicalCard getMedicalCard(ManagementStaff person, Client patient){
        return medicalCards.stream().filter(
                card -> Objects.equals(card.getPatient().getName(), patient.getName()))
                .findFirst()
                .orElse(new MedicalCard(person, patient)) ;
    }
}
