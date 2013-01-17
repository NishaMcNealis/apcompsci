
public class GaussianElimination {
  public static final int SIZE = 3;
  public static void main (String[] args) {
    double[][] orig = {
      new double[] {3,1,4},
      new double[] {1,5,9},
      new double[] {2,5,7} };
    double[][] augm = new double[SIZE][2*SIZE];
    for (int i = 0; i < SIZE; i++) {
      for (int j = 0; j < 2*SIZE; j++) {
	if (i == j-SIZE) {
	  augm[i][j] = 1;
	}
	else if (j < SIZE) {
	  augm[i][j] = orig[i][j];
	}
	else {
	  augm[i][j] = 0;
	}
      }
    }
    //  print(augm);
    rref(augm);
  }
  
  public static void print(double[][] a) {
    for (int i = 0; i < SIZE; i++) {
      System.out.print("| ");
      for (int j = 0; j < 2*SIZE; j++) {
	System.out.printf("%6.2f ",a[i][j]);
	if (j == SIZE-1) { 
	  System.out.print("  ");
	}
      }
      System.out.print("|\n");
    }
  }

  public static boolean hasInverse(int[][] a) {
    return true;
  }

  public static void rref(double[][] a) {
    int failcount = 0;

    print(a);
    for (int i = 0; i < SIZE; i++) {
      if (a[i][i] != 1 && a[i][i] != 0) {
	double n = 1/a[i][i];
	System.out.printf("R%d * 1/%.2f --> R%d\n", i+1, a[i][i], i+1);
	for (int j = 0; j < 2*SIZE; j++) {
	  a[i][j] *= n;
	}
	print(a);
      }
      
      for (int k = 1; i + k < SIZE; k++) {
	double n = a[i+k][i] * -1;
	System.out.printf("R%d * %.2f + R%d --> R%d\n", i+1, n,i+k+1, i+k+1);
	for (int j = 0; j < 2*SIZE; j++) {
	  a[i+k][j] += n*a[i][j]; 
	}
	print(a);
      }
    }
  }
} 

