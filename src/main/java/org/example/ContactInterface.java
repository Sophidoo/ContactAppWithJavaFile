package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ContactInterface {
    public abstract String addContact(ContactModel contact);
//    public abstract String createFile(List<String> contact);
    public abstract String deleteContact(ContactModel contact);
    public abstract String editContact(ContactModel contact);
    public abstract String searchContact(ContactModel contact);
    public abstract String searchContactByNum(ContactModel contact);

    public abstract Map<String, String> displayALlContacts() throws IOException;
}
