package org.example;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ContactView {
    static Scanner input = new Scanner(System.in);

    public void ContactConsole() throws IOException {
        ContactController contactfunc = new ContactController();
        ContactModel contact = new ContactModel();

        Boolean proceed = true;

        System.out.println("⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️📲➡️➡️➡️➡️➡️➡️➡️➡️➡️➡️➡️➡️➡️➡️➡️➡️");
        System.out.println("|                              CONTACT APP                            |");
        System.out.println("⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬅️⬇️➡️➡️➡️➡️➡️➡️➡️➡️➡️➡️➡️➡️➡️➡️➡️➡️");
        System.out.println();


        while(proceed){
            System.out.println("<1> Add Contact");
            System.out.println("<2> Edit Contact");
            System.out.println("<3> Delete Contact");
            System.out.println("<4> Search for Contact");
            System.out.println("<5> Display all Contact");
            System.out.println("<6> Exit");
            System.out.println();

            System.out.print(">>");
            int response = optionValidation();
            System.out.println("");

            if(response == 1){
                System.out.println("➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
                System.out.println("                      ADD CONTACT                    ");
                System.out.println("➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕➕");
                System.out.println();
                System.out.println(">> Please enter the Contact's Firstname");
                System.out.print(">>");
                contact.setFirstname(input.next().trim());
                System.out.println(">> Please enter the Contact's Lastname");
                System.out.print(">>");
                contact.setLastname(input.next().trim());
                System.out.println(">> Please enter the Contact's Phone Number");
                System.out.print(">>");
                contact.setContact(input.next().trim());
                System.out.println();

                System.out.println(contactfunc.addContact(contact));
            }
            else if(response == 2){
                System.out.println("✏✏️✏️✏️✏️✏✏✏️✏✏️✏️✏️✏️✏️✏️✏️✏️✏️️✏️✏️✏️️✏️✏️✏️");
                System.out.println("                      Edit CONTACT                    ");
                System.out.println("✏✏️✏️✏️✏️✏✏✏️✏✏️✏️✏️✏️✏️✏️✏️✏️✏️️✏️✏️✏️️✏️✏️✏️");
                System.out.println();
                System.out.println(">> Please enter the Contact's First name you want to edit");
                System.out.print(">>");
                contact.setName(input.next().trim());
                System.out.println();

                System.out.println(">> Please enter the Contact's Last name you want to edit (for precision)");
                System.out.print(">>");
                contact.setLname(input.next().trim());
                System.out.println();

                System.out.println(">> Please enter the Contact's new Firstname");
                System.out.print(">>");
                contact.setFirstname(input.next().trim());
                System.out.println();

                System.out.println(">> Please enter the Contact's new Lastname");
                System.out.print(">>");
                contact.setLastname(input.next().trim());
                System.out.println();

                System.out.println(">> Please enter the Contact's new Phone number");
                System.out.print(">>");
                contact.setContact(input.next().trim());
                System.out.println();

                System.out.println(contactfunc.editContact(contact));
            }
            else if(response == 3){
                System.out.println("🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️");
                System.out.println("                        DELETE CONTACT                   ");
                System.out.println("🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️🗑️");
                System.out.println();
                System.out.println(">> Please enter the Contact's First name you want to delete");
                System.out.print(">>");
                contact.setName(input.next().trim());
                System.out.println();

                System.out.println(">> Please enter the Contact's Last name you want to delete (for precision)");
                System.out.print(">>");
                contact.setLname(input.next().trim());
                System.out.println();

                System.out.println(contactfunc.deleteContact(contact));
            }
            else if(response == 4){
                System.out.println("🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍");
                System.out.println("                        SEARCH CONTACT                   ");
                System.out.println("🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍🔍");
                System.out.println();
                System.out.println("<1> Search by Name");
                System.out.println("<2> Search by PhoneNumber");
                System.out.println();

                int option = input.nextInt();
                if(option == 1){
                    System.out.println(">> Please enter the Contact's Name");
                    System.out.print(">>");
                    contact.setName(input.next().trim());
                    System.out.println();
                    System.out.println(contactfunc.searchContact(contact));
                }else if(option == 2){
                    System.out.println(">> Please enter the Contact's Phone Number");
                    System.out.print(">>");
                    contact.setContact(input.next().trim());
                    System.out.println();
                    System.out.println(contactfunc.searchContactByNum(contact));
                }else{
                    System.out.println("Wrong Option");
                    System.out.println();
                }
            }else if(response == 5){
                System.out.println("📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃");
                System.out.println("                 DISPLAY ALL CONTACTS                 ");
                System.out.println("📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃📃");
                System.out.println("");
                for(Map.Entry m:contactfunc.displayALlContacts().entrySet()){
                    System.out.println(m.getKey() + ": " + m.getValue());
                }
                System.out.println();
            }

            if(response == 6){
                System.out.println(">> HAVE A NICE DAY!! <<");
                proceed = false;
            }else{
                System.out.println("\nDo you want to continue?");
                String next = input.next();
                if(next.equalsIgnoreCase("yes")){
                    proceed = true;
                }else{
                    System.out.println(">> HAVE A NICE DAY!! <<");
                    proceed = false;
                }
            }
        }



    }

    public static int optionValidation(){
        int response = input.nextInt();
        while(response < 1 || response > 7){
            System.out.println("Please Input a valid number");
            response = input.nextInt();
        }

        return  response;
    }
}
