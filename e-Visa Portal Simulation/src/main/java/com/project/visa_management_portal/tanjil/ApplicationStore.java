package com.project.visa_management_portal.tanjil;

import java.util.ArrayList;

public class ApplicationStore {

    private static final ArrayList<VisaApplication> application = new ArrayList<>();

    public static ArrayList<VisaApplication> getAllApplications() {
        return new ArrayList<>(application);
    }


    public static VisaApplication findById(String applicationId) {
        if (applicationId == null) return null;
        for (VisaApplication a : application) {
            if (applicationId.equals(a.getApplicationId())) return a;
        }
        return null;
    }



}
