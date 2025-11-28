package com.project.visa_management_portal.tanjil;

import java.time.LocalDate;
import java.util.UUID;

public class DownloadReceipt {
    private String id;


    private String fileName;
    private String fileType;      // e.g., PaymentReceipt, ApprovalLetter, eVisa
    private String filePath;      // placeholder path or URL if you later implement real files
    private String generatedDate; // yyyy-MM-dd

    public DownloadReceipt() {

    }
    public DownloadReceipt( String fileName, String fileType, String filePath) {
        this.id = UUID.randomUUID().toString();
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
        this.generatedDate = LocalDate.now().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(String generatedDate) {
        this.generatedDate = generatedDate;
    }

    @Override
    public String toString() {
        return "DownloadReceipt{" +
                "id='" + id + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", filePath='" + filePath + '\'' +
                ", generatedDate='" + generatedDate + '\'' +
                '}';
    }
}

