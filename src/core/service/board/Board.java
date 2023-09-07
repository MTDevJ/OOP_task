package core.service.board;

import core.service.analysis.Analysis;
import core.service.examination.Examination;

import java.util.ArrayList;
import java.util.List;

public abstract class Board {

    protected BoardType TYPE;

    protected List<Analysis> analysis;
    protected List<Examination> examinations;

    private Boolean isPaid = false;

    public List<Analysis> getAnalysis() {
        return analysis;
    }

    public void setAnalysis(List<Analysis> analysis) {
        this.analysis.clear();
        this.analysis.addAll(analysis);
    }

    public List<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations.clear();
        this.examinations.addAll(examinations);
    }

    public Integer getTotalPrice() {
        var ref = new Object() {
            int price = 0;
        };
        this.examinations.forEach(item-> ref.price += item.getPrice());
        this.analysis.forEach(item-> ref.price += item.getPrice());

        return ref.price;
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
        System.out.println("-Price: " + this.getTotalPrice());
        System.out.println("-Analysis:");
        this.getAnalysis().forEach(item -> System.out.println(" -|" + item.getClass().getName().substring(item.getClass().getName().lastIndexOf('.')+1) + ";"));
        System.out.println("-Examination:");
        this.getExaminations().forEach(item -> System.out.println(" -|" + item.getClass().getName().substring(item.getClass().getName().lastIndexOf('.')+1) + ";"));
        System.out.println();
    }


}
