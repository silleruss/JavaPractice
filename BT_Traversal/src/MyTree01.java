
import java.util.*;

public class MyTree01 {
	
  private MyTree01.StackNode top;
  private String target;
  private String postString;
  private String inString;
  private String levelString;
  
  class TreeNode {
    char data;
    TreeNode left;
    TreeNode right;
    
    public TreeNode(char data) {
      this.data = data;
      this.left = null;
      this.right = null;
      }
  }
  
  class StackNode {
    MyTree01.TreeNode treeNode;
    StackNode next;
    
    public StackNode(MyTree01.TreeNode treeNode) {
      this.treeNode = treeNode;
      this.next = null;
    }
  }
  
  public MyTree01(String preorder) {
    this.top = null;
    this.target = preorder;
    makeTree(this.target);
  }
  
  public MyTree01(String preorder, String inorder) {
    this.top = null;
    this.target = preorder;
    makeTree(this.target);
  }
  
  private void push(MyTree01.TreeNode ptr) {
    if (this.top == null) {
      this.top = new MyTree01.StackNode(ptr);
    } else {
      MyTree01.StackNode nptr = new MyTree01.StackNode(ptr);
      nptr.next = this.top;
      this.top = nptr;
    }
  }
  
  private MyTree01.TreeNode pop() {
    if (this.top == null) {
      throw new RuntimeException("Underflow");
    }
    MyTree01.TreeNode ptr = this.top.treeNode;
    this.top = this.top.next;
    return ptr;
  }
  
  private MyTree01.TreeNode peek() {
    return this.top.treeNode;
  }
  
  private void insert(char val) {
    try {
    	
      if (Character.isLetter(val)) {
        MyTree01.TreeNode nptr = new MyTree01.TreeNode(val);
        push(nptr);
      } else if (isOperator(val)) {
        MyTree01.TreeNode nptr = new MyTree01.TreeNode(val);
        nptr.left = pop();
        nptr.right = pop();
        push(nptr);
      }
      
    } catch (Exception e) {
      System.out.println("Invalid");
    }  
  }
  
  private boolean isOperator(char ch) {
    return (ch == '+') || (ch == '-') || (ch == '*') || (ch == '/');
  }
  
  public void makeTree(String target) {
	  for (int targetIndex = target.length() - 1; targetIndex >= 0; targetIndex--)
		  insert(target.charAt(targetIndex));
    }
  
  public String postorder() {
	  this.postString = "";
	  return postfix(peek());
  }
  
  public String postfix(MyTree01.TreeNode ptr) {
    if (ptr != null) {
      postfix(ptr.left);
      postfix(ptr.right);
      this.postString += Character.toString(ptr.data);
      }
    
    return this.postString;
  }
  
  public String inorder() {
    this.inString = "";
    return infix(peek());
  }
  
  public String infix(MyTree01.TreeNode ptr) {
	  
    if (ptr != null) {
      if ((ptr.left != null) && (ptr.right != null))
        this.inString += "(";
      
      infix(ptr.left);
      this.inString += Character.toString(ptr.data);
      infix(ptr.right);
      
      if ((ptr.left != null) && (ptr.right != null))
        this.inString += ")";
        
    }
    return this.inString;
  }
  
  public String levelorder() {
    this.levelString = "";
    return levelfix(peek());
  }
  
  public String levelfix(MyTree01.TreeNode ptr) {
    Queue q = new LinkedList();
    q.add(ptr);
    
    while (!q.isEmpty()) {
      MyTree01.TreeNode temp = (MyTree01.TreeNode)q.poll();
      this.levelString += Character.toString(temp.data);
      
      if (temp.left != null) {
        q.add(temp.left);
      }
      if (temp.right != null) {
        q.add(temp.right);
      }
    }
    return this.levelString;
  }
  
  public String getinString() {
    return this.inString;
  }
}
