class Edge {
  private Node source;
  private Node dest;
  public int id;
  private int length;

  public Edge(int id, Node source, Node dest, int length) {
    thid.id = id;
    this.source = source;
    this.dest = dest;
    this.length = length;
  }

  public Node source() {
    return source;
  }

  public Node dest() {
    return dest;
  }

  public int length() {
    return length;
  }
}
