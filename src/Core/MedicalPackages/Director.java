package Core.MedicalPackages;

import Core.Person.Patient;
import Core.Service.Analysis.Analysis;
import Core.Service.Analysis.BloodAnalysis;
import Core.Service.Examination.*;

import java.util.ArrayList;

public class Director {

    public Director() {

    }

    //Special medical committee
    public void makeWorkPackage(PackageBuilder packageBuilder, Patient patient){

        ArrayList<Analysis> analysis = new ArrayList<Analysis>();
        analysis.add(new BloodAnalysis());

        ArrayList<Examination> examinations = new ArrayList<Examination>();
        examinations.add(new EyesCheck());
        examinations.add(new XrayCheck());
        examinations.add(new HeartCheck());

        packageBuilder.reset();
        packageBuilder.setPatient(patient);
        packageBuilder.setAnalysis(analysis);
        packageBuilder.setExaminations(examinations);
        packageBuilder.setPrice(100);
    }

    public void makeDriveLicencePackage(PackageBuilder packageBuilder, Patient patient){

        ArrayList<Examination> examinations = new ArrayList<Examination>();
        examinations.add(new EyesCheck());

        packageBuilder.setPatient(patient);
        packageBuilder.setExaminations(examinations);
        packageBuilder.setPrice(100);
    }

    public void makeWeaponPackage(PackageBuilder packageBuilder, Patient patient){

        ArrayList<Examination> examinations = new ArrayList<Examination>();
        examinations.add(new PsychiatristCheck());
        examinations.add(new EyesCheck());

        packageBuilder.setPatient(patient);
        packageBuilder.setExaminations(examinations);
        packageBuilder.setPrice(200);
    }

    //Other medical committee
    //TODO add other medical committee here

    //Analysis packages
    //TODO add other Analysis packages here
}
