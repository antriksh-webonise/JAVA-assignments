package com.employeeportal.model;

public class Employee {

    private int id;
    private String name;
    private String contact;
    private String email;
    private String bloodGroup;

    /*
        Method for fetching employee id
    */
    public int getId() {
        return id;
    }


    /*
            Method for setting employee id
    */
    public void setId(int id) {
        this.id = id;
    }


    /*
            Method for fetching employee name
    */
    public String getName() {
        return name;
    }


    /*
            Method for setting employee name
    */
    public void setName(String name) {
        this.name = name;
    }


    /*
            Method for fetching employee contact
    */
    public String getContact() {
        return contact;
    }


    /*
            Method for setting employee contact
    */
    public void setContact(String contact) {
        this.contact = contact;
    }


    /*
            Method for fetching employee email address
    */
    public String getEmail() {
        return email;
    }


    /*
            Method for setting employee email address
    */
    public void setEmail(String email) {
        this.email = email;
    }


    /*
            Method for fetching employee blood group
    */
    public String getBloodGroup() {
        return bloodGroup;
    }


    /*
            Method for setting employee blood group
    */
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
