package com.project.visa_management_portal.galib;
public abstract class EmployeeG extends UserG {
    protected String employeeId;
    protected String department;
    protected String role; // e.g. "VisaOfficer", "Issuer"

    public EmployeeG(String name, String email, String phone, String passwordPlain,
                     String employeeId, String department, String role) {
        super(name, email, phone, passwordPlain);
        this.employeeId = employeeId;
        this.department = department;
        this.role = role;
    }

    public String getEmployeeId() { return employeeId; }
    public String getDepartment() { return department; }
    public String getRole() { return role; }

    public abstract boolean authorizeAction(String action);
}
