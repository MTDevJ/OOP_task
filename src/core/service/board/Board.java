package core.service.board;

import core.service.analysis.Analysis;
import core.service.examination.Examination;

import java.util.ArrayList;

public abstract class Board {

    protected BoardType TYPE;
    private ArrayList<Analysis> analysis;
    private ArrayList<Examination> examinations;
    private Integer price;
    private Boolean isPaid = false;

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

    public void printBoard(){
        System.out.println("****Medical Board***");
        System.out.println("-Type: " + this.TYPE);
        System.out.println("-Price: " + this.price);
        System.out.println("-Analysis:");
        this.getAnalysis().forEach(item -> System.out.println(" -|" + item.getClass().getName().substring(item.getClass().getName().lastIndexOf('.')+1) + ";"));
        System.out.println("-Examination:");
        this.getExaminations().forEach(item -> System.out.println(" -|" + item.getClass().getName().substring(item.getClass().getName().lastIndexOf('.')+1) + ";"));
        System.out.println();
    }
}
