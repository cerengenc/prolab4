package prolab4;

public class node implements Cloneable{
    
    tree kategori;
    String userID;
    int key;
    node left;
    node right;
    node parent;
    int number;
    int sayac=1;
    linkedList rezervasyon;
    int kullaniciSayisi;
    int rezervasyonS=0;
    
    node(String id,int value,int n,linkedList list){
        userID=id;
        key=value;
        number=n;
        left=null;
        right=null;
        parent=null;
        kategori=null;
        rezervasyon=list;
        rezervasyonS=value;
    }
    
    node(){}
    
    void addNode(String id,int value,linkedList list) {
        this.sayac++;
        node newNode=new node(id,value,this.sayac,list);
        this.inOrder(this.sayac,newNode);
        this.kullaniciSayisi=this.sayac;
        this.rezervasyonS=this.rezervasyonS+value;
        
        
    }
    
    void inOrder(int n,node newNode){
        
         
        if((this.number)*2 ==n){
            if(this.left==null){
                this.left=newNode;
                newNode.parent=this;
                return;
            }
            
        } else if(this.left==null)
            return;
        
        else this.left.inOrder(n,newNode);
        
          
        if(this.number*2 ==n-1){
            if(this.right ==null){
                this.right=newNode;
                newNode.parent=this;
                return;
            }
            
        } else if(this.right==null)
            return;
        
        else this.right.inOrder(n,newNode);
        
        
         
        return;
    }
    
    void yazdir(){
        
        
        if(this.left != null){
            this.left.yazdir();
            
        }
        
        System.out.println(""+this.userID);
            System.out.println(""+this.key);
        
        
        if(this.right != null){
            this.right.yazdir();
            
        }
        
    }
    
   
   
    
    int getRezervasyon() {
        
        return this.rezervasyonS;
    }
    
    

}