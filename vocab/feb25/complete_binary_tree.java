public class complete_binary_tree {
  public boolean isComplete(Node root) {
    if(testNode(root) == 1) {
      return true;
    }
    else {
      return false;
    }
  }

  public int testNode(Node n) {
    if(n.left == null || n.right == null) {
      if(n.left == null && n.right == null) {
	return 1;
      }
      return 0;
    }
    
    
  }
} 