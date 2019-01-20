package prolab4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class kullanici{
    String userID;
    ArrayList <linkedList> list=new ArrayList();
    
    
   void kullaniciNode (String satir) {
      
       String kelime[];
       kelime=satir.split(",");
       this.userID=kelime[0];
       linkedList liste=new linkedList(kelime[0],kelime[6]);
       Dugum node=new Dugum(satir);
       liste.addList(node);
       list.add(liste);
           
   }
   
   void addKategori(String satir){
       String kelime[];
       int index=0;
       kelime=satir.split(",");
       String kelime2[];
       kelime2=kelime[6].split(":");
       boolean varMi=false;
       
       if(kelime2.length==1){
           for(int i=0;i<this.list.size();i++){
               if(kelime2[0].equals(this.list.get(i).name)){
                 index=i;
                 varMi=true;
               }
                   
           }
       }
       
       else if(kelime2.length==2){
            for(int i=0;i<this.list.size();i++){
               if(kelime2[1].equals(this.list.get(i).name)){
                   index=i;
                 varMi=true;
               }
                   
       }
       }

            else if(kelime2.length>2){
                    for(int i=0;i<this.list.size();i++){
               if(kelime2[2].equals(this.list.get(i).name)){
                   index=i;
                   varMi=true;
               }
                   
       }
                    }
        if(varMi==true)
            addNode(this.list,satir,index);
        else{
            linkedList liste=new linkedList(this.userID,kelime[6]);
            this.list.add(liste);
            addNode(this.list,satir,this.list.size()-1);
        }
           
        
   }
   
   void addNode(ArrayList <linkedList> list,String satir,int index){
       
       Dugum node=new Dugum(satir);
       list.get(index).addList(node);
       
   }
}