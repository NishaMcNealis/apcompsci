class Graph {
  private ArrayList<Node> graph;
  private int index;
  public Node source;

  public boolean remove(Node toRemove) {
    int id = toRemove.id;
    int i = 0;
    for (Node n : graph) {
      if (n.id == id) {
        graph.remove(i);
        return true;
      }
      i++;
    }
    return false;
  }

  public boolean add(Node n, int dist) {
    n.id = indx;
    n.dist = dist;
    index++;
    graph.add(n);
    return true;
  }

  public boolean add(Node n) {
    return add(n, n.dist);
  }

  public Node closest() {
    Node closest = new Node();
    for (Node n : graph) {
      if (n.dist < closest.dist) closest = n;
    }
    return closest;
  }

  public Graph() {
    graph = new ArrayList<Node>();
    index = 0;
    source = new Node();
    source.dist = 0;
  }

  public Graph(ArrayList<Node> c) {
    Graph();
    for (Node n : c) add(n);
  }

  public boolean empty() {
    return graph.isEmpty();
  }
}
