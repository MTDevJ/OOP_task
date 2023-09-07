package core.journal;

import core.person.Patient;
import core.person.client.Client;

import java.util.ArrayList;

public class Journal implements JournalInterface {

    private static Journal journalInstance;
    private ArrayList<JournalRecord> journalRecords;

    private Journal() {
        journalRecords = new ArrayList<>();
    }

    public static Journal getJournalInstance(){
        if (journalInstance == null) return new Journal();
        return journalInstance;
    }

    @Override
    public void addRecord(JournalRecord row) {
        journalRecords.add(row);
    }

    public void printJournal(){
        System.out.println("***Journal***");
        this.journalRecords.stream().forEach(
                item -> System.out.println("-Patient:" + ((Patient)item.person).getClient().getName()  + "| Type:" + item.type
                        + (item.appointment != null ? "| Doctor: " + item.appointment.getDoctor().getName(): "")
                        + "| Date:" + item.registrationdate + "| CreatedBy:" + item.createdBy.getName())
        );
        System.out.println();
    }

    public void printJournal(Client client){
        System.out.println("***Journal record by client***");
        this.journalRecords.stream().filter(item -> ((Patient)item.person).getClient().getName().equals(client.getName()))
                .forEach(item -> System.out.println("-Patient:" + ((Patient)item.person).getClient().getName() + "| Type:" + item.type
                        + (item.appointment != null ? "| Doctor: " + item.appointment.getDoctor().getName(): "")
                        + "| Date:" + item.registrationdate + "| CreatedBy:" + item.createdBy.getName())
        );
        System.out.println();
    }

}
