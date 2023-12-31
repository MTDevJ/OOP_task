package core.person.stuff.management;

import core.MedicalCenter;
import core.journal.ProxyJournal;
import core.person.Patient;
import core.person.Person;
import core.person.client.Client;
import core.person.stuff.Staff;
import core.person.stuff.management.strategy.ManagementStrategy;
import core.person.stuff.medical.DoctorType;
import core.person.stuff.medical.MedicalStaff;
import core.service.board.Board;
import core.service.board.BoardType;

import java.util.Map;

public abstract class ManagementStaff  extends Person implements Staff {

    ManagementStrategy strategy;
    MedicalCenter medicalCenter;

    public ManagementStaff(MedicalCenter medicalCenter) {
        this.medicalCenter = medicalCenter;
    }

    public Patient doJob(Client client) {
        return strategy.execute(medicalCenter, client, this);
    }
    public abstract ManagementType getType();

    public void setStrategy(ManagementStrategy strategy) {
        this.strategy = strategy;
    }

}
