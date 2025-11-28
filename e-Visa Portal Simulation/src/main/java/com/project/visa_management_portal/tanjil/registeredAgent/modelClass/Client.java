package com.project.visa_management_portal.tanjil.registeredAgent.modelClass;

public class Client {
    private String clientId;      // auto-generated
    private String name;
    private String passportNo;
    private String contact;

    public Client(String name, String passportNo, String contact) {
        this.clientId = generateClientId();
        this.name = name;
        this.passportNo = passportNo;
        this.contact = contact;
    }


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    private String generateClientId() {
        return "";
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", name='" + name + '\'' +
                ", passportNo='" + passportNo + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
