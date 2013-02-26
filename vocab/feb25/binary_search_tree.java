public class binary_search_tree {
  private Node root;
  
  public void add(int v) {
    if (root.val == 0) {
      root.val = v;
    }
    else {
      insert(root, v);
    }
  }

  public void insert(Node n, int v) {
    if (n.val == 0) {
      n.val = v;
    }
    else if (v < n.val) {
      insert(n.left, v);
    }
    else if (v > n.val) {
      insert(n.right, v);
    }
  }
}

// code is functional unless an element is 0, because java does not allow null ints
