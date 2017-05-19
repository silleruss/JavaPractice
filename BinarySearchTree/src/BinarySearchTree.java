
public class BinarySearchTree {
	public static Node root;
	
	public BinarySearchTree() {
		this.root = null;
	}
	
	public boolean find(int data) {
		Node currentNode = root;
		
		while(currentNode!=null){
			if(currentNode.data == data) {
				return true;
			} else if(currentNode.data > data){
				currentNode = currentNode.left;
			} else{
				currentNode = currentNode.right;
			}
		}
		
		return false;
	}
	public boolean delete(int data) {
		Node parentNode = root;
		Node currentNode = root;
		boolean isLeftChild = false;
		
		while(currentNode.data != data){
			parentNode = currentNode;
			if(currentNode.data > data) {
				isLeftChild = true;
				currentNode = currentNode.left;
			} else {
				isLeftChild = false;
				currentNode = currentNode.right;
			}
			if(currentNode == null) {
				return false;
			}
		}
		
		if(currentNode.left == null && currentNode.right == null){
			if(currentNode==root) {
				root = null;
			}
			if(isLeftChild ==true) {
				parentNode.left = null;
			} else {
				parentNode.right = null;
			}
		}
		else if(currentNode.right == null) {
			if(currentNode==root) {
				root = currentNode.left;
			} else if(isLeftChild) {
				parentNode.left = currentNode.left;
			} else {
				parentNode.right = currentNode.left;
			}
		}
		else if(currentNode.left == null) {
			if(currentNode == root) {
				root = currentNode.right;
			} else if(isLeftChild) {
				parentNode.left = currentNode.right;
			} else {
				parentNode.right = currentNode.right;
			}
		} else if(currentNode.left != null && currentNode.right != null) {
			Node fixNode = getFixNode(currentNode);

			if(currentNode == root) {
				root = fixNode;
			} else if(isLeftChild) {
				parentNode.left = fixNode;
			} else {
				parentNode.right = fixNode;
			}		
			fixNode.left = currentNode.left;
		}	
		
		return true;		
	}
	
	public Node getFixNode(Node deleleNode) {
		Node fixNode = null;
		Node fixNodeParent = null;
		Node currentNode = deleleNode.right;
		
		while(currentNode != null){
			fixNodeParent = fixNode;
			fixNode = currentNode;
			currentNode = currentNode.left;
		}
		
		if(fixNode != deleleNode.right) {
			fixNodeParent.left = fixNode.right;
			fixNode.right = deleleNode.right;
		}
		
		return fixNode;
	}
	public void insert(int data) {
		Node newNode = new Node(data);
		if(root == null) {
			root = newNode;
			return;
		}
		Node currentNode = root;
		Node parentNode = null;
		
		while(true) {
			parentNode = currentNode;
			if(data < currentNode.data) {				
				currentNode = currentNode.left;
				if(currentNode == null) {
					parentNode.left = newNode;
					return;
				}
			} else {
				currentNode = currentNode.right;
				if(currentNode == null) {
					parentNode.right = newNode;
					return;
				}
			}
		}
	}
	public void ascend(Node root) {
		if(root != null){
			ascend(root.left);
			System.out.print(" " + root.data);
			ascend(root.right);
		}
	}
	public void descend(Node root) {
		if(root != null){
			descend(root.right);
			System.out.print(" " + root.data);
			descend(root.left);
		}
	}
	public static void main(String arg[]) {
		BinarySearchTree b = new BinarySearchTree();
		b.insert(50);
		b.insert(25);
		b.insert(10);
		b.insert(70);
		b.insert(40);
		b.insert(60);
		b.insert(65);
		b.ascend(b.root);	// 10 25 40 50 60 65 70
		System.out.println("\n"+b.find(30));	// false
		System.out.println(""+b.find(40));		// true
		System.out.println(""+b.delete(20));	// false
		b.ascend(root);	// 10 25 40 50 60 65 70
		System.out.println("\n"+b.delete(25));	// true
		b.ascend(root);	//	10 40 50 60 65 70
		System.out.println("\n"+b.delete(41));	// false
		b.ascend(root);	// 10 40 50 60 65 70
		System.out.println("\n"+b.delete(10));	// true
		b.ascend(root);	// 40 50 60 65 70
		System.out.println("\nDescending");
		b.descend(root);	// 70 65 60 50 40
	}
}
	
class Node {
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}