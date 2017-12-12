package main.java.model;

public class EmployeeModel {
    private int id;
    private String name;
    private String contact;
    private String emailAddress;
    private String bloodGroup;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContact() {
        return contact;
    }
    public void setContact(String contact) {
        this.contact = contact;
    }
    public String getEmail() { return emailAddress; }
    public void setEmail(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getBloodGroup() {
        return bloodGroup;
    }
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

}
