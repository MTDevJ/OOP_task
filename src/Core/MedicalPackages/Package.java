package Core.MedicalPackages;

import Core.Person.Patient;
import Core.Service.Analysis.Analysis;
import Core.Service.Examination.Examination;

import java.util.ArrayList;

public abstract class Package {
    Integer price;
    ArrayList<Analysis> analysis;
    ArrayList<Examination> examinations;
    Patient patient;
}
