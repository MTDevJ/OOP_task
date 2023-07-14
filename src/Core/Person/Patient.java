package Core.Person;

import Core.PatientRequest;

public class Patient extends Person{

    private PatientRequest request;

    public void setRequest(PatientRequest request) {
        this.request = request;
    }

    public PatientRequest getRequest() {
        return request;
    }
}
