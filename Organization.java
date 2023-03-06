package contacts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Organization extends Base {
    String adress="";

    LocalDateTime myDateObjLastEdit  = LocalDateTime.now();

   public Organization(String name, String adress , String phoneNumber){
      this.name = name;
      this.adress = adress;
      this.phoneNumber = phoneNumber;
  }
  public void setAdress(String adress){
        this.adress = adress;
       myDateObjLastEdit  = LocalDateTime.now();
   }

   public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAdress(){

        return adress;
    }

    public String getDateTimeLastEdit(){
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return myDateObjLastEdit.format(myFormatObj);
    }

    public String getInfo(){
        return this.name + " " + this.adress + " " + this.phoneNumber;
    }
}
