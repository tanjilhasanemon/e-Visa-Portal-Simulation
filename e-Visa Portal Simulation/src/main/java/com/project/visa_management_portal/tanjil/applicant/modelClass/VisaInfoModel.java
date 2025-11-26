package com.project.visa_management_portal.tanjil.applicant.modelClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VisaInfoModel {

    private static class VisaInfoEntry {
        String type;
        String info;

        VisaInfoEntry(String type, String info) {
            this.type = type;
            this.info = info;
        }
    }

    private final ArrayList<VisaInfoEntry> entries = new ArrayList<>();

    public VisaInfoModel() {
        entries.add(new VisaInfoEntry("Tourist Visa", buildTouristInfo()));
        entries.add(new VisaInfoEntry("Business Visa", buildBusinessInfo()));
        entries.add(new VisaInfoEntry("Student Visa", buildStudentInfo()));
        entries.add(new VisaInfoEntry("Transit Visa", buildTransitInfo()));
        entries.add(new VisaInfoEntry("Work Visa", buildWorkInfo()));
    }


    public List<String> getAvailableVisaTypes() {
        List<String> types = new ArrayList<>();
        for (VisaInfoEntry e : entries) {
            types.add(e.type);
        }
        return types;
    }

    public String viewVisaInfo(String visaType) {
        for (VisaInfoEntry e : entries) {
            if (Objects.equals(e.type, visaType)) {
                return e.info;
            }
        }
        return "";
    }


    public boolean updateVisaInfo(String visaType, String info) {

                return true; // updated existing
            }


    private String buildTouristInfo() {
        return
                """
                        Visa type: Tourist Visa
                        Purpose: Short-term travel, tourism, visiting family or friends.
                        Typical fee: 5,000 - 8,000 BDT (depending on duration and processing speed).
                        Processing time: 3-7 working days (normal), 1-2 days (urgent) — subject to verification.
                        Requirements:
                         - Passport valid for at least 6 months from arrival date
                         - Recent passport-size photo (35x45 mm)
                         - Passport copy (bio-data page)
                         - Travel itinerary or return ticket (recommended)
                         - Proof of funds / bank statement (may be required)
                        Instructions:
                         - Fill the e-Visa form carefully and upload clear scanned documents.
                         - Pay the visa fee using the online payment option.
                         - After approval, download the e-Visa and carry a printed copy when travelling.
                        """;
    }

    private String buildBusinessInfo() {
        return
                """
                        Visa type: Business Visa
                        Purpose: Business meetings, conferences, short-term work-related visits.
                        Typical fee: 7,000 - 12,000 BDT (varies by duration and supporting documents).
                        Processing time: 5-10 working days.
                        Requirements:
                         - Passport valid at least 6 months
                         - Invitation letter from Bangladeshi company/organization
                         - Company cover letter (applicant's employer)
                         - Passport-size photo and passport copy
                        Instructions:
                         - Ensure invitation and company letters contain contact details and purpose.
                         - Attach supporting documents clearly when uploading.
                        """;
    }

    private String buildStudentInfo() {
        return
                """
                        Visa type: Student Visa
                        Purpose: Long-term study at a recognized educational institution.
                        Typical fee: 3,000 - 10,000 BDT (depends on length and processing).
                        Processing time: 2-6 weeks (may take longer for verification).
                        Requirements:
                         - Admission letter from recognized university/institute in Bangladesh
                         - Proof of sufficient funds / sponsor letter
                         - Passport valid for study duration + 6 months
                        Instructions:
                         - Prepare academic documents and admission certificate before applying.
                         - Student visas often require additional verification by the institution.
                        """;
    }

    private String buildTransitInfo() {
        return
                """
                        Visa type: Transit Visa
                        Purpose: Short stopover in Bangladesh while en route to another country.
                        Typical fee: 1,000 - 2,000 BDT.
                        Processing time: 1-3 working days.
                        Requirements:
                         - Passport valid for at least 6 months
                         - Confirmed onward ticket within permitted transit time
                        Instructions:
                         - Transit visas are short-term and for specific travel routes only.
                        """;
    }

    private String buildWorkInfo() {
        return
                """
                        Visa type: Work Visa
                        Purpose: Employment in Bangladesh under a local employer or project.
                        Typical fee: 10,000 - 25,000 BDT (depends on duration and work category).
                        Processing time: 4-8 weeks (requires employer sponsorship and clearances).
                        Requirements:
                         - Valid passport + passport-size photos
                         - Employment contract / sponsorship letter from employer in Bangladesh
                         - Medical clearance and police clearance may be required
                        Instructions:
                         - Work visas require coordination with the employer and sometimes government agencies.
                         - Upload all employer documents clearly to avoid delays.
                        """;
    }
}
