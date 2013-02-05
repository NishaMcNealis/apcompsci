public class Dijkstra {
  public Graph g;

  public static void main(String[] java) {
    g = new Graph();
    g.add(new Node(), 4);
    g.add(new Node(), 10);
    g.add(new Node(), 4);
    g.add(new Node(), 3);
    while (!g.empty()) {
      Node u = g.closest();
      g.remove(u);
      if (u.dist == Integer.MAX_VALUE)
        break;
      
      //need to make Edge and whatnot
    }
  }
}
