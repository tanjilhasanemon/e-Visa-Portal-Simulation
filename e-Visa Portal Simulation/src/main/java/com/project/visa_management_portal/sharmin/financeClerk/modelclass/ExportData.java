package com.project.visa_management_portal.sharmin.financeclerk.modelclass;

public class ExportData {
    private String exportType;
    private String statusMessage;

    public ExportData() {
    }

    public ExportData(String exportType, String statusMessage) {
        this.exportType = exportType;
        this.statusMessage = statusMessage;
    }

    public String getExportType() {
        return exportType;
    }

    public void setExportType(String exportType) {
        this.exportType = exportType;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public String toString() {
        return "ExportData{" +
                "exportType='" + exportType + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                '}';
    }
}
