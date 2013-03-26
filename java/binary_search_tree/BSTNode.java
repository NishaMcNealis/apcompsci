public class BSTNode {
  Integer val;
  BSTNode left;
  BSTNode right;
  
  BSTNode() {
    
  }
  
  BSTNode(Integer n) {
    val = n;
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