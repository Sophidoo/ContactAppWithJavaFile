package org.example;

public class Main {
    public static void main(String[] args) {

        ContactView view = new ContactView();

        try{
            view.ContactConsole();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}