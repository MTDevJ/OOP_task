package core.person.stuff.management.strategy;

import core.MedicalCenter;
import core.person.Patient;
import core.person.client.Client;
import core.person.stuff.management.ManagementStaff;

public interface ManagementStrategy {

    Patient execute(MedicalCenter medicalCenter, Client client, ManagementStaff person);
}
