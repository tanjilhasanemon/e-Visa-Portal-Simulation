package com.project.visa_management_portal.tanjil.registeredAgent.modelClass;



import com.project.visa_management_portal.common.User;

/*
 Suggested methods:
 // public String createClient(String fullName, String passportNumber, String email, String phone);
 // public String prepareApplicationForClient(NewVisaApplication form, String clientId);
 // public boolean submitClientApplication(String applicationId);
*/

public class RegisteredAgent extends User {
    public String agencyName;
    public String registrationId;
    public String agencyAddress;

    // simple arrays for clients and submitted apps
    public String[] clientIds = new String[50];
    public int clientCount = 0;

    public String[] submittedAppIds = new String[100];
    public int appCount = 0;
}
