package core.person.stuff.management;

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

    public Patient doJob(ProxyJournal journal, Client client, ManagementStaff person, Map<BoardType, Board> packages, Map<DoctorType, MedicalStaff> medicalStaff) {
        return strategy.execute(journal, client, person, packages, medicalStaff);
    }

    public abstract ManagementType getType();

    public void setStrategy(ManagementStrategy strategy) {
        this.strategy = strategy;
    }

}
