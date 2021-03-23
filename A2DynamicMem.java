// Class: A2DynamicMem
// Implements Degragment in A2. No other changes should be needed for other functions.

public class A2DynamicMem extends A1DynamicMem {
      
    public A2DynamicMem() {  super(); }

    public A2DynamicMem(int size) { super(size); }

    public A2DynamicMem(int size, int dict_type) { super(size, dict_type); }

    // In A2, you need to test your implementation using BSTrees and AVLTrees. 
    // No changes should be required in the A1DynamicMem functions. 
    // They should work seamlessly with the newly supplied implementation of BSTrees and AVLTrees
    // For A2, implement the Defragment function for the class A2DynamicMem and test using BSTrees and AVLTrees. 
    public int Allocate(int blockSize) {
        if (blockSize<=0){
            return -1;
        }
        Dictionary temp=freeBlk.Find(blockSize,false);
        if (temp==null){
            return -1;
        }
        else{
            freeBlk.Delete(temp);
            temp.address=temp.address+blockSize;
            temp.size=temp.size-blockSize;
            temp.key=temp.size;
            if (temp.size!=0){
                freeBlk.Insert(temp.address,temp.size,temp.key);
            }
            allocBlk.Insert(temp.address-blockSize,blockSize,temp.address-blockSize);
            return temp.address-blockSize;
        }
    } 
    
    public int Free(int startAddr) {
        Dictionary temp=allocBlk.Find(startAddr,true);
        if (temp==null){
            return -1;
        }
        else{
            allocBlk.Delete(temp);
            if (temp.size!=0){
                freeBlk.Insert(temp.key,temp.size,temp.size);
            }
            return 0;
        }
    }
    public void Defragment() {
        Dictionary addtree;
        if (type==2){
            addtree=new BSTree();
        }
        else{
            addtree=new AVLTree();
        }
        Dictionary tr=freeBlk.getFirst();
        while (tr!=null){
            addtree.Insert(tr.address,tr.size,tr.address);
            tr=tr.getNext();
        }
        Dictionary temp=addtree.getFirst();
        Dictionary temp1;
        Dictionary temp2=null;
        while (temp!=null && temp.getNext()!=null){
            temp1=temp.getNext();
            if (temp.key+temp.size==temp1.key){
                addtree.Delete(temp1);
                addtree.Delete(temp);
                if (temp.size+temp1.size!=0){
                    addtree.Insert(temp.address,temp.size+temp1.size,temp.address);
                }
                temp.key=temp.size;
                temp1.key=temp1.size;
                freeBlk.Delete(temp1);
                freeBlk.Delete(temp);
                if (temp.size+temp1.size!=0){
                    freeBlk.Insert(temp.address,temp.size+temp1.size,temp.size+temp1.size);
                }
                //temp=addtree.getFirst();
                if (temp2==null){
                    temp=addtree.getFirst();
                }
                else{
                    temp=temp2;
                }
                temp1=null;

            }
            else{
                temp2=temp;
                temp=temp.getNext();
            }
        }
    }
}