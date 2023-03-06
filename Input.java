package contacts;

import java.util.ArrayList;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Input {
    static Scanner scanner = new Scanner(System.in);

    public static void count(ArrayList<Object> persons) {
        System.out.println("The Phone Book has " + persons.size() + " records.");
    }

    public static Person addPerson() {
        String name;
        String surname;
        String phoneNumber;

        System.out.println("Enter the name:");
        name = scanner.nextLine();
        System.out.println("Enter the surname:");
        surname = scanner.nextLine();
        System.out.println("Enter the birth date:");
        String birthDate = scanner.nextLine();
        birthDate = addBirthDate(birthDate);
        System.out.println("Enter the gender (M, F):");
        String gender = scanner.nextLine();
        gender = addGender(gender);
        System.out.println("Enter the number:");
        phoneNumber = scanner.nextLine();
        phoneNumber = addNumber(phoneNumber);

        return new Person(name, surname, birthDate, gender, phoneNumber);
    }

    public static Organization addOrganization(){
        System.out.println("Enter the organization name:");
        String organizationName = scanner.nextLine();
        System.out.println("Enter the address:");
        String adress = scanner.nextLine();
        System.out.println("Enter the number:");
        String phoneNumber = scanner.nextLine();
        phoneNumber = addNumber(phoneNumber);

        return new Organization(organizationName, adress , phoneNumber);
    }

    public static void editFind(ArrayList<Object> personsAndOrganization , int index) {
        if (personsAndOrganization.isEmpty()) {
            System.out.println("No records to edit!");
            return;
        }


        if (personsAndOrganization.get(index - 1) instanceof Person) {

            System.out.println("Select a field (name, surname, birth, gender, number):");
            String field = scanner.nextLine();
            if (field.equals("name")) {
                System.out.println("Enter the name");
                String name = scanner.nextLine();
                ((Person) personsAndOrganization.get(index - 1)).setName(name);
                return;
            }
            if (field.equals("surname")) {
                System.out.println("Enter the surname");
                String surname = scanner.nextLine();
                ((Person) personsAndOrganization.get(index - 1)).setSurname(surname);
                return;
            }
            if (field.equals("birth")) {
                System.out.println("Enter the birth:");
                String birth = scanner.nextLine();
                birth = addBirthDate(birth);
                ((Person) personsAndOrganization.get(index - 1)).setBirthDate(birth);
            }
            if (field.equals("gender")) {
                System.out.println("Enter the gender:");
                String gender = scanner.nextLine();
                gender = addGender(gender);
                ((Person) personsAndOrganization.get(index - 1)).setGender(gender);
            }
            if (field.equals("number")) {
                System.out.println("Enter the number");
                String phone = scanner.nextLine();
                phone = addNumber(phone);
                ((Person) personsAndOrganization.get(index - 1)).setPhoneNumber(phone);
            }


        } else if (personsAndOrganization.get(index - 1) instanceof Organization) {
            System.out.println("Select a field (name, address, number):");
            String field = scanner.nextLine();
            if(field.equals("name")){
                System.out.println("Enter the name");
                String name = scanner.nextLine();
                ((Organization) personsAndOrganization.get(index - 1)).setName(name);
                return;
            }
            if (field.equals("address")) {
                System.out.println("Enter the address");
                String address = scanner.nextLine();
                ((Organization) personsAndOrganization.get(index - 1)).setAdress(address);
                return;

            }
            if (field.equals("number")) {
                System.out.println("Enter the number");
                String phone = scanner.nextLine();
                phone = addNumber(phone);
                ((Organization) personsAndOrganization.get(index - 1)).setPhoneNumber(phone);
            }


        }

    }

    public static void printList(ArrayList<Object> personsAndOrganization) {
        for (int i = 0; i < personsAndOrganization.size(); i++) {
            if (personsAndOrganization.get(i) instanceof Person)
                System.out.println((i + 1) + ". " + ((Person) personsAndOrganization.get(i)).getName() + " " + ((Person) personsAndOrganization.get(i)).getSurname());
            if (personsAndOrganization.get(i) instanceof Organization)
                System.out.println((i + 1) + ". " + ((Organization) personsAndOrganization.get(i)).getName());
        }
    }
    public static void printIndex(ArrayList<Object> personsAndOrganization, int index){
        if(personsAndOrganization.get(index-1) instanceof Organization) {
            System.out.println("Organization name: " + ((Organization) personsAndOrganization.get(index - 1)).getName());
            System.out.println("Address: " + ((Organization) personsAndOrganization.get(index - 1)).getAdress());
            System.out.println("Number: " + ((Organization) personsAndOrganization.get(index - 1)).getPhoneNumber());
            System.out.println("Time created: " + ((Organization) personsAndOrganization.get(index-1)).getDateTimeCreated());
            System.out.println("Time last edit: " + ((Organization) personsAndOrganization.get(index-1)).getDateTimeLastEdit());
            System.out.println();
        }
        if(personsAndOrganization.get(index-1) instanceof Person){
            System.out.println("Name: " + ((Person) personsAndOrganization.get(index-1)).getName());
            System.out.println("Surname: " + ((Person) personsAndOrganization.get(index-1)).getSurname());
            System.out.println("Birth date: " + ((Person) personsAndOrganization.get(index-1)).getBirthDate());
            System.out.println("Gender: " + ((Person) personsAndOrganization.get(index-1)).getGender());
            System.out.println("Number: " + ((Person) personsAndOrganization.get(index-1)).getPhoneNumber());
            System.out.println("Time created: " + ((Person) personsAndOrganization.get(index-1)).getDateTimeCreated());
            System.out.println("Time last edit: " + ((Person) personsAndOrganization.get(index-1)).getDateTimeLastEdit());
            System.out.println();
        }

    }

    public static void info(ArrayList<Object> personsAndOrganization){
        printList(personsAndOrganization);
        System.out.println("Enter index to show info:");
        String indexStr = scanner.nextLine();
        int index = Integer.parseInt(indexStr);
        if(personsAndOrganization.get(index-1) instanceof Organization) {
            System.out.println("Organization name: " + ((Organization) personsAndOrganization.get(index - 1)).getName());
            System.out.println("Address: " + ((Organization) personsAndOrganization.get(index - 1)).getAdress());
            System.out.println("Number: " + ((Organization) personsAndOrganization.get(index - 1)).getPhoneNumber());
            System.out.println("Time created: " + ((Organization) personsAndOrganization.get(index-1)).getDateTimeCreated());
            System.out.println("Time last edit: " + ((Organization) personsAndOrganization.get(index-1)).getDateTimeLastEdit());
            System.out.println();
        }
        if(personsAndOrganization.get(index-1) instanceof Person){
            System.out.println("Name: " + ((Person) personsAndOrganization.get(index-1)).getName());
            System.out.println("Surname: " + ((Person) personsAndOrganization.get(index-1)).getSurname());
            System.out.println("Birth date: " + ((Person) personsAndOrganization.get(index-1)).getBirthDate());
            System.out.println("Gender: " + ((Person) personsAndOrganization.get(index-1)).getGender());
            System.out.println("Number: " + ((Person) personsAndOrganization.get(index-1)).getPhoneNumber());
            System.out.println("Time created: " + ((Person) personsAndOrganization.get(index-1)).getDateTimeCreated());
            System.out.println("Time last edit: " + ((Person) personsAndOrganization.get(index-1)).getDateTimeLastEdit());
            System.out.println();
        }

    }
    public static String addNumber(String number) {
        String[] result = number.split("-| ");

        Pattern pattern;
        Pattern pattern2;
        Matcher matcher;
        Matcher matcher2 = null;
        Pattern pattern3;
        Matcher matcher3 = null;
        boolean brackets= false;
        for (int i = 0; i < result.length; i++) {

            if (i == 0) {
                pattern = Pattern.compile("^(\\+){0,1}([0-9A-Za-z]){1,}$");
                pattern2 = Pattern.compile("^([0-9A-Za-z]){1,}$");
                pattern3 = Pattern.compile("^(\\+){0,1}(\\(){1}([0-9A-Za-z]){1,}(\\)){1}$");
                matcher = pattern.matcher(result[i]);
                matcher2 = pattern2.matcher(result[i]);
                matcher3 = pattern3.matcher(result[i]);

                if(matcher3.find())
                    brackets = true;

                matcher3 = pattern3.matcher(result[i]);

            } else if (i == 1) {
                pattern = Pattern.compile("^(\\(){1}[\\dA-Za-z]{2,}(\\)){1}$");
                matcher = pattern.matcher(result[i]);
                pattern2 = Pattern.compile("^[\\dA-Za-z]{2,}$");
                matcher2 = pattern2.matcher(result[i]);


                if(brackets && matcher.find()){
                    System.out.println("Wrong number format!");
                    number = "[no number]";
                    return number;
                }
                matcher = pattern.matcher(result[i]);
            } else if (i == result.length - 1) {
                pattern = Pattern.compile("^([\\dA-Za-z]){2,}$");
                matcher = pattern.matcher(result[i]);
            }
            else {
                pattern = Pattern.compile("^([\\dA-Za-z]){2,}$");
                matcher = pattern.matcher(result[i]);
            }

            if((i == 0) && !(matcher.find() || matcher2.find() || matcher3.find())){
                System.out.println("Wrong number format!");
                number = "[no number]";
                return number;
            }
            else if(i == 1 && !(matcher.find() || matcher2.find()) ){
                System.out.println("Wrong number format!");
                number = "[no number]";
                return number;
            }
            else if (i > 1 && !matcher.find()) {
                System.out.println("Wrong number format!");
                number = "[no number]";
                return number;
            }


            }


        return number;
    }

    public static void printInstance(Object object){
        if(object instanceof Person){
            System.out.println("Name: " + ((Person) object).getName());
            System.out.println("Surname " + ((Person) object).getSurname());
            System.out.println("Birth date: " + ((Person) object).getBirthDate());
            System.out.println("Gender: " + ((Person) object).getGender());
            System.out.println("Number: " + ((Person) object).getPhoneNumber());
            System.out.println(((Person) object).getDateTimeCreated());
            System.out.println(((Person) object).getDateTimeLastEdit());
            System.out.println();
        }
        if(object instanceof Organization){
            System.out.println("Organization name: " + ((Organization) object).getName());
            System.out.println("Address: " + ((Organization) object).getAdress());
            System.out.println("Number: " + ((Organization) object).getPhoneNumber());
            System.out.println("Time created: " + ((Organization) object).getDateTimeCreated());
            System.out.println("Time last edit: " + ((Organization) object).getDateTimeLastEdit());
            System.out.println();
        }

    }

    public static String addBirthDate(String birthDate){
        if(birthDate.isEmpty()) {
            birthDate = "[no data]";
            System.out.println("Bad birth date!");
        }
    return  birthDate;
    }

    public static String addGender(String gender){
        if(!(gender.equals("M") || gender.equals("F"))){
            gender = "[no data]";
            System.out.println("Bad gender!");
        }
         return gender;
    }
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }



}