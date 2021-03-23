// Class: A1DynamicMem
// Implements DynamicMem
// Does not implement defragment (which is for A2).

public class A1DynamicMem extends DynamicMem {
      
    public A1DynamicMem() {
        super();
    }

    public A1DynamicMem(int size) {
        super(size);
    }

    public A1DynamicMem(int size, int dict_type) {
        super(size, dict_type);
    }

    public void Defragment() {
        return ;
    }

    // In A1, you need to implement the Allocate and Free functions for the class A1DynamicMem
    // Test your memory allocator thoroughly using Doubly Linked lists only (A1List.java).

    public int Allocate(int blockSize) {
        Dictionary temp=freeBlk.Find(blockSize,false);
        if (temp==null){
            return -1;
        }
        else{
            freeBlk.Delete(temp);
            temp.address=temp.address+blockSize;
            temp.size=temp.size-blockSize;
            temp.key=temp.size;
            freeBlk.Insert(temp.address,temp.size,temp.key);
            allocBlk.Insert(temp.address-blockSize,blockSize,temp.address-blockSize);
            return temp.address-blockSize;
        }
        //return -1;
    } 
    
    public int Free(int startAddr) {
        //return -1;
        Dictionary temp=allocBlk.Find(startAddr,true);
        if (temp==null){
            return -1;
        }
        else{
            allocBlk.Delete(temp);
            freeBlk.Insert(temp.key,temp.size,temp.size);
            return 0;
        }
    }
}