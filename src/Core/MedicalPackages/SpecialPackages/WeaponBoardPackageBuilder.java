package Core.MedicalPackages.SpecialPackages;

import Core.MedicalPackages.PackageBuilder;
import Core.Person.Patient;
import Core.Service.Analysis.Analysis;
import Core.Service.Board.Board;
import Core.Service.Board.SpecialBoard.WeaponBoard;
import Core.Service.Examination.Examination;

import java.util.ArrayList;

public class WeaponBoardPackageBuilder implements PackageBuilder {

    private Board workBoard;

    @Override
    public void reset() {
        workBoard = new WeaponBoard();
    }

    @Override
    public void setPatient(Patient patient) {
        workBoard.setPatient(patient);
    }

    @Override
    public void setAnalysis(ArrayList<Analysis> analysis) {
        workBoard.setAnalysis(analysis);
    }

    @Override
    public void setExaminations(ArrayList<Examination> examinations) {
        workBoard.setExaminations(examinations);
    }

    @Override
    public void setPrice(Integer price) {
        workBoard.setPrice(price);
    }

    @Override
    public Board returnPackage() {
        return workBoard;
    }
}
