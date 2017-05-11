
public class MyTree02
{
  private MyTree01 postTree;
  private MyTree01 levelTree;
  
  public MyTree02(String preorder, String inorder)
  {
    if (!valid(preorder, inorder))
    {
      System.out.println("No valid tree");
      return;
    }
    this.postTree = new MyTree01(preorder);
    this.levelTree = new MyTree01(preorder);
  }
  
  private boolean valid(String preorder, String inorder)
  {
    MyTree01 preTree = new MyTree01(preorder);
    
    preTree.inorder();
   
    if (preTree.getinString() == inorder) {
      return true;
    }
    return false;
  }
  
  public String postorder()
  {
    return this.postTree.postorder();
  }
  
  public String levelorder()
  {
    return this.postTree.levelorder();
  }
}
