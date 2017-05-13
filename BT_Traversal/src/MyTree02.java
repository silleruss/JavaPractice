import java.util.*;

public class MyTree02 {
	private BST bst;
	 class BSTNode {
	     BSTNode left, right;
	     char data;

	     public BSTNode() {
	    	 left = null;
	        right = null;
	        data = 0;
        }

	     public BSTNode(char n) {
	         left = null;
	         right = null;
	         data = n;
	     }
 
	     public void setLeft(BSTNode n) { left = n; }

	     public void setRight(BSTNode n) { right = n; }

	     public BSTNode getLeft() { return left; }

	     public BSTNode getRight() { return right; }

	     public void setData(char d) { data = d; }

	     public int getData() { return data; }     
	 
	 }
	 
	 class BST {
		 private BSTNode root;
		 private String output;
		 
		 public BST() {
			 root = null;
	     }

		 public boolean isEmpty() {
			 return root == null;
	     }

	     public void insert(char data) {
	         root = insert(root, data);
	     }

	     private BSTNode insert(BSTNode node, char data) {
	         if (node == null)
	             node = new BSTNode(data);
	         else {
	             if (data <= node.getData())
	                 node.left = insert(node.left, data);
	             else
	                 node.right = insert(node.right, data);
	         }
	         
	        return node;
	     }
	     
	     public void inorder() {
	    	 inorder(root);
	     }

	     private void inorder(BSTNode r) {
	         if (r != null) {
	             inorder(r.getLeft());
	             System.out.print(r.getData() +" ");
	             inorder(r.getRight());
	         }
	     }

	     public void preorder() {
	         preorder(root);
	     }

	     private void preorder(BSTNode r) {
	         if (r != null) {
	             System.out.print(r.getData() +" ");
	             preorder(r.getLeft());             
	             preorder(r.getRight());
	         }
	     }

	     public String postorder() {
	         return postorder(root);
	     }
	     
	     private String postorder(BSTNode r) {
	         if (r != null) {
	             postorder(r.getLeft());             
	             postorder(r.getRight());
	             //System.out.print(r.getData() +" ");
	             output += r.getData();
	         }
	         return output;
	     }     
	 }
	 
	 public String postorder() {
		 return bst.postorder();
	 }
	 
	 public MyTree02(String preorder, String inorder) {
		  char[] prechar = preorder.toCharArray();
		  char[] inchar = inorder.toCharArray();
		
		 this.bst = new BST();
		 //int i=0;
		 String temp = "";
		 for(int i = 0; i < inchar.length; i++) {
			 //System.out.print(inchar[i]);
			 temp += inchar[i];
			 //this.bst.insert(i); 
		 }
		 System.out.println(temp);
		 /*
		  if (!valid(preorder, inorder)) {
			  System.out.println("No valid tree");
			  return;
		  }
		  */
	 }
	
	private boolean valid(String preorder, String inorder) {
		if (preorder.length() == inorder.length())
			return true;
    
		return false;
	}
}
