package core.journal;

import core.person.stuff.management.Administrator;
import core.person.stuff.Staff;

public class ProxyJournal implements JournalInterface {
    Journal journal;

    public ProxyJournal(Journal journal) {
        this.journal = journal;
    }
    @Override
    public void addRecord(JournalRecord row) {
        if (checkAccess(row.createdBy)){
            journal.addRecord(row);
        }
    }

    private boolean checkAccess(Staff person){
        return person instanceof Administrator;
    }
}
