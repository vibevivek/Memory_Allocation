// Implements Dictionary using Doubly Linked List (DLL)
// Implement the following functions using the specifications provided in the class List

public class A1List extends List {

    private A1List  next; // Next Node
    private A1List prev;  // Previous Node 

    public A1List(int address, int size, int key) { 
        super(address, size, key);
    }
    
    public A1List(){
        super(-1,-1,-1);
        // This acts as a head Sentinel

        A1List tailSentinel = new A1List(-1,-1,-1); // Intiate the tail sentinel
        
        this.next = tailSentinel;
        tailSentinel.prev = this;
    }

    public A1List Insert(int address, int size, int key)
    {
        A1List newNode=new A1List(address,size,key);
        newNode.next=this.next;
        newNode.prev=this;
        newNode.next.prev=newNode;
        this.next=newNode;
        return newNode;
        //return null;
    }

    public boolean Delete(Dictionary d) 
    {
        A1List current1=this;
        if (current1.key==d.key && current1.size==d.size && current1.address==d.address){
            return false;
        }
        A1List current2=this;
        boolean flag1=true;
        boolean flag2=true;
        if (current1.prev==null){
            current1=current1.next;
        }
        if (current2.next==null){
            current2=current2.prev;
        }
        while (flag1==true){
            while (current1.key!=d.key){
                if (current1.key==-1 && current1.next==null){
                    flag1=false;
                    break;
                }
                else{
                    current1=current1.next;
                }
            }
            if (flag1==true && (current1.size==d.size && current1.address==d.address)){
                current1.prev.next=current1.next;
                current1.next.prev=current1.prev;
                break;
            }
            else{
                current1=current1.next;
            }
        }
        while (flag2==true){
            while (current2.key!=d.key){
                if (current2.key==-1 && current2.prev==null){
                    flag2=false;
                    break;
                }
                else{
                    current2=current2.prev;
                }
            }
            if (flag2==true && (current2.size==d.size && current2.address==d.address)){
                current2.prev.next=current2.next;
                current2.next.prev=current2.prev;
                break;
            }
            else{
                current2=current2.prev;
            }
        }
        if (flag2==true || flag1==true){
            return true;
        }
        else{
            return false;
        }
        //return false;
    }

    public A1List Find(int k, boolean exact)
    {
        A1List current=this;
        current=current.getFirst();
        if (current==null){
            return null;
        }
        else if(exact==true){
            while (current.key!=k){
                if (current.next.next==null){
                    return null;
                }
                else{
                    current=current.next;
                }
            }
            return current;
        }
        else{
            while (current.key<k){
                if (current.next.next==null){
                    return null;
                }
                else{
                    current=current.next;
                }
            }
            return current; 
        }
    }
    public A1List getFirst()
    {
        A1List current=this;
        if (current.next==null){
            current=current.prev;
        }
        while (current.prev!=null){
            current=current.prev;
        }
        if (current.next.next==null){
            return null;
        }
        else{
            return current.next;
        }
        //return null;
    }
    
    public A1List getNext() 
    {
        A1List current=this;
        if (current.next==null){
            return null;
        }
        else if (current.next.next==null){
            return null;
        }
        else{
            return current.next;
        }
        //return null;
    }
    public boolean sanity()
    {
        A1List current1=this;
        if (current1.next==null && current1.prev==null){
            return false;// when list has only one element
        }
        A1List current2=this;
        while (current1!=null && current2!=null && current2.next!=null){
            current1=current1.next;
            current2=current2.next.next;
            if (current1==current2){
                return false;// detects cycle when going from any node in forward direction
            }
        }
        A1List current3=this;
        A1List current4=this;
        while (current3!=null && current4!=null && current4.prev!=null){
            current3=current3.prev;
            current4=current4.prev.prev;
            if (current3==current4){
                return false;//detects cycle when going from any node in backward direction
            }
        }
        A1List current=this;
        while (current.prev!=null){
            current=current.prev;
        }
        if (current.key!=-1){ //headSentinel don't have key value as -1
            return false;
        }
        while (current.next!=null){
            if (current.next.prev!=current){
                return false;
            }
            current=current.next; 
        }
        if (current.next==null && current.key!=-1){ // tailSentinel don't have key value as -1
            return false;
        }
        while (current.prev!=null){
            if (current.prev.next!=current){
                return false;
            }
            current=current.prev;
        }
        return true;
    }
}


