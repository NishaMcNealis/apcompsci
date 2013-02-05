class Node {
  public int dist;
  public int id;

  public boolean isIn(ArrayList<Node> a) {
    for (Node n : a) {
      if (n.id == a.id) return true;
    }
    return false;
  }

  public Node() {
    dist = Integer.MAX_VALUE;
    id = -1;
  }

  public Node(int dist, int id) {
    this.dist = dist;
    this.id = id;
  }
}
