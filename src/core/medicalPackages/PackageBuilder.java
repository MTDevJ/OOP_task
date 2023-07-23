package core.medicalPackages;

import core.person.client.Client;
import core.service.analysis.Analysis;
import core.service.board.Board;
import core.service.examination.Examination;

import java.util.ArrayList;

public abstract class PackageBuilder {

    //TODO builder for additional service(test appointments)
    //TODO DP Decorator?

    protected Board board;
    protected abstract void reset();
    protected abstract void setPatient(Client patient);

    protected abstract void setAnalysis(ArrayList<Analysis> analysis);

    protected abstract void setExaminations( ArrayList<Examination> examination);
    protected abstract void setPrice(Integer price);

    protected abstract Board returnPackage();
}
