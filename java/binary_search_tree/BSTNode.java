public class BSTNode {
  Integer val;
  public BSTNode left;
  public BSTNode right;

  BSTNode(Integer n) {
    val = n;
  }

  BSTNode(int[] arr) {
    populate(arr);
  }

  public void populate(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      insert(arr[i]);
    }
  }

  public int getDepth(BSTNode node) {
    if (node == null) return 0;

    int l = getDepth(node.left);
    int r = getDepth(node.right);

    if (l > r) return l+1;
    else return r + 1;
  }

  public void insert(Integer n) {
    if (val == null) val = n;

    else if (n > val) {
      if (right == null) right = new BSTNode(n);
      else right.insert(n);
    }

    else if (n < val) {
      if (left == null) left = new BSTNode(n);
      else left.insert(n);
    }
  }
}