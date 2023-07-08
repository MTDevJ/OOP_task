package Core.MedicalPackages;

import Core.Person.Patient;
import Core.Service.Analysis.Analysis;
import Core.Service.Board.Board;
import Core.Service.Examination.Examination;

import java.util.ArrayList;

public interface PackageBuilder {

    void reset();
    void setPatient(Patient patient);

    void setAnalysis(ArrayList<Analysis> analysis);

    void setExaminations( ArrayList<Examination> examination);
    void setPrice(Integer price);

    Board returnPackage();
}
