/*
                 A
               /   \
             /       \
           D B E     F C
Recursively follow above steps and get the following tree.
         A
       /   \
     /       \
    B         C
   / \        /
 /     \    /
D       E  F
*/
public class Run02 {
	
	public static void main(String[] args) {	  
		MyTree02 tree1 = new MyTree02("ABDECF", "DBEAFC");

		System.out.println(tree1.postorder()); //DEBFCA
		System.out.println(tree1.levelorder()); //ABCDEF

		MyTree02 tree2 = new MyTree02("ABCDE", "BDACE"); //No valid tree
  	}
}
