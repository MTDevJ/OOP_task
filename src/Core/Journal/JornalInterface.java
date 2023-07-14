package Core.Journal;

import Core.Person.Patient;
import Core.Person.Stuff.Staff;

public interface JornalInterface {
    void addRow(Staff person, Patient patient);
}
