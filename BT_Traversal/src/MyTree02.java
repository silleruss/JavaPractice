import java.util.*;

class Node {
    public char data;
    public Node left, right;
  
    public Node(char item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
	private Node root;
	static int preIndex = 0;
	private String postString, levelString;
	
	public BinaryTree(String preorder, String inorder) {
		postString = "";
		levelString = "";
		int len = preorder.length();
		char[] pre = preorder.toCharArray();
		char[] in = inorder.toCharArray();
		root = buildTree(in, pre, 0, len-1); 
	}
	
	public Node buildTree(char in[], char pre[], int instart, int inEnd) {
		if (instart > inEnd) 
			return null;
		  	
		Node tNode = new Node(pre[preIndex++]);
		  
		if (instart == inEnd)
			return tNode;
		
		int inIndex = search(in, instart, inEnd, tNode.data);
		tNode.left = buildTree(in, pre, instart, inIndex - 1);
		tNode.right = buildTree(in, pre, inIndex + 1, inEnd);
		
		return tNode;
	}
	
	public int search(char arr[], int start, int end, char value) {
		int index;
		
		for (index = start; index <= end; index++) {
			if (arr[index] == value)
				return index;
		}
		
		return index;
	}
	
	public String postfix() {
		Postorder(root);
		return postString;
	}
	
	public String Postorder(Node node) {
		if (node != null) {
			Postorder(node.left);
			Postorder(node.right);
			postString += Character.toString(node.data);
		}
		
		return postString;
	}
	
	public String levelfix() {
		Levelorder(root);
		return levelString;
	}
	
	public String Levelorder(Node node) {
  		Queue q = new LinkedList();
  		q.add(node);
  		
  		while (!q.isEmpty()) {
  			Node temp = (Node)q.poll();
  			levelString += Character.toString(temp.data);
  			
  			if (temp.left != null) 
  				q.add(temp.left);
  			if (temp.right != null)
  				q.add(temp.right);  			
  		}
  		
  		return levelString;
  	}
}

public class MyTree02 {
	private BinaryTree tree;
	private String output;
	
	public String postorder() {
		output = tree.postfix();
		return output;
	}
	
	public String levelorder() {
  		output = tree.levelfix();
  		return output;
  	}
	 
	 public MyTree02(String preorder, String inorder) {
		  if (!valid(preorder, inorder)) {
			  System.out.println("No valid tree");
			  return;
		  }
		  
		  tree = new BinaryTree(preorder, inorder);
	 }
	
	private boolean valid(String preorder, String inorder) {
		String t1 = preorder.substring(1, 3);
		String t2 = inorder.substring(1, 2) + inorder.substring(0, 1);
		
		if (t1.equals(t2)) 
			return true;
		
		return false;
	}
}
