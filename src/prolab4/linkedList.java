package prolab4;

public class linkedList {
    
     tree parent;
     Dugum first;
     Dugum end;
     String usersID;
     String kategoriYolu;
     String name;
     int boyut;
     
     linkedList(String id,String name1){
         kategoriYolu=name1;
         String kelime[];
         kelime=name1.split(":");
         
         if(kelime.length==1)
            name=kelime[0];
         else if(kelime.length==2)
             name=kelime[1];
         else if(kelime.length>2)
             name=kelime[2];
         
         parent=null;
         first=null;
         end=null;
         usersID=id;
         boyut=0;
         
     }
     
     void addList(Dugum newNode){
         
         if(this.first==null){
             first=newNode;
             end=newNode;
         } else {
             this.end.sonraki=newNode;
             newNode.onceki=this.end;
             this.end=newNode;
         }
       this.boyut++;  
         
     }
     
       void yazdır(){
      Dugum temp;
      temp=this.first;
       
      while(temp!=null){
             System.out.println(temp.city); 
                System.out.println(temp.dateTime);  
                System.out.println(temp.lat);
                System.out.println(temp.lon);
                 System.out.println(temp.placeID);
                 temp=temp.sonraki;
      }
    }
    
}