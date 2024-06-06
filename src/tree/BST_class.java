package tree;

import java.util.*;

class BST_class { 
    class Node { 
        int key; 
        Node left, right; 
   
        public Node(int data){ 
            key = data; 
            left = right = null; 
        } 
    }

    Node root; 
  
    BST_class(){ 
        root = null; 
    } 
    
    void insert(int key)  { 
        root = insert_Recursive(root, key); 
    } 
    Node insert_Recursive(Node root, int key) { 
        if (root == null) { 
            root = new Node(key); 
            return root; 
        } 
        if (key < root.key) 
            root.left = insert_Recursive(root.left, key); 
        else if (key > root.key) 
            root.right = insert_Recursive(root.right, key); 
        return root; 
    } 
   
    void inorder() { 
        //add code here
    	inorderTravel(root);
    } 
   
    //Create new
    private void inorderTravel(Node root) {
		// TODO Auto-generated method stub
    	if(root != null) {
    		inorderTravel(root.left);
    		System.out.print(root.key + " ");
    		inorderTravel(root.right);
    	}
	}

	void postorder() { 
        //add code here
		postorderTravel(root);
    } 
    
	//Create new
    private void postorderTravel(Node root) {
		// TODO Auto-generated method stub
		if(root != null) {
			postorderTravel(root.left);
			postorderTravel(root.right);
			System.out.print(root.key + " ");
		}
	}

	public static void main(String[] args) { 
        BST_class bst = new BST_class(); 
        String msg = "";
        int num=0,  i = 0;
        Scanner input = new Scanner(System.in);

        for(i=0; i<10; i++) {
            msg = input.nextLine();
            num = Integer.parseInt(msg);
            bst.insert(num);
        }
        
        System.out.println("In order ...");
        bst.inorder(); 
        System.out.println();
        System.out.println("Post order ...");
        bst.postorder(); 

    }
}
