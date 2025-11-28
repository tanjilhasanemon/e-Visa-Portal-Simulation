package com.project.visa_management_portal.galib.model;

import java.time.Instant;
import java.util.UUID;

public class Document {
    public enum Type { PASSPORT, PHOTO, ID, SUPPORTING }

    private final String docId;
    private final Type type;
    private final String filename;
    private final String path; // or URL in real app
    private boolean verified = false;

    public Document(Type type, String filename, String path) {
        this.docId = UUID.randomUUID().toString();
        this.type = type;
        this.filename = filename;
        this.path = path;
    }

    public String getDocId() { return docId; }
    public Type getType() { return type; }
    public String getFilename() { return filename; }
    public String getPath() { return path; }
    public boolean isVerified() { return verified; }

    public void verify(String employeeId) {
        this.verified = true;
    }
}
