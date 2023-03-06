package contacts;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {
    static Scanner scanner = new Scanner(System.in);

    public static ArrayList<Object> action(ArrayList<Object> personsAndOrganization){
        ArrayList<Object> personsAndOrganizationFind;
        personsAndOrganizationFind = addFindResult(personsAndOrganization);
        countPrint(personsAndOrganizationFind);
        return personsAndOrganizationFind;
    }

    public static ArrayList<Object> addFindResult(ArrayList<Object> personsAndOrganization) {
        ArrayList<Object> personsAndOrganizationsFind = new ArrayList<Object>();
        System.out.println("Enter search query:");
        String searchQuerry = scanner.nextLine();
        String info;
        for (Object o : personsAndOrganization) {
            if (o instanceof Person) {
                Pattern pattern = Pattern.compile(searchQuerry, Pattern.CASE_INSENSITIVE);
                info = ((Person) o).getInfo();
                Matcher matcher = pattern.matcher(info);
                if (matcher.find()) {
                    personsAndOrganizationsFind.add(o);
                }
            }

            if (o instanceof Organization) {
                Pattern pattern = Pattern.compile(searchQuerry, Pattern.CASE_INSENSITIVE);
                info = ((Organization) o).getInfo();
                Matcher matcher = pattern.matcher(info);
                if (matcher.find()) {
                    personsAndOrganizationsFind.add(o);
                }

            }

        }

        return personsAndOrganizationsFind;
    }


   public static void countPrint(ArrayList<Object> personsAndOrganizationsFind ){
       System.out.println("Found " + personsAndOrganizationsFind.size() + " results:");
       Input.printList(personsAndOrganizationsFind);
   }

}
