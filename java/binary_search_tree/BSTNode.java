public class BSTNode {
  Integer val;
  public BSTNode left;
  public BSTNode right;
  
  BSTNode() {
    
  }
  
  BSTNode(Integer n) {
    val = n;
  }

  public boolean hasChild() {
    return (left == null && right == null);
  }

  public int getDepth(BSTNode node) {
    if (node.left == null && node.right == null) return 0;
    else return 1 + getDepth(node.left) + getDepth(node.right)
  }

  public void insert(Integer n) {
    if(val == null) {
      val = n;
    }
    else if(n > val) {
      if (right == null) {
	right = new BSTNode(n);
      }
      else {
	right.insert(n);
      }
    }
    else if(n < val) {
      if(left == null) {
	left = new BSTNode(n);
      }
      else {
	left.insert(n);
      }
    }
  }
}