package core.journal;

import java.util.ArrayList;

public class Journal implements JournalInterface {

    private static Journal journalInstance;
    private ArrayList<JournalRecord> journalRecord;

    private Journal() {
        journalRecord = new ArrayList<>();
    }

    public static Journal getJournalInstance(){
        if (journalInstance == null) return new Journal();
        return journalInstance;
    }

    @Override
    public void addRecord(JournalRecord row) {
            journalRecord.add(row);
    }

    public void printJournal(){
        System.out.println("***Journal***");
        this.journalRecord.stream().forEach(
                item -> System.out.println("-Patient:" + item.getPatient().getName() + "| Type:" + item.type
                        + (item.appointment != null ? "| Doctor: " + item.appointment.getDoctor().getName(): "")
                        + "| Date:" + item.registrationdate + "| CreatedBy:" + item.createdBy.getName())
        );
        System.out.println();
    }

}
