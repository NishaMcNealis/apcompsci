class Exercise11 {
  public static void main(String [] args) {
    System.out.println("Recursive:");
    System.out.println("  3 :  " + recursive(3));
    System.out.println("  14:  " + recursive(14)); 
    System.out.println("Iterative:");
    System.out.println("  3 :  " + iterative(3));
    System.out.println("  14:  " + iterative(14)); 
  }
   
  public static int recursive(int n) {
    if(n <= 3)
      return n;
    else
      return recursive(n-1) + 2*recursive(n-2) + 3*recursive(n-3); 
  }

  public static int iterative(int n) {
    if (n < 3)
      return n;
    int[] f = new int[n+1];
    f[0] = 1;
    f[1] = 2;
    f[2] = 3;
    for (int i = 3; i < n; i++)
      f[i] = f[i-1] + 2*f[i-2] + 3*f[i-3];
    return f[n-1];
  }
}