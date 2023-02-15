package org.example;

public class ContactModel {
    private String firstname;
    private String lastname;
    private String contact;


    private String lname;
    private String name;


    public ContactModel(){};

    public ContactModel(String firstname, String lastname, String contact, String name, String lname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.contact = contact;
        this.name = name;
        this.lname = lname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "ContactModel{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
