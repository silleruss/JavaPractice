
public class Run01 {
	
  public static void main(String[] args) {
    MyTree01 tree1 = new MyTree01("--xy*+st/xs");
    
    System.out.println(tree1.postorder());
    System.out.println(tree1.inorder());
    System.out.println(tree1.levelorder());
    }
}