package contacts;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Base implements Serializable {

    String name;
    String phoneNumber;
    LocalDateTime myDateObj = LocalDateTime.now();
    LocalDateTime myDateObjLastEdit  = LocalDateTime.now();

    public boolean isPerson = false;

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
        myDateObjLastEdit  = LocalDateTime.now();
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
        myDateObjLastEdit  = LocalDateTime.now();
    }


    public String getDateTimeCreated(){
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return myDateObj.format(myFormatObj);
    }
    public String getDateTimeLastEdit(){
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return myDateObjLastEdit.format(myFormatObj);
    }
}
