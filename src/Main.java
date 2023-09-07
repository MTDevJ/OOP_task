import core.person.Patient;
import core.person.stuff.management.strategy.ManagementRegistrationStrategy;
import core.service.analysis.BloodAnalysis;
import core.service.board.BoardType;
import core.person.stuff.management.ManagementType;
import core.MedicalCenter;
import core.person.client.ClientRequest;
import core.person.client.Client;
import core.person.stuff.management.ManagementStaff;
import core.service.examination.HeartCheck;
import core.service.examination.RegularCheck;

import java.util.ArrayList;
import java.util.List;

//TODO safe getter setter in all classses
public class Main {

    public static void main(String[] args) {
        MedicalCenter medicalCenter = MedicalCenter.getMedicalCenter();

        ManagementStaff administrator = medicalCenter.getManagement().get(ManagementType.ADMINISTRATOR);
        administrator.setStrategy(new ManagementRegistrationStrategy());

        List<Client> clients = prepareClients();

        for (Client client : clients){
            System.out.println("***Process Client "+ client.getName()+"***");
            Patient patient = administrator.doJob(
                    client
            );

            if (patient != null && !patient.getAppointmentList().isEmpty()) {
                medicalCenter.getJournal().printJournal(client);
                MedicalCenter.startMedicalExamination(patient);
                //TODO? to senior doctor
                /*if (medicalDirection != null){
                    administrator.setStrategy(
                            new ManagementMakeAppointmentStrategy(
                                    medicalCenter,
                                    client,
                                    administrator
                            )
                    );
                }*/
            }
        }
    }

    private static List<Client> prepareClients() {
        List<Client> clientList = new ArrayList<>();
        Client patient = new Client();
        patient.setName("Worker patient");
        patient.setAge(30);
        patient.setRequest(new ClientRequest(BoardType.WORK));
        clientList.add(patient);

        Client patient2 = new Client();
        patient2.setName("Other Patient");
        patient2.setAge(90);
        ClientRequest clientRequest = new ClientRequest();
        clientRequest.getAnalysis().add(new BloodAnalysis());
        clientRequest.getExaminations().add(new HeartCheck());
        clientRequest.getExaminations().add(new RegularCheck());
        patient2.setRequest(clientRequest);
        clientList.add(patient2);

        return clientList;
    }

}