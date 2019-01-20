package prolab4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Prolab4 {

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        
        
        File dosya=new File("rezervasyon.txt");
        Scanner keyboard=new Scanner(System.in);
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(dosya));
        ArrayList <kullanici> users=new ArrayList();
        kullanici temp=new kullanici();
        String kelime[];
        String satir = reader.readLine();
        int i=0,j=-1;
        
        temp.kullaniciNode(satir); //ilk kullanici eklendi
        users.add(temp);
        
        satir = reader.readLine();
        
            while (satir!=null) {
                j=i;
                kelime=satir.split(",");
                if(users.get(i).userID.equals(kelime[0])==false )
                    i++;
                 
                if(j != i){
                kullanici temp1=new kullanici();
                temp1.kullaniciNode(satir);
                users.add(temp1);
                }  else{
                   users.get(i).addKategori(satir);
                }
              
              satir = reader.readLine();
              
            }
    
            
        
       tree root=new tree("rezervasyon"); //ana dugum 
        ArrayList <String> kategori=new ArrayList();
        ArrayList <String> AltKategori=new ArrayList();
        ArrayList <String> AltKategori2=new ArrayList();
        
        boolean var;
           for(int k=0;k<users.size();k++){
               for(i=0;i<users.get(k).list.size();i++){
                    kelime=users.get(k).list.get(i).kategoriYolu.split(":");
                 
                 if(kelime.length==1){
                     var=varMi(kelime[0],kategori);
                     
                     if(var==false){
                         root.addChild(kelime[0]);
                         kategori.add(kelime[0]);
                 }
                 }   
                 if(kelime.length==2){
                      var=varMi(kelime[0],kategori);
                     
                     if(var==false){
                         root.addChild(kelime[0]);
                         kategori.add(kelime[0]);
                 }
                    var=varMi(kelime[1],AltKategori);
                    
                       if(var==false){
                         root.addChild1(kelime[0],kelime[1]);
                         AltKategori.add(kelime[1]);
                 }
                 }
                if(kelime.length>2){
                     var=varMi(kelime[0],kategori);
                     
                     if(var==false){
                         root.addChild(kelime[0]);
                         kategori.add(kelime[0]);
                 }
                    var=varMi(kelime[1],AltKategori);
                    
                       if(var==false){
                         root.addChild1(kelime[0],kelime[1]);
                         AltKategori.add(kelime[1]);
                 }
                  var=varMi(kelime[2],AltKategori2);
                  
                      if(var==false){
                         root.addChild2(kelime[0],kelime[1],kelime[2]);
                         AltKategori2.add(kelime[2]);
                 }
                }
               }
             
           }
        
             
        
        String yol;
        int sayac=0;
        for(i=0;i<users.size();i++){
            for(j=0;j<users.get(i).list.size();j++){
                yol=users.get(i).list.get(j).kategoriYolu;
                kelime=yol.split(":");
                if(kelime.length==1){
                   addUsers(root,users.get(i),kelime[0]);
                }
                if(kelime.length==2){
                   addUsers2(root,users.get(i),kelime[0],kelime[1]); 
                }
                
                if(kelime.length>2){
                  addUsers3(root,users.get(i),kelime[0],kelime[1],kelime[2]);         
                }
            }
        }
        
        /*for (int k = 0; k < root.child.size(); k++) {
            if(root.child.get(k).kullanici==null)
                root.child.get(k).rezervasyonSayisi=0;
            else
            root.child.get(k).rezervasyonSayisi=root.child.get(k).kullanici.getRezervasyon();
                for (int l = 0; l <root.child.get(k).child.size(); l++) {
                if(root.child.get(k).child.get(l).kullanici==null)
                    root.child.get(k).child.get(l).rezervasyonSayisi=0;
                else
                root.child.get(k).child.get(l).rezervasyonSayisi=root.child.get(k).child.get(l).kullanici.getRezervasyon();
                    for (int m = 0; m <root.child.get(k).child.get(l).child.size(); m++) {
                        if(root.child.get(k).child.get(l).child.get(m).kullanici==null)
                            root.child.get(k).child.get(l).child.get(m).rezervasyonSayisi=0;
                        else
        root.child.get(k).child.get(l).child.get(m).rezervasyonSayisi=root.child.get(k).child.get(l).child.get(m).kullanici.getRezervasyon();

                    }
       
            }
        }*/
        Scanner key=new Scanner(System.in);
  
       int evet=1;
       String islem,islem2;
        
               while(evet==1){
            System.out.println("Kategori bulma");
            System.out.println("Yeni kategori ekleme");
            System.out.println("Kategori silme");
            System.out.println("Kullanıcı ekleme");
            System.out.println("Kullanıcıya göre kategori listeleme");
            System.out.println("Kategoriye göre kullanici listeleme");
            System.out.println("Rezervasyon yerine gore kullanici listeleme");
            System.out.println("Kullaniciya göre rezervasyon listeleme");
            System.out.println("Hangi islemi yapmak istiyorsunuz?");
            
            islem=keyboard.nextLine();
                if(islem.equalsIgnoreCase("Kategori bulma")){
                    System.out.println("Aranacak kategori?");
                    islem2=keyboard.nextLine();
                    kategoribulma(islem2,root);
                }
               if(islem.equalsIgnoreCase("Yeni kategori ekleme")){
                   kategoriEkle(root);
               }
               if(islem.equalsIgnoreCase("Kategori silme")){
                   kategoriSil(root);
               }
               if(islem.equalsIgnoreCase("Kullaniciya gore kategori listeleme")){
                   System.out.println("Listelemek istediginiz kullanici?");
                   islem2=keyboard.nextLine();
                   kullanicikategoriliste(islem2,users);
               }
               if(islem.equalsIgnoreCase("Kategoriye gore kullanici listeleme")){
                   System.out.println("Listelemek istediginiz kategori?");
                   islem2=keyboard.nextLine();
                   kategoriKullaniciListele(islem2,root);
               }
               if(islem.equalsIgnoreCase("Rezervasyon yerine gore kullanici listeleme")){
                   System.out.println("Listelemek istediginiz rezervasyon yeri?");
                   islem2=keyboard.nextLine();
                           
                   rezervasyonYeriniListele(islem2,root,users);
                   
               }
               if(islem.equalsIgnoreCase("Kullaniciya gore rezervasyon listeleme")){
           System.out.println("Rezervasyonunu listelemek istediginiz kulanici?");
                       islem2=keyboard.nextLine();
                     kullanicirezervasyonliste(islem2,users,root);
               }
             
               if(islem.equalsIgnoreCase("Kullanici ekleme")){
                   System.out.println("Eklemek istediginiz kategori?");
                   islem2=keyboard.nextLine();
                   kullaniciEkle(islem2,root,users,dosya);
               }
        System.out.println("Çıkmak icin 0'a,devam etmek icin herhangi bir tusa basiniz.");
        evet=key.nextInt();
               
        }
        
               for(i=0;i<root.child.size();i++){
            System.out.println("Ana kategori:");
                   System.out.println("Derinlik");
                   System.out.println(root.child.get(i).derinlik);
                   System.out.println("rezervason sayisi:");
                   System.out.println(root.child.get(i).rezervasyonSayisi);
                   
        System.out.println(""+root.child.get(i).name);
            
            for(j=0;j<root.child.get(i).child.size();j++){
                System.out.println("Alt kategoriler:");
                System.out.println("Derinlik");
                System.out.println(root.child.get(i).child.get(j).derinlik);
                System.out.println("rezervason sayisi:");
                System.out.println(root.child.get(i).child.get(j).rezervasyonSayisi);
             System.out.println(""+root.child.get(i).child.get(j).name);
             if(root.child.get(i).child.get(j).kullanici != null){
                    root.child.get(i).child.get(j).kullanici.yazdir();
                    //System.out.println(""+root.child.get(i).child.get(j).kullanici.rezervasyon.boyut);
             }
                for(int k=0;k<root.child.get(i).child.get(j).child.size();k++){
                    System.out.println("ikinci alt kategoriler:");
                    System.out.println("derinlik");
                    System.out.println("rezervason sayisi:");
                    System.out.println(""+root.child.get(i).child.get(j).child.get(k).rezervasyonSayisi);
                    System.out.println(""+root.child.get(i).child.get(j).child.get(k).derinlik);
                    System.out.println(""+root.child.get(i).child.get(j).child.get(k).name);
                    if(root.child.get(i).child.get(j).child.get(k).kullanici != null){
                        root.child.get(i).child.get(j).child.get(k).kullanici.yazdir();
                       // System.out.println(""+root.child.get(i).child.get(j).child.get(k).kullanici.rezervasyon.boyut);
                }
                }
        }
    }
  
    }
    
    static boolean varMi(String name,ArrayList <String> kategori){
        boolean var = false;
        for(int i=0;i<kategori.size();i++){
                 if(kategori.get(i).equals(name)){
                     var=true;
                     break;
                 }
             }
        return var;
    }
    
    static void addUsers(tree root,kullanici user,String kelime) {
        
        int index = 0;
        for(int j=0;j<user.list.size();j++){
                  if(kelime.equals(user.list.get(j).name)){
                      index=j;
                  }  
                }
        
        for(int i=0;i<root.child.size();i++){
            if(root.child.get(i).name.equals(kelime)){
                if(root.child.get(i).kullanici==null){
                    node newNode=new node(user.userID,user.list.get(index).boyut,1,user.list.get(index));
                    newNode.kategori=root.child.get(i);
                   root.child.get(i).kullanici=newNode;
                } else {
                root.child.get(i).kullanici.addNode(user.userID,user.list.get(index).boyut,user.list.get(index));
                
            }
            }
        }
    }
    
    static void addUsers2(tree root,kullanici user,String kelime,String kelime2){
        
        int index=0,index2=0;
        
        for(int j=0;j<user.list.size();j++){
                  if(kelime.equals(user.list.get(j).name)){
                      index=j;
                  } 
                  
                  else if(kelime2.equals(user.list.get(j).name)){
                      index=j;
                  } 
                }
        
        for(int i=0;i<root.child.size();i++){
            if(root.child.get(i).name.equals(kelime))
                index2=i;
        }
        
        for(int j=0;j<root.child.get(index2).child.size();j++){
            if(root.child.get(index2).child.get(j).name.equals(kelime2)){
                if(root.child.get(index2).child.get(j).kullanici==null){
                    node newNode=new node(user.userID,user.list.get(index).boyut,1,user.list.get(index));
                    newNode.kategori=root.child.get(index2).child.get(j);
                    root.child.get(index2).child.get(j).kullanici=newNode;
                   
                    
                } else{
        root.child.get(index2).child.get(j).kullanici.addNode(user.userID,user.list.get(index).boyut,user.list.get(index));
        
            }
            }
        }
    }
    
    static void addUsers3(tree root,kullanici user,String kelime,String kelime2,String kelime3){
        int index=0,index1=0,index2=0;
      for(int j=0;j<user.list.size();j++){
                  if(kelime.equals(user.list.get(j).name)){
                      index=j;
                  }  
                  
                  else if(kelime2.equals(user.list.get(j).name)){
                      index=j;
                  }
                  
                  else if(kelime3.equals(user.list.get(j).name)){
                      index=j;
                  }
                }
      
      for(int i=0;i<root.child.size();i++){
            if(root.child.get(i).name.equals(kelime))
                index1=i;
        }
      
      for(int i=0;i<root.child.get(index1).child.size();i++){
          if(root.child.get(index1).child.get(i).name.equals(kelime2))
              index2=i;
      }
      
      for(int i=0;i<root.child.get(index1).child.get(index2).child.size();i++){
          if(root.child.get(index1).child.get(index2).child.get(i).name.equals(kelime3)){
              if(root.child.get(index1).child.get(index2).child.get(i).kullanici==null){
                  node newNode=new node(user.userID,user.list.get(index).boyut,1,user.list.get(index));
                  newNode.kategori=root.child.get(index1).child.get(index2).child.get(i);
                  root.child.get(index1).child.get(index2).child.get(i).kullanici=newNode;

              } else{
root.child.get(index1).child.get(index2).child.get(i).kullanici.addNode(user.userID,user.list.get(index).boyut,user.list.get(index));

          }
          }
      }
    }
    
     static void kategoribulma(String aranankategori,tree root ){
       Scanner keyboard = new Scanner(System.in);
       Scanner keyboard1 = new Scanner(System.in);
       boolean varmı=false;
       boolean varmı2=false;
       boolean varmı3=false;
       int index,index2,index3 = 0;
                      for (int i = 0; i <root.child.size() ; i++) {
           
           if(aranankategori.equalsIgnoreCase(root.child.get(i).name)==true){
               index=i;
               System.out.println("ana kategori"+root.child.get(i).name);
               for (int j = 0; j <root.child.get(i).child.size(); j++) {
           System.out.println("alt kategori"+root.child.get(i).child.get(j).name);
                   for (int k = 0; k < root.child.get(i).child.get(j).child.size(); k++) {
                       System.out.println("ikinci kategori"+root.child.get(i).child.get(j).child.get(k).name);
                   }
               }
               
               System.out.println("BU KATEGORİNİN ALTINA YENİ KATEGORİ EKLEMEK İSTER MİSİNİZ EVET İSE 1 BASINIZ");
               int choose ;
               choose=keyboard1.nextInt();
               if(choose==1){
                  
                   String eklenecek;
                   System.out.println("eklenecek kategori ismini giriniz");
                   eklenecek=keyboard.nextLine();
                    
                   for (int u = 0; u <root.child.get(index).child.size(); u++) {
                       if(eklenecek.equalsIgnoreCase(root.child.get(index).child.get(u).name)){
                           varmı=true;
                           
                           
                       }
                       
                   }
                   if(varmı==false){
                  root.addChild1(root.child.get(index).name, eklenecek);
                   
                   }
                   else{
                       System.out.println("kategori zaten var islem iptal edildi");
                   }
                   
               } else
                   return;
               
           }
       
           for (int l = 0; l <root.child.get(i).child.size(); l++) {
               
               if (aranankategori.equalsIgnoreCase(root.child.get(i).child.get(l).name)==true) {
                   
                   index2=l;
                   index=i;
                   System.out.println("ana kategorisi"+root.child.get(i).child.get(l).parent.name);
                   System.out.println("alt kategori"+root.child.get(i).child.get(l).name);
                   for (int r = 0; r <root.child.get(i).child.get(l).child.size(); r++) {
                       System.out.println("ikinci kategori"+root.child.get(i).child.get(l).child.get(r).name);
                   }
                   System.out.println("BU KATEGORİNİN ALTINA YENİ KATEGORİ EKLEMEK İSTER MİSİNİZ EVET İSE 1 BASINIZ");
                   int choose ;
               choose=keyboard1.nextInt();
               if(choose==1){
                  
                   String eklenecek;
                   System.out.println("eklenecek kategori ismini giriniz");
                 eklenecek=keyboard.nextLine();
                  
                                  
                   for (int e = 0; e <root.child.get(i).child.get(index2).child.size(); e++) {
                     
                       
                       
                       if(eklenecek.equalsIgnoreCase(root.child.get(i).child.get(index2).child.get(e).name)==true){
                           varmı2=true;
                           
                       }
                       
                   }
                   if(varmı2==false)
                   root.addChild2(root.child.get(i).name,root.child.get(i).child.get(index2).name, eklenecek);
                   else if(varmı2==true) {
                       System.out.println("kategori zaten var islem iptal edildi"); 
                   }
                
               } else
                   return;
                   
                   
               }
               for (int v = 0; v <root.child.get(i).child.get(l).child.size(); v++) {
                   if(aranankategori.equalsIgnoreCase(root.child.get(i).child.get(l).child.get(v).name)==true){
                          index3 = v;
                       System.out.println("ana kategori"+root.child.get(i).child.get(l).child.get(v).parent.parent.name);
                       System.out.println("alt kategori"+root.child.get(i).child.get(l).child.get(v).parent.name);
                       System.out.println("ikinci kategori"+root.child.get(i).child.get(l).child.get(v).name);
                         System.out.println("BU KATEGORİNİN ALTINA YENİ KATEGORİ EKLEMEK İSTER MİSİNİZ EVET İSE 1 BASINIZ");
                   int choose ;
               choose=keyboard.nextInt();
             
                         if(choose==1){
                   String eklenecek;
                   System.out.println("eklenecek kategori ismini giriniz");
                   eklenecek=keyboard.next();
                             for (int q = 0; q < root.child.get(i).child.get(l).child.get(index3).child.size(); q++) {
                                 
                                 if(eklenecek.equalsIgnoreCase(root.child.get(i).child.get(l).child.get(index3).child.get(q).name)){
                                     varmı3=true;
                                 }
                             }
                             if(varmı3==false)
root.addChild3(root.child.get(i).name,root.child.get(i).child.get(l).name,root.child.get(i).child.get(l).child.get(index3).name ,eklenecek,root);
                             else{
                                  System.out.println("kategori zaten var islem iptal edildi");
                             }      
                
               } else
                             return;
                   }
               }
               
           }
           
           
       }
   }
     
     
public static void kullanicikategoriliste(String kullanici ,ArrayList <kullanici> users){
      
      for (int i = 0; i <users.size(); i++) {
           
          if (kullanici.equals(users.get(i).userID)) {
               for (int j = 0; j <users.get(i).list.size() ; j++) {
                   System.out.println(users.get(i).list.get(j).kategoriYolu);
              }
              
              
          }
      }
      
      
      
      
      
  }

   
       static void kategoriEkle(tree root){
           
           Scanner keyboard=new Scanner(System.in);
           System.out.println("Eklenecek kategori?");
           String eklenecek=keyboard.nextLine();
           boolean var=false;
           int index=-1;
           for(int i=0;i<root.child.size();i++){
               if(eklenecek.equalsIgnoreCase(root.child.get(i).name)){
                   var=true;
                   index=i;
                   break;
               }
       }
           
                if(var == true){
            System.out.println("Bu kategori var.İşlem iptal edildi.");
            return;
            } else {
                    root.addChild(eklenecek);
                }
  
}
       
       static void kategoriSil(tree root){
           System.out.println("Silinicek kategori?");
           Scanner keyboard=new Scanner(System.in);
           String silinecek=keyboard.nextLine();
           int index1=-1,index2=-1,index3=-1;
           for (int i = 0; i < root.child.size(); i++) {
               if(silinecek.equalsIgnoreCase(root.child.get(i).name)){
                   index1=i;
                   break;
               }
           }
           
           if(index1 == -1){
               for(int j=0;j<root.child.size();j++)
               for (int i = 0; i <root.child.get(j).child.size(); i++) {
      if(silinecek.equalsIgnoreCase(root.child.get(j).child.get(i).name)){
          index1=j;
          index2=i;
          break;
      }
               }
           }
           
           if(index2 == -1 && index1==-1){
      for(int j=0;j<root.child.size();j++)
          for(int k=0;k<root.child.get(j).child.size();k++)
      for (int i = 0; i <root.child.get(j).child.get(k).child.size(); i++) {
       if(silinecek.equalsIgnoreCase(root.child.get(j).child.get(k).child.get(i).name))  {
           index1=j;
           index2=k;
           index3=i;
           break;
       }          
               }
           }
           
           if(index1==-1 && index2==-1 && index3==-1){
               System.out.println("Böyle bir kategori bulunmamakta.");
               return;
           }
           if(index2==-1 && index3==-1){
               root.child.remove(root.child.get(index1));
           }
           if(index3==-1 && index2 != -1 && index1 !=-1){    
       for(int i=0;i<root.child.get(index1).child.get(index2).child.size();i++){
               root.addNew(root.child.get(index1).name,root.child.get(index1).child.get(index2).child.get(i));
               }
               root.child.get(index1).child.remove(root.child.get(index1).child.get(index2));
           }
           
           if(index3 != -1){
      root.child.get(index1).child.get(index2).child.remove(root.child.get(index1).child.get(index2).child.get(index3));
           }
           
       }

        static void kategoriKullaniciListele(String kategori,tree root){
                   int index1=-1,index2=-1,index3=-1;
           for (int i = 0; i < root.child.size(); i++) {
               if(kategori.equalsIgnoreCase(root.child.get(i).name)){
                   index1=i;
                   break;
               }
           }
           
           if(index1 == -1){
               for(int j=0;j<root.child.size();j++)
               for (int i = 0; i <root.child.get(j).child.size(); i++) {
      if(kategori.equalsIgnoreCase(root.child.get(j).child.get(i).name)){
          index1=j;
          index2=i;
          break;
      }
               }
           }
           
           if(index2 == -1 && index1==-1){
      for(int j=0;j<root.child.size();j++)
          for(int k=0;k<root.child.get(j).child.size();k++)
      for (int i = 0; i <root.child.get(j).child.get(k).child.size(); i++) {
       if(kategori.equalsIgnoreCase(root.child.get(j).child.get(k).child.get(i).name))  {
           index1=j;
           index2=k;
           index3=i;
           break;
       }          
               }
           }
           
           if(index1==-1 && index2==-1 && index3==-1){
               System.out.println("Böyle bir kategori bulunmamakta.");
               return;
           }
           
           if(index1==-1 && index2==-1 && index3==-1){
               System.out.println("Boyle bir kategori bulunmamakta.");
               return;
           }
           else if(index1 != 1 && index2==-1 && index3==-1){
               if(root.child.get(index1).kullanici != null){
               printTree(root.child.get(index1).kullanici); }      
            else
                System.out.println("Bu kategoriye baglı kullanici yoktur.");
           }
        
           else if(index1 != -1 && index2 != -1 && index3==-1){
                if(root.child.get(index1).child.get(index2).kullanici != null){
                 printTree(root.child.get(index1).child.get(index2).kullanici);
                } else
                    System.out.println("Bu kategoriye bagli kullanici yoktur.");
}
           else if(index1 != -1 && index2 != -1 && index3 != -1){
          
                if(root.child.get(index1).child.get(index2).child.get(index3).kullanici != null) {
           printTree(root.child.get(index1).child.get(index2).child.get(index3).kullanici );    
           } else
                    System.out.println("Bu kategoriye bagli kullanici yoktur.");
            }
        }
        
        static void rezervasyonYeriniListele(String yer,tree root,ArrayList<kullanici> users){
            ArrayList <String> kullanicilar=new ArrayList();
            boolean varMi=false;
            for (int i = 0; i <users.size(); i++) {
                for (int j = 0; j < users.get(i).list.size(); j++) {
                    Dugum temp=users.get(i).list.get(j).first;
                    while(temp != null){
                        if(temp.placeID.equalsIgnoreCase(yer)){
                            for(int k=0;k<kullanicilar.size();k++){
                               if(users.get(i).userID.equals(kullanicilar.get(k))){
                                   varMi=true;
                                   break;
                               } 
                            }if(varMi==false)
                            kullanicilar.add(users.get(i).userID);
                        }
                        temp=temp.sonraki;
                        varMi=false;
                    }
                }
                
            }
            
            for (int i = 0; i <kullanicilar.size(); i++) {
                System.out.println(""+kullanicilar.get(i));
                
            }
        }
 static void kullanicirezervasyonliste(String kullanici,ArrayList<kullanici>users,tree root){
          ArrayList <String> placeID=new ArrayList();
          ArrayList <String> lat=new ArrayList();
          ArrayList <String> lon=new ArrayList();
          ArrayList <String> city=new ArrayList();
          ArrayList <String> time=new ArrayList();
          int index=-1,index1=-1;
          int deger=0;
          boolean var=false,yap=false;
              
          for (int i = 0; i < users.size(); i++) {
              if(users.get(i).userID.equals(kullanici)){
                  index=i;
                  break;
              }
     }
          if(index==-1){
              System.out.println("Boyle bir kullanici bulunmamakta.");
              return;
          }
                  for (int j = 0; j <users.get(index).list.size(); j++) {
                      Dugum temp=users.get(index).list.get(j).first;
                        while(temp != null){
                            for (int k = 0; k <placeID.size(); k++) {
                                if(placeID.get(k).equals(temp.placeID)){
                                   index1=k;
                                   var=true;
                                   break;
                                }
                            }
                            if(var==false){
                                placeID.add(temp.placeID);
                                lat.add(temp.lat);
                                lon.add(temp.lon);
                                city.add(temp.city);
                                time.add(temp.dateTime);
                            } else{
                                String kelime[]=time.get(index1).split("T");
                                String kelime2[]=temp.dateTime.split("T");
                                String kelime3[]=kelime[0].split("-");
                                String kelime4[]=kelime2[0].split("-");
                                String kelime5[]=kelime[1].split(":");
                                String kelime6[]=kelime2[1].split(":");
                                
                                for (int i = 0; i <kelime3.length; i++) {
                                    if(Integer.valueOf(kelime3[i])<Integer.valueOf(kelime4[i]))
                                    deger=1;
                                }
                                
                                for (int i = 0; i <kelime5.length; i++) {
                                    if(Integer.valueOf(kelime5[i])<Integer.valueOf(kelime6[i]))
                                    deger=1;
                                }
                                
                                
                            if(deger==1)
                                    yap=true;
                            yap=true;
                                if(yap==true){
                                placeID.remove(index1);
                                lat.remove(index1);
                                lon.remove(index1);
                                city.remove(index1);
                                time.remove(index1);
                                
                                placeID.add(temp.placeID);
                                lat.add(temp.lat);
                                lon.add(temp.lon);
                                city.add(temp.city);
                                time.add(temp.dateTime);
                            }
                        }
                      temp=temp.sonraki;
                            var=false;
                            index1=-1;
                            yap=false;  
                            deger=0;
                  }
                  }
      for (int i = 0; i <placeID.size(); i++) {
          System.out.println(""+placeID.get(i));
          System.out.println(""+lat.get(i));
          System.out.println(""+lon.get(i));
          System.out.println(""+city.get(i));
          System.out.println("Son rezervasyon tarihi:"+time.get(i));
          System.out.println("");
     }
       
       }
       
        static void printTree(node tree){
            if(tree.left != null){
            printTree(tree.left);
            
        }
        
        System.out.println(""+tree.userID);
        
        if(tree.right != null){
            printTree(tree.right);
            
        }
        }
     
        static void kullaniciEkle(String kategori,tree root,ArrayList <kullanici> users,File file) throws IOException{
            
            Scanner keyboard=new Scanner(System.in);
            int index1=-1,index2=-1,index3=-1;
            for (int i = 0; i <root.child.size(); i++) {
                if(root.child.get(i).name.equals(kategori)){
                    index1=i;
                    break;
                }
            }
            
            for (int i = 0; i <root.child.size(); i++) {
                for (int j = 0; j <root.child.get(i).child.size(); j++) {
                    if(root.child.get(i).child.get(j).name.equals(kategori)){
                        index1=i;
                        index2=j;
                        break;
                    }
                }
            }
            
            for (int i = 0; i <root.child.size(); i++) {
                for (int j = 0; j <root.child.get(i).child.size(); j++) {
        for (int k = 0; k <root.child.get(i).child.get(j).child.size(); k++) {
          if(root.child.get(i).child.get(j).child.get(k).name.equals(kategori)){
              index1=i;
              index2=j;
              index3=k;
              break;
          }  
                    }
                }
            }
            
            if(index1==-1 && index2==-1 && index3==-1){
                System.out.println("Boyle bir kategori bulunmamakta.");
                return;
            }
            int deger=0;
           System.out.println("Eklemek istediğiniz kullanici adı?");
           String name=keyboard.nextLine();
            
            for (int i = 0; i <users.size(); i++) {
                if(name.equalsIgnoreCase(users.get(i).userID)){
                    deger=1;
                    break;
                }
            }
            
            if(deger==1){
                System.out.println("Bu kullanici var.İslem iptal edildi.");
                return;
            } else{
                String satir;
   System.out.println("Kullanici bilgilerini txt dosyasi icindeki \nformata uygun yaziniz.");
   satir=keyboard.nextLine();
   
                kullanici temp=new kullanici();
                temp.kullaniciNode(satir);
                users.add(temp);
                Dugum node=new Dugum(satir);
                
                users.get(users.size()-1).list.get(0).addList(node);
                linkedList list=users.get(users.size()-1).list.get(0);
                
                FileWriter fileWriter = new FileWriter(file,true);
                BufferedWriter bWriter = new BufferedWriter(fileWriter);
                bWriter.newLine() ;
                 bWriter.write(satir);
                 bWriter.close();
                
                if(index1 != -1 && index2==-1 && index3==-1){
                    if(root.child.get(index1).kullanici == null){
                  Dugum newNode=new Dugum(satir);
                    list.addList(newNode);
                  node newNode2=new node(name,1,1,list);
                  root.child.get(index1).kullanici=newNode2;
                  list.parent=root.child.get(index1);
                    } else
                  root.child.get(index1).kullanici.addNode(name,1,list);
                }
                
                else if(index1 != -1 && index2 != -1 && index3==-1){
                    if(root.child.get(index1).child.get(index2).kullanici==null){
  Dugum newNode=new Dugum(satir);
  list.addList(newNode);
  list.parent=root.child.get(index1).child.get(index2);
  node newNode2=new node(name,1,1,list);
  root.child.get(index1).child.get(index2).kullanici=newNode2;
                
                } else
  root.child.get(index1).child.get(index2).kullanici.addNode(name,1,list);
                  
                }
                
                else if(index1 != -1 && index2 != -1 && index3 != -1){
                    if(root.child.get(index1).child.get(index2).child.get(index3).kullanici==null){
Dugum newNode=new Dugum(satir);
list.addList(newNode);
list.parent=root.child.get(index1).child.get(index2).child.get(index3);
node newNode2=new node(name,1,1,list);
root.child.get(index1).child.get(index2).child.get(index3).kullanici=newNode2;

                } else
root.child.get(index1).child.get(index2).child.get(index3).kullanici.addNode(name,1, list);
                }
            }
 
}
}