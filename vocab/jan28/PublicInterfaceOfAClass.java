class PublicInterfaceOfAClass {
  private int x, y;
  public int z;
  public PublicInterfaceOfAClass(int m, int n) {
    x = m;
    y = n;
    z = (m+n)/(m*n);
  }

  public void reset() {
    x = y = z = 0;
  }

  // everything that is declared public is part of 
  // the public interface of the class
}