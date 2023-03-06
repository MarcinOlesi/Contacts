package contacts;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {

        ArrayList<Object> personsAndOrganizations = new ArrayList<>();
        ArrayList<Object> personsAndOrganizationsFind;

        Path path = Paths.get("/home/marcin/IdeaProjects/Contacts (Java)/list_of_entities");

        if (Files.exists(path)) {
            try{
                FileInputStream readData = new FileInputStream("list_of_entities");
                ObjectInputStream readStream = new ObjectInputStream(readData);

                personsAndOrganizations = ( ArrayList<Object>) readStream.readObject();
                readStream.close();

            }catch (Exception e) {
                e.printStackTrace();
            }
        }







        Scanner scanner = new Scanner(System.in);
        String string= "" , type;

        while(!string.equals("exit")){
            System.out.println("[menu] Enter action (add, list, search, count, exit): ");
            string = scanner.nextLine();
            switch (string) {
                case "add":
                    System.out.println("Enter the type (person, organization):");
                    type = scanner.nextLine();
                    if (type.equals("person")) {
                        personsAndOrganizations.add(Input.addPerson());
                        System.out.println("The record added.");
                        System.out.println();
                    } else if (type.equals("organization")) {
                        personsAndOrganizations.add(Input.addOrganization());
                        System.out.println("The record added.");
                        System.out.println();
                    }
                    break;
           /*else if(string.equals("remove")){
                Input.remove(personsAndOrganizations);
            }*/
                case "count":
                    Input.count(personsAndOrganizations);
                    break;
                case "list":

                    Input.printList(personsAndOrganizations);
                    System.out.println("[list] Enter action ([number], back):");
                    String list = scanner.nextLine();
                    while (!list.equals("back")) {

                        if (Input.isNumeric(list))
                            Input.printIndex(personsAndOrganizations, Integer.parseInt(list));

                        System.out.println("[record] Enter action (edit, delete, menu)");
                        String actionRecord = scanner.nextLine();
                        if (actionRecord.equals("menu"))
                            list = "back";
                        while (!actionRecord.equals("menu")) {
                            if (actionRecord.equals("edit")) {
                                Input.editFind(personsAndOrganizations, Integer.parseInt(list));
                                //Input.copyFind(personsAndOrganizations, personsAndOrganizationsFind);
                                System.out.println("Saved");
                                Input.printInstance(personsAndOrganizations.get(Integer.parseInt(list) - 1));
                                System.out.println();

                            }

                            System.out.println("[record] Enter action (edit, delete, menu)");
                            actionRecord = scanner.nextLine();
                            if (actionRecord.equals("menu")) {
                                list = "back";
                            }

                        }


                    }
                    System.out.println();
                    break;
                case "search":
                    String action = "again";
                    String actionRecord = "";
                    personsAndOrganizationsFind = Search.action(personsAndOrganizations);


                    while (action.equals("again") || Input.isNumeric(action) || !action.equals("menu") || !actionRecord.equals("menu")) {
                        System.out.println();
                        System.out.println("[search] Enter action ([number], back, again): ");
                        action = scanner.nextLine();

                        if (action.equals("again"))
                            personsAndOrganizationsFind = Search.action(personsAndOrganizations);
                        if (Input.isNumeric(action)) {
                            Input.printIndex(personsAndOrganizationsFind, Integer.parseInt(action));
                            string = "record";
                            System.out.println("[record] Enter action (edit, delete, menu)");
                            actionRecord = scanner.nextLine();
                            if (actionRecord.equals("menu"))
                                action = "menu";

                            while (!actionRecord.equals("menu")) {
                                if (actionRecord.equals("edit")) {
                                    Input.editFind(personsAndOrganizationsFind, Integer.parseInt(action));
                                    System.out.println("Saved");
                                    Input.printInstance(personsAndOrganizationsFind.get(Integer.parseInt(action) - 1));
                                    System.out.println();

                                }

                                System.out.println("[record] Enter action (edit, delete, menu)");
                                actionRecord = scanner.nextLine();
                                if (actionRecord.equals("menu"))
                                    action = "menu";
                            }
                        }
                    }
                    break;
                case "record":

                    break;
            }




        }


        try{
            FileOutputStream writeData = new FileOutputStream("list_of_entities");
            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

            writeStream.writeObject(personsAndOrganizations);
            writeStream.flush();
            writeStream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
