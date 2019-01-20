package prolab4;

public class Dugum {
    
    String placeID;
    String dateTime;
    String lat;
    String lon;
    String city;
    Dugum onceki;
    Dugum sonraki;
    
    Dugum(String satir){
        onceki=null;
        sonraki=null;
        
        String kelime[];
        kelime=satir.split(",");
        
        placeID=kelime[1];
        dateTime=kelime[2];
        lat=kelime[3];
        lon=kelime[4];
        city=kelime[5];
        
    }
    
}
  
