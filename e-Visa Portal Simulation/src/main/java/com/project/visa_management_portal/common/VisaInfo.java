package com.project.visa_management_portal.common;

/*
 Suggested methods:
 // public static VisaInfo[] loadDefaultVisaInfo();
 // public String summary();
*/

public class VisaInfo {
    public String visaType;      // e.g., "Tourist"
    public String description;
    public String requirements;  // comma-separated text
    public int processingDays;
    public double fee;
}
