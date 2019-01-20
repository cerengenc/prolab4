package prolab4;

import java.util.ArrayList;

public class tree {
   
    ArrayList <tree> child=new ArrayList();
    tree parent;
    String name;
    node kullanici;
    int derinlik;
    int rezervasyonSayisi; 
    
    tree(String name){
      name="rezervasyon";
      parent=null;
      kullanici=null;
      derinlik=0;
    }
    
    tree(){}
    
    void addChild(String kategori){
        tree childNode=new tree();
        childNode.name=kategori;
        childNode.parent=this;
        childNode.derinlik=1;
        this.child.add(childNode);
        
    }
    
    void addChild1(String kategori,String Akategori){
        tree childNode=new tree();
        int index=0;
        for(int i=0;i<this.child.size();i++){
            if(kategori.equals(this.child.get(i).name)){
                index=i;
                break;
            }
        }
        childNode.name=Akategori; 
        childNode.parent=this.child.get(index);
        childNode.derinlik=2;
        this.child.get(index).child.add(childNode);
        
    }
    
    void addChild2(String kategori,String Akategori,String Akategori2){
        tree childNode=new tree();
        int index=0;
        for(int i=0;i<this.child.size();i++){
            if(kategori.equals(this.child.get(i).name)){
                index=i;
                break;
            }
    }
       int index2=0;
        for(int i=0;i<this.child.get(index).child.size();i++){
          if(Akategori.equals(this.child.get(index).child.get(i).name)){
              index2=i;
              break;
          }  
        }
        
        childNode.name=Akategori2;
        childNode.parent=this.child.get(index).child.get(index2);
        childNode.derinlik=3;
        this.child.get(index).child.get(index2).child.add(childNode);
        
        
}
    void addNew(String name,tree newNode){
        int index=0;
        for(int i=0;i<this.child.size();i++){
            if(name.equals(this.child.get(i).name)){
                index=i;
                break;
            }
        }
        newNode.derinlik=1;
        newNode.parent=this.child.get(index);
        this.child.get(index).child.add(newNode);
        
    }
    
    void addChild3(String kategori,String Akategori,String Akategori2,String Akategori3,tree root){
        tree childNode=new tree();
        int index=0;
        for(int i=0;i<root.child.size();i++){
            if(kategori.equals(root.child.get(i).name)){
                index=i;
                break;
            }
    }
       int index2=0;
        for(int i=0;i<root.child.get(index).child.size();i++){
          if(Akategori.equals(root.child.get(index).child.get(i).name)){
              index2=i;
              break;
          }   
        }
        int index3=0;
        for (int l = 0; l < root.child.get(index).child.get(index2).child.size(); l++) {
            
            if(Akategori2.equals(root.child.get(index).child.get(index2).child.get(l).name)){
                
                index3=l;
                break;
            }
        }
        
        childNode.name=Akategori3;
        childNode.parent=root.child.get(index).child.get(index2).child.get(index3);
        root.child.get(index).child.get(index2).child.get(index3).child.add(childNode);
          
        
        
        
    }
  
}