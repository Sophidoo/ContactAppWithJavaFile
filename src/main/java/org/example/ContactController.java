package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.nio.file.Files.createFile;

public class ContactController implements ContactInterface {
    @Override
    public String addContact(ContactModel contact) {
        try{
            Path path = Paths.get("C:\\Users\\sophi\\IdeaProjects\\ContactApp\\ContactApp.txt");
            List<String> strings = new ArrayList<>();
            if(Files.exists(path)){
                strings = Files.readAllLines(path);
                int length = strings.size();
                if(strings.size() == 0){
                    strings.add(contact.getFirstname() + " " + contact.getLastname() + ":" + contact.getContact());
                    createFile(strings);
                }else{
                    for(int i = 0; i < length; i++){
                        if(strings.get(i).split(":")[0].equalsIgnoreCase(contact.getFirstname() + " " + contact.getLastname())){
                            return "Contact with that " + contact.getFirstname() + "  already exists";
                        }
                    }

                    strings.add(contact.getFirstname() + " " + contact.getLastname() + ":" + contact.getContact());
                    createFile(strings);
                    return "Contact added Successfully";

                }
            }

            strings.add(contact.getFirstname() + " " + contact.getLastname() + ":" + contact.getContact());
            createFile(strings);
            return "Contact added Successfully";

        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            return exceptionAsString;
        }
    }


    public static String createFile(List<String> contact) {
        try{
            File file = new File("C:\\Users\\sophi\\IdeaProjects\\ContactApp\\ContactApp.txt");

            if(!file.exists()) {
                file.createNewFile();

                FileWriter writer = new FileWriter(file);
                BufferedWriter buffer = new BufferedWriter(writer);

                for(int i = 0; i < contact.size(); i++){
                    buffer.write(i);
                    buffer.flush();
                    buffer.newLine();
                }

                buffer.close();
                return "File Created Successfully at " + file;
            }else{
                FileWriter writer = new FileWriter(file);
                BufferedWriter buffer = new BufferedWriter(writer);

                for(int i = 0; i < contact.size(); i++){
                    buffer.write(contact.get(i));
                    buffer.flush();
                    buffer.newLine();
                }

                buffer.close();
            }

            return "File already exists";

        }catch(Exception e){
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            return exceptionAsString;
        }
    }

    @Override
    public String deleteContact(ContactModel contact) {
        try{
            Path path = Paths.get("C:\\Users\\sophi\\IdeaProjects\\ContactApp\\ContactApp.txt");

            List<String> strings;

            if(Files.exists(path)){
                strings = Files.readAllLines(path);
                int length = strings.size();
                if(strings.size() == 0){
                    return "No Contact exists with name: " + contact.getName();
                }else{
                    for(int i = 0; i < length; i++){
                        if(strings.get(i).split(":")[0].equalsIgnoreCase(contact.getName() + " " + contact.getLname())){
                            strings.remove(i);
                            createFile(strings);
                            return "Contact Deleted Successfully";
                        }
                    }
                }
            }

            return "No Contacts found, Please add contact";

        }catch(Exception e){
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            return exceptionAsString;
        }
    }

    @Override
    public String editContact(ContactModel contact) {
        try{
            Path path = Paths.get("C:\\Users\\sophi\\IdeaProjects\\ContactApp\\ContactApp.txt");

            List<String> strings;

            if(Files.exists(path)){
                strings = Files.readAllLines(path);
                int length = strings.size();
                if(strings.size() == 0){
                    return "No Contact exists with name: " + contact.getName();
                }else{
                    for(int i = 0; i < length; i++){
                        if(strings.get(i).split(":")[0].equalsIgnoreCase(contact.getName() + " " + contact.getLname())){
                            strings.remove(i);

                            strings.add(contact.getFirstname() + " " + contact.getLastname() + ":" + contact.getContact());
                            createFile(strings);
                            return "Contact Edited Successfully";
                        }
                    }
                }
            }

            return "No Contacts found, Please add contact";

        }catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            return exceptionAsString;
        }
    }

    @Override
    public String searchContact(ContactModel contact) {
        try{
            Path path = Paths.get("C:\\Users\\sophi\\IdeaProjects\\ContactApp\\ContactApp.txt");

            List<String> strings;

            List<String> values = new ArrayList<>();

            if(Files.exists(path)){
                strings = Files.readAllLines(path);
                int length = strings.size();
                if(strings.size() == 0){
                    return "No Contact exists with name: " + contact.getName();
                }else{
                    for(int i = 0; i < length; i++){
                        if(strings.get(i).split(":")[0].contains(contact.getName().toLowerCase())){
                            values.add(strings.get(i));
                        }
                    }
                }
            }

            return values.toString();

        }catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            return exceptionAsString;
        }
    }

    @Override
    public String searchContactByNum(ContactModel contact) {
        try{
            Path path = Paths.get("C:\\Users\\sophi\\IdeaProjects\\ContactApp\\ContactApp.txt");

            List<String> strings;

            List<String> values = new ArrayList<>();

            if(Files.exists(path)){
                strings = Files.readAllLines(path);
                int length = strings.size();
                if(strings.size() == 0){
                    return "No Contact exists with name: " + contact.getName();
                }else{
                    for(int i = 0; i < length; i++){
                        if(strings.get(i).split(":")[1].equalsIgnoreCase(contact.getContact())){
                            values.add(strings.get(i));
                        }
                    }
                }
            }

            return values.toString();

        }catch (Exception e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            return exceptionAsString;
        }
    }

    @Override
    public Map<String, String> displayALlContacts() throws IOException {

            Path path = Paths.get("C:\\Users\\sophi\\IdeaProjects\\ContactApp\\ContactApp.txt");

            List<String> strings;

            Map<String, String> map = new TreeMap<>();

            if(!Files.exists(path)){
                return map;
            }

            strings = Files.readAllLines(path);
            int length = strings.size();

            for(int i = 0; i < length; i++){
                map.put(strings.get(i).split(":")[0], strings.get(i).split(":")[1]);
            }
            return  map;

    }
}
