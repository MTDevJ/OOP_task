package core.person.client;

import core.service.analysis.Analysis;
import core.service.board.BoardType;
import core.service.examination.Examination;

import java.util.ArrayList;
import java.util.List;

public class ClientRequest {

    BoardType type;

    private List<Analysis> analysis;
    private List<Examination> examinations;

    public ClientRequest() {
        analysis = new ArrayList<Analysis>();
        examinations = new ArrayList<Examination>();
    }

    public ClientRequest(BoardType type) {
        this.type = type;
    }

    public BoardType getType() {
        return type;
    }

    public List<Analysis> getAnalysis() {
        return analysis;
    }

    public List<Examination> getExaminations() {
        return examinations;
    }

    public void setAnalysis(List<Analysis> analysis) {
        this.analysis.addAll(analysis);
    }

    public void setExaminations(List<Examination> examinations) {
        this.examinations.addAll(examinations);
    }

}
