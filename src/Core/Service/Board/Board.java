package Core.Service.Board;

import Core.Person.Patient;
import Core.Service.Analysis.Analysis;
import Core.Service.Examination.Examination;

import java.util.ArrayList;

public class Board {

    private Patient patient;
    private ArrayList<Analysis> analysis;
    private ArrayList<Examination> examinations;
    private Integer price;
    private Boolean isPaid = false;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public ArrayList<Analysis> getAnalysis() {
        return analysis;
    }

    public void setAnalysis(ArrayList<Analysis> analysis) {
        this.analysis = analysis;
    }

    public ArrayList<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(ArrayList<Examination> examinations) {
        this.examinations = examinations;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }
}
