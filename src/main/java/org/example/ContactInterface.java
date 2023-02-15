package org.example;

import java.util.List;

public interface ContactInterface {
    public abstract String addContact(ContactModel contact);
//    public abstract String createFile(List<String> contact);
    public abstract String deleteContact(ContactModel contact);
    public abstract String editContact(ContactModel contact);
    public abstract String searchContact(ContactModel contact);
    public abstract String searchContactByNum(ContactModel contact);
}
