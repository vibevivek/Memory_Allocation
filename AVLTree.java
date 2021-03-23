// Class: Height balanced AVL Tree
// Binary Search Tree
import java.lang.Math.*;
public class AVLTree extends BSTree {
    
    private AVLTree left, right;     // Children. 
    private AVLTree parent;          // Parent pointer. 
    private int height;  // The height of the subtree
        
    public AVLTree() { 
        super();
        // This acts as a sentinel root node
        // How to identify a sentinel node: A node with parent == null is SENTINEL NODE
        // The actual tree starts from one of the child of the sentinel node !.
        // CONVENTION: Assume right child of the sentinel node holds the actual root! and left child will always be null.   
    }
    public AVLTree(int address, int size, int key) { 
        super(address, size, key);
        this.height = 0;
    }
    // Implement the following functions for AVL Trees.
    // You need not implement all the functions. 
    // Some of the functions may be directly inherited from the BSTree class and nothing needs to be done for those.
    // Remove the functions, to not override the inherited functions.
    private int height(AVLTree node){
    	if (node==null){
    		return -1;
    	}
    	else{
    		return node.height;
    	}
    }
    private void balance(AVLTree curr){
    	boolean flag1=true;
    	AVLTree temp=null;
    	while (flag1==true){
    		if (curr.parent.parent==null){
    			break;
    		}
    		curr.parent.height=Math.max(height(curr.parent.left),height(curr.parent.right))+1;
    		if (height(curr.parent.left)-height(curr.parent.right)==2){
    			AVLTree Z=curr.parent;
    			AVLTree Y=curr;
    			AVLTree X=temp;
    			if (Y.left==X){
    				LL1(X,Y,Z);
    				break;
    			}
    			else{
    				LR1(X,Y,Z);
    				break;
    			}
    		}
    		else if (height(curr.parent.left)-height(curr.parent.right)==-2){
    			AVLTree Z=curr.parent;
    			AVLTree Y=curr;
    			AVLTree X=temp;
    			if (Y.left==X){
    				RL1(X,Y,Z);
    				break;
    			}
    			else{
    				RR1(X,Y,Z);
    				break;
    			}
    		}
    		else{
    			temp=curr;
    			curr=curr.parent;
    		}

    	}
    }
    private void LL1(AVLTree X,AVLTree Y,AVLTree Z){
    	if (Z.parent.right==Z){
    		Z.left=Y.right;
    		if (Z.left!=null){
    			Z.left.parent=Z;
    		}
    		Y.parent=Z.parent;
    		Y.parent.right=Y;
    		Y.right=Z;
    		Z.parent=Y;
    	}
    	else{
    		Z.left=Y.right;
    		if (Z.left!=null){
    			Z.left.parent=Z;
    		}
    		Z.parent.left=Y;
    		Y.parent=Z.parent;
    		Y.right=Z;
    		Z.parent=Y;
    	}
    	Z.height=Math.max(height(Z.left),height(Z.right))+1;
    	Y.height=Math.max(height(Y.left),height(Y.right))+1;
    }
    private void RR1(AVLTree X,AVLTree Y,AVLTree Z){
    	if (Z.parent.right==Z){
    		Z.right=Y.left;
    		if (Z.right!=null){
    			Z.right.parent=Z;
    		}
    		Y.parent=Z.parent;
    		Y.parent.right=Y;
    		Y.left=Z;
    		Z.parent=Y;
    	}
    	else{
    		Z.right=Y.left;
    		if (Z.right!=null){
    			Z.right.parent=Z;
    		}
    		Y.parent=Z.parent;
    		Y.parent.left=Y;
    		Y.left=Z;
    		Z.parent=Y;
    	}
    	Z.height=Math.max(height(Z.left),height(Z.right))+1;
    	Y.height=Math.max(height(Y.left),height(Y.right))+1;
    }
    private void LR1(AVLTree X,AVLTree Y,AVLTree Z){
    	if (Z.parent.right==Z){
    		X.parent=Z.parent;
    		X.parent.right=X;
    		Z.left=X.right;
    		if (Z.left!=null){
    			Z.left.parent=Z;
    		}
    		Y.right=X.left;
    		if (Y.right!=null){
    			Y.right.parent=Y;
    		}
    		X.left=Y;
    		Y.parent=X;
    		X.right=Z;
    		Z.parent=X;
    	}
    	else{
    		X.parent=Z.parent;
    		X.parent.left=X;
    		Z.left=X.right;
    		if (Z.left!=null){
    			Z.left.parent=Z;
    		}
    		Y.right=X.left;
    		if (Y.right!=null){
    			Y.right.parent=Y;
    		}
    		X.left=Y;
    		Y.parent=X;
    		X.right=Z;
    		Z.parent=X;
    	}
    	Z.height=Math.max(height(Z.left),height(Z.right))+1;
    	Y.height=Math.max(height(Y.left),height(Y.right))+1;
    	X.height=Math.max(height(X.left),height(X.right))+1;
    }
    private void RL1(AVLTree X,AVLTree Y,AVLTree Z){
    	if (Z.parent.right==Z){
    		X.parent=Z.parent;
    		X.parent.right=X;
    		Z.right=X.left;
    		if (Z.right!=null){
    			Z.right.parent=Z;
    		}
    		Y.left=X.right;
    		if (Y.left!=null){
    			Y.left.parent=Y;
    		}
    		X.left=Z;
    		Z.parent=X;
    		X.right=Y;
    		Y.parent=X;
    	}
    	else{
    		X.parent=Z.parent;
    		X.parent.left=X;
    		Z.right=X.left;
    		if (Z.right!=null){
    			Z.right.parent=Z;
    		}
    		Y.left=X.right;
    		if (Y.left!=null){
    			Y.left.parent=Y;
    		}
    		X.left=Z;
    		Z.parent=X;
    		X.right=Y;
    		Y.parent=X;
    	}
    	Z.height=Math.max(height(Z.left),height(Z.right))+1;
    	Y.height=Math.max(height(Y.left),height(Y.right))+1;
    	X.height=Math.max(height(X.left),height(X.right))+1;
    }
    private void avlbal(AVLTree curr){
    	boolean flag2=true;
    	while (flag2==true){
    		if (curr.parent==null){
    			break;
    		}
    		curr.height=Math.max(height(curr.left),height(curr.right))+1;
    		if (height(curr.left)-height(curr.right)==2){
    			AVLTree Z=curr;
    			AVLTree Y=Z.left;
    			AVLTree X;
    			if (height(Y.left)>=height(Y.right)){
    				X=Y.left;
    				LL1(X,Y,Z);
    				curr=Y;
    			}
    			else{
    				X=Y.right;
    				LR1(X,Y,Z);
    				curr=X;
    			}
    		}
    		else if (height(curr.left)-height(curr.right)==-2){
    			AVLTree Z=curr;
    			AVLTree Y=Z.right;
    			AVLTree X;
    			if (height(Y.left)>height(Y.right)){
    				X=Y.left;
    				RL1(X,Y,Z);
    				curr=X;
    			}
    			else{
    				X=Y.right;
    				RR1(X,Y,Z);
    				curr=Y;
    			}
    		}
    		else{
    			curr=curr.parent;
    		}
    	}
    }
    private void remove(AVLTree curr){
    	AVLTree yo=curr.parent;
        if (curr.left==null && curr.right==null){
            if (curr.parent.right==curr){
                curr.parent.right=null;
                curr.parent=null;
                avlbal(yo);
            }
            else{
                curr.parent.left=null;
                curr.parent=null;
                avlbal(yo);
            }
        }
        else if (curr.left==null && curr.right!=null){
            if (curr.parent.right==curr){
                curr.parent.right=curr.right;
                curr.right.parent=curr.parent;
                curr.parent=null;
                curr.right=null;
                avlbal(yo);
            }
            else{
                curr.parent.left=curr.right;
                curr.right.parent=curr.parent;
                curr.parent=null;
                curr.right=null;
                avlbal(yo);
            }
        }
        else if (curr.right==null && curr.left!=null){
            if (curr.parent.right==curr){
                curr.parent.right=curr.left;
                curr.left.parent=curr.parent;
                curr.parent=null;
                curr.left=null;
                avlbal(yo);
            }
            else{
                curr.parent.left=curr.left;
                curr.left.parent=curr.parent;
                curr.parent=null;
                curr.left=null;
                avlbal(yo);
            }
        }
        else{
            AVLTree temp=curr.right;
            while(temp.left!=null){
                temp=temp.left;
            }
            AVLTree A1=curr.parent;
            AVLTree A2=curr.left;
            AVLTree A3=curr.right;
            AVLTree B1=temp.parent;
            AVLTree B2=temp.right;
            if (temp==A3){
            	curr.parent=null;
            	curr.right=null;
            	curr.left=null;
            	temp.parent=null;
            	temp.left=null;
            	temp.right=null;
	            temp.parent=A1;
            	temp.parent=A1;
            	if (A1.right==curr){
            		A1.right=temp;
            	}
            	else{
            		A1.left=temp;
            	}
            	temp.left=A2;
            	if (A2!=null){
            		A2.parent=temp;
            	}
            	curr.parent=temp;
            	temp.right=curr;
            	curr.right=B2;
            	if (B2!=null){
            		B2.parent=curr;
            	}
            }
            else{
            	curr.parent=null;
            	curr.right=null;
            	curr.left=null;
            	temp.parent=null;
            	temp.left=null;
            	temp.right=null;
	            temp.parent=A1;
	            if (A1.right==curr){
	            	A1.right=temp;
	            }
	            else{
	            	A1.left=temp;
	            }
	            temp.left=A2;
	            if (A2!=null){
	            	A2.parent=temp;
	            }
	            temp.right=A3;
	            A3.parent=temp;
	            curr.parent=B1;
	            B1.left=curr;
	            curr.right=B2;
	            if (B2!=null){
	            	B2.parent=curr;
	            }
	        }
	        temp.height=Math.max(height(temp.left),height(temp.right))+1;
	    	curr.height=Math.max(height(curr.left),height(curr.right))+1;
            remove(curr);
        }
    }
    
    public AVLTree Insert(int address, int size, int key) 
    {
		AVLTree newnode=new AVLTree(address,size,key);
		boolean flag=true;
		AVLTree current=this;
		while (current.parent!=null){
			current=current.parent;
		}
		if (current.right==null){
			current.right=newnode;
			newnode.parent=current;
			return newnode;
		}
		current=current.right;
		while (flag==true){
			if (current.key<key){
				if (current.right==null){
					current.right=newnode;
					newnode.parent=current;
					balance(newnode);
					flag=false;
				}
				else{
					current=current.right;
				}
			}
			else if (current.key>key){
				if (current.left==null){
					current.left=newnode;
					newnode.parent=current;
					balance(newnode);
					flag=false;
				}
				else{
					current=current.left;
				}
			}
			else if (current.address<address){
				if (current.right==null){
					current.right=newnode;
					newnode.parent=current;
					balance(newnode);
					flag=false;
				}
				else{
					current=current.right;
				}
			}
			else{
				if (current.left==null){
					current.left=newnode;
					newnode.parent=current;
					balance(newnode);
					flag=false;
				}
				else{
					current=current.left;
				}
			}
		} 
        return newnode;
    }

    public boolean Delete(Dictionary e)
    {
    	if (e==null){
    		return false;
    	}
    	AVLTree current=this;
    	while (current.parent!=null){
            current=current.parent;
        }
        current=current.right;
        if (current==null){
            return false;
        }
        else{
        	while (current!=null){
        		if (current.key<e.key){
        			current=current.right;
        		}
        		else if (current.key>e.key){
        			current=current.left;
        		}
        		else if (current.address<e.address){
        			current=current.right;
        		}
        		else if (current.address>e.address){
        			current=current.left;
        		}
        		else if (current.address==e.address){
        			remove(current);
        			return true;
        		}
        		else{
        			return false;
        		}
        	}
        	return false;
        }
    }
        
    public AVLTree Find(int key, boolean exact)
    {
        AVLTree temp=this;
        AVLTree ret=null;
        while (temp.parent!=null){
            temp=temp.parent;
        }
        if (temp.right==null){
            return null;
        }
        temp=temp.right;
        boolean flag=true;
        if (exact==true){
            while (temp!=null){
                if (temp.key<key){
                    temp=temp.right;
                }
                else if (temp.key>key){
                    temp=temp.left;
                }
                else if (temp.key==key){
                    ret=temp;
                    temp=temp.left;
                }
            }
            if (ret==null){
                return null;
            }
            else{
                return ret;
            }
        }
        else{
            while (temp!=null){
                if (temp.key<key){
                    temp=temp.right;
                }
                else if (temp.key>key){
                    ret=temp;
                    temp=temp.left;
                }
                else if (temp.key==key){
                    ret=temp;
                    temp=temp.left;
                }
            }
            if (ret==null){
                return null;
            }
            else{
                return ret;
            }
        }

    }

    public AVLTree getFirst()
    { 
    	AVLTree current=this;
        while (current.parent!=null){
            current=current.parent;
        }
        if (current.right==null){
            return null;
        }
        else{
            current=current.right;
            while (current.left!=null){
                current=current.left;
            }
            return current;
        }
    }

    public AVLTree getNext()
    {
    	AVLTree current=this;
        if (current.parent==null){
            return null;
        }
        else if (current.right!=null){
            current=current.right;
            while (current.left!=null){
                current=current.left;
            }
            return current;
        }
        else{
            AVLTree p=current.parent;
            while (p.parent!=null && current==p.right){
            	current=p;
            	p=p.parent;
            }
            if (p.parent==null){
            	return null;
            }
            else{
            	return p;
            }
        
        }
    }
    private boolean avlprop(AVLTree node){
    	if (node==null){
            return true;
        }
        else{
        	if ((height(node)!=Math.max(height(node.left),height(node.right))+1) || ((height(node.left)-height(node.right)<-1) || (height(node.left)-height(node.right)>1))){
        		return false;
        	}
        	else{
        		return (avlprop(node.left) && avlprop(node.right));
        	}
        }
    }
    private boolean parchild(AVLTree node){
        if (node.left==null && node.right==null){
            return true;
        }
        else if (node.left==null){
            return ((node.right.parent==node) && parchild(node.right));
        }
        else if (node.right==null){
            return ((node.left.parent==node) && parchild(node.left));
        }
        else{
            return ((node.right.parent==node) && (node.left.parent==node) && (parchild(node.left)) && (parchild(node.right)));
        }
    }
    private boolean cycle(AVLTree node){
        AVLTree current1=node;
        AVLTree current2=node;
        while (current1!=null && current2!=null && current2.parent!=null){
            current1=current1.parent;
            current2=current2.parent.parent;
            if (current1==current2){
                return true;
            }
        }
        return false;

    }
    //parchild() method will check that a node's child's parent is that node or not over all nodes in tree.
    //avlprop() method will check that the difference between left child and right child lies between -1 to 1 and also the height of a node is maximum of it's child's height plus one.
    public boolean sanity()
    {
    	boolean flag2=true;
    	boolean flag3=true;
    	AVLTree current=this;
        if (cycle(current)==true){
            return false;
        }
    	while (current.parent!=null){
    		current=current.parent;
    	}
    	if (current.right==null){
    		if (current.left!=null){
    			flag2=false;
    		}
    	}
    	else{
    		current=current.right;
    		flag2=parchild(current);
    		flag3=avlprop(current);
    	}
        return (flag2 && flag3);
    }
    
}



