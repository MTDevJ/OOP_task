package Core.Journal;

import Core.Person.Patient;
import Core.Person.Stuff.Staff;

import java.util.ArrayList;

public class Journal implements JornalInterface{

    private static Journal journalInstance;
    private ArrayList<JournalRow> rows;

    private Journal() {
        rows = new ArrayList<>();
    }

    public static Journal getJournalInstance(){
        if (journalInstance == null) return new Journal();
        return journalInstance;
    }

    @Override
    public void addRow(Staff person, Patient patient) {
            rows.add(new JournalRow(person, patient));
    }
}
