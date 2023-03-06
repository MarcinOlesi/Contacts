package contacts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Person extends Base{
    String surname;
    String birthDate = "[no data]";
    String gender = "[no data]";
    LocalDateTime myDateObjLastEdit  = LocalDateTime.now();
    public Person(String name, String surname, String birthDate , String gender ,String phoneNumber){
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public void setName(String name) {
        this.name = name;
        myDateObjLastEdit  = LocalDateTime.now();
    }
    public void setSurname(String surname){
        this.surname = surname;
        myDateObjLastEdit  = LocalDateTime.now();
    }
    public void setPhoneNumber(String phoneNumber){
       // datePersonEdit = LocalDateTime.now();
        this.phoneNumber = phoneNumber;
        myDateObjLastEdit  = LocalDateTime.now();
    }
    public void setBirthDate(String birthDate){

        this.birthDate = birthDate;
        myDateObjLastEdit  = LocalDateTime.now();
    }

    public void setGender(String gender){
        this.gender = gender;
        myDateObjLastEdit  = LocalDateTime.now();
    }

    public String getSurname(){
        return surname;
    }
    public  String getPhoneNumber(){
        return phoneNumber;
    }

    public String getBirthDate() { return birthDate; }

    public String getGender(){ return gender; }
    public String getDateTimeLastEdit(){
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return myDateObjLastEdit.format(myFormatObj);
    }
   public String getInfo(){
       return this.name + " " + this.surname + " " + this.getPhoneNumber();
   }
}
