import Core.Person.Patient;
import Core.Person.Person;
import Core.Person.Stuff.Management.Administrator;
import Core.Person.Stuff.Management.ManagementStaff;
import Core.Person.Stuff.Medical.MedicalStaff;
import Core.Person.Stuff.Medical.Therapist;

public class Main {
    public static void main(String[] args) {

        Person patient = new Patient();
        patient.setName("TEST Patient");
        System.out.println(patient.getName());

        MedicalStaff therapist = new Therapist();
        therapist.setName("Mr.Therapist");
        System.out.println(therapist.getName());
        System.out.println(therapist.getType());

        ManagementStaff administrator = new Administrator();
        administrator.setName("Mr.Admin");
        System.out.println(administrator.getName());
        System.out.println(administrator.getType());
    }

    private static void initMedicalCenter() {
        //TODO create stuff:
        //medical
        //management
    }

    private static void PreparePatient() {
        //TODO create patient:
    }
}