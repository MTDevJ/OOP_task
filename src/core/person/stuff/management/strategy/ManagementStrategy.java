package core.person.stuff.management.strategy;

import core.journal.ProxyJournal;
import core.person.Patient;
import core.person.client.Client;
import core.person.stuff.management.ManagementStaff;
import core.person.stuff.medical.DoctorType;
import core.person.stuff.medical.MedicalStaff;
import core.service.board.Board;
import core.service.board.BoardType;

import java.util.Map;

public interface ManagementStrategy {

    Patient execute(ProxyJournal journal, Client client, ManagementStaff person,
                    Map<BoardType, Board> packages, Map<DoctorType, MedicalStaff> medicalStaff);
}
