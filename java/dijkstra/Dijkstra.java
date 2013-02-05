public class Dijkstra {
  public Graph g;

  public static void main(String[] java) {
    //fill this in yourself please with distinct IDs
    ArrayList<Node> nodes = new ArrayList<Node>();
    ArrayList<Edge> edges = new ArrayList<Edge>();

    g = new Graph(nodes, edges);

    while (!g.empty()) {
      Node u = closest(source, u);
      g.remove(u);
      if (u.dist == Integer.MAX_VALUE)
        break;
      
      for (Node v : neighbours(u)) {
        int alt = distance(source, u)
      }
    }
  }

  public static ArrayList<Node> neighbours(Node n) {
    ArrayList<Node> neighbours = new ArrayList<Node>;
    for (Edge e : edges) {
      if (e.source().id == n.id && !n.isIn(g.nodes)) {
        neighbours.add(e.dest());
      }
    }
    return neighbours;
  }

  public staic boolean match(Edge e, Node a, Node b) {
    return (e.source().id == a.id && e.dest().id == b.id) ? true : ((e.source().id == b.id && e.dest().id == a.id) ? true : false) : false;
  }

  public static int distance(Node a, Node b) {
    for (Edge e : edges) {
      if (match(e, a, b)) return e.length;
    }
    return -1;
  }

  public static Node closest(Node source) {
    ArrayList<Node> neighbours = neighbours(source);
    Node c = neighbours.get(0);
    for (Node n : neighbours) {
      if (distance(n, source) < distance(c, source)) {
        c = n;
      }
    }
    return c;
  }
}
