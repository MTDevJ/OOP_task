package core.person.client;

import core.person.Person;

public class Client extends Person {

    private ClientRequest request;

    public void setRequest(ClientRequest request) {
        this.request = request;
    }

    public ClientRequest getRequest() {
        return request;
    }
}
