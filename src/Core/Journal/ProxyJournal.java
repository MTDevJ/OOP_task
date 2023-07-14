package Core.Journal;

import Core.Person.Patient;
import Core.Person.Stuff.Management.Administrator;
import Core.Person.Stuff.Staff;

public class ProxyJournal implements JornalInterface{
    Journal journal;

    public ProxyJournal(Journal journal) {
        this.journal = journal;
    }
    @Override
    public void addRow(Staff person, Patient patient) {
        if (checkAccess(person)){
            journal.addRow(person,patient);
        }
    }

    private boolean checkAccess(Staff person){
        return person instanceof Administrator;
    }
}
