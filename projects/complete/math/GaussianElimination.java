import java.util.Scanner;
public class GaussianElimination {
  public static final int SIZE = 4;
  public static void main (String[] args) {
    double[][] orig = {
      {3,1,4,1},
      {5,9,2,6},
      {5,3,5,8},
      {9,7,9,3} };
    double[][] augm = new double[SIZE][2*SIZE];
    /*
    Scanner sc = new Scanner( System.in );
    String type;
    int sidelength;
    System.out.print("Enter \"i\" to find inverse, enter \"s\" to solve a system of equations: ");
    type = sc.next();
    if (type.charAt(0) == 'i' || type.charAt(0) == 'I') {
      System.out.print("Enter the side length of your square matrix: ");
      sidelength = Integer.parseInt(sc.next());
      orig = new double[sidelength][sidelength];
      for (int i = 0; i < orig.length; i++) {
	for (int j = 0; j < orig[0].length; j++) {
	  System.out.printf("Enter the value of the element at a(%d,%d): ", i+1, j+1);
	  orig[i][j] = Double.parseDouble(sc.next());
	}
      }
      }*/
    

    findInverse(prepInverse(orig));

   
  }
  
  public static void print(double[][] a) {
    a = posZero(a);
    for (int i = 0; i < a.length; i++) {
      System.out.print("|");
      for (int j = 0; j < a[0].length; j++) {
	System.out.printf("%6.2f ", a[i][j]);
	if (j == a.length-1) { 
	  System.out.print("    ");
	}
      }
      System.out.print(" |\n");
    }
  }

  public static double[][] prepInverse(double[][] orig) {
    double[][] augm = new double[orig.length][2*orig.length];
    for (int i = 0; i < augm.length; i++) {
      for (int j = 0; j < augm[0].length; j++) {
	if (i == j-augm.length) {
	  augm[i][j] = 1;
	}
	else if (j < augm.length) {
	  augm[i][j] = orig[i][j];
	}
	else {
	  augm[i][j] = 0;
	}
      }
    }
    return augm;
  }
  
  public static double[][] prepRref(double[][] orig) {
    double[][] augm = new double[orig.length][orig[0].length];
    for (int i = 0; i < augm.length; i++) {
      for (int j = 0; j < augm[0].length; j++) {
	if (i == j-augm.length) {
	  augm[i][j] = 1;
	}
	else if (j < augm.length) {
	  augm[i][j] = orig[i][j];
	}
	else {
	  augm[i][j] = 0;
	}
      }
    }
    return augm;
  }
  
  public static boolean hasInverse(int[][] a) {
    return true;
  }
  
  public static double[][] posZero(double[][] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[0].length; j++) {
	if (a[i][j] == -0.) {
	  a[i][j] = 0;
	}
      }
    }
    return a;
  }

  public static void findInverse(double[][] a) {
    System.out.println("Original augmented matrix:");
    print(a);
    for (int i = 0; i < a.length; i++) {
      if (a[i][i] != 1 && a[i][i] != 0) {
	double n = 1/a[i][i];
	System.out.printf("R%d * 1/%.2f --> R%d\n", i+1, a[i][i], i+1);
	for (int j = 0; j < a[0].length; j++) {
	  a[i][j] *= n;
	}
	print(a);
      }
      
      for (int k = 1; i + k < a.length; k++) {
	double n = a[i+k][i] * -1;
	System.out.printf("R%d * %.2f + R%d --> R%d\n", i+1, n, i+k+1, i+k+1);
	for (int j = 0; j < a[0].length; j++) {
	  a[i+k][j] += n*a[i][j];
	}
	print(a);
      }
    }
    // ref complete
    for (int i = a.length-1; i >= 0; i--) {
      for (int k = 1; i-k >= 0; k++) {
	double n = a[i-k][i] * -1;
	System.out.printf("R%d * %.2f + R%d --> R%d\n", i+1, n, i-k+1, i-k+1);
	for (int j = 0; j < a[0].length; j++) {
	  a[i-k][j] += n*a[i][j];
	}
	print(a);
      }
    }
  }
} 

