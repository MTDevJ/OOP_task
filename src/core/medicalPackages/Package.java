package core.medicalPackages;

import core.person.client.Client;
import core.service.analysis.Analysis;
import core.service.examination.Examination;

import java.util.ArrayList;

public abstract class Package {
    Integer price;
    ArrayList<Analysis> analysis;
    ArrayList<Examination> examinations;
    Client patient;
}
