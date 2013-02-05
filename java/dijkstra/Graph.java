class Graph {
  private ArrayList<Node> nodes;
  private ArrayList<Edge> edges;
  private int index = 0;

  public boolean remove(Node toRemove) {
    int i = 0;
    for (Node n : nodes) {
      if (n.id == toRemove.id) {
        nodes.remove(i);
        return true;
      }
      i++;
    }
    return false;
  }

  public ArrayList<Node> nodes() {
    return nodes;
  }

  public ArrayList<Edge> edges() {
    return edges;
  }

  public boolean add(Node n) {
    nodes.add(n);
    return true;
  }

  public boolean empty() {
    return nodes.isEmpty();
  }

  public Graph(ArrayList<Node> nodes, ArrayList<Edge> edges) {
    this.nodes = nodes;
    this.edges = edges;
  }
}
