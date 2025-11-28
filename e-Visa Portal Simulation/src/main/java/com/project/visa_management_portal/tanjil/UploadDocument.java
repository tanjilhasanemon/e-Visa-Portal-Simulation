package com.project.visa_management_portal.tanjil;

public class UploadDocument {

    private String id;
    private String ownerType;
    private String ownerId;
    private String applicationId;
    private String passportPath;
    private String photoPath;
    private String uploadedDate;
    private String status;

    public UploadDocument() {
    }

    public UploadDocument(String ownerType, String ownerId, String applicationId, String passportPath, String photoPath) {
        this.ownerType = ownerType;
        this.ownerId = ownerId;
        this.applicationId = applicationId;
        this.passportPath = passportPath;
        this.photoPath = photoPath;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getPassportPath() {
        return passportPath;
    }

    public void setPassportPath(String passportPath) {
        this.passportPath = passportPath;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getUploadedDate() {
        return uploadedDate;
    }

    public void setUploadedDate(String uploadedDate) {
        this.uploadedDate = uploadedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "UploadDocument{" +
                "id='" + id + '\'' +
                ", ownerType='" + ownerType + '\'' +
                ", ownerId='" + ownerId + '\'' +
                ", applicationId='" + applicationId + '\'' +
                ", passportPath='" + passportPath + '\'' +
                ", photoPath='" + photoPath + '\'' +
                ", uploadedDate='" + uploadedDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
