import java.util.Scanner;
import java.io.*;

public class GaussianElimination {
  public static File output = new File("output.txt");
  public static void main (String[] args) {
    output.delete();
    Scanner sc = new Scanner( System.in );
    String type;
    int sidelength;
    double[][] orig;
   
    System.out.print("Enter \"i\" to find inverse, enter \"s\" to solve a system of equations, enter \"d\" to find the determinant: ");
    type = sc.next();
    if (type.charAt(0) == 'd' || type.charAt(0) == 'D') {
      System.out.println("Sorry, determinant is still in development, please try again later");
      System.exit(0);
      System.out.print("Enter the side length of your square matrix: ");
      sidelength = Integer.parseInt(sc.next());
      orig = new double[sidelength][sidelength];
      for (int i = 0; i < orig.length; i++) {
	for (int j = 0; j < orig[0].length; j++) {
	  System.out.printf("Enter the value of the element at a(%d,%d): ", i+1, j+1);
	  orig[i][j] = Double.parseDouble(sc.next());
	}
      }
      System.out.println(determinant(orig));
    }
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
      f(prepInverse(orig));
    }
    else if (type.charAt(0) == 's' || type.charAt(0) == 'S') {
      System.out.printf("Enter the number of rows in your matrix: ");
      sidelength = Integer.parseInt(sc.next());
      orig = new double[sidelength][sidelength+1];
      for (int i = 0; i < orig.length; i++) {
	for (int j = 0; j < orig[0].length; j++) {
	  System.out.printf("Enter the value of the element at a(%d,%d): ", i+1, j+1);
	  orig[i][j] = Double.parseDouble(sc.next());
	}
      }      
      f(orig);
    } 
  }

  public static double determinant(double[][] det) { 
    if (det.length != det[0].length) {
      return -314.15;
    }
    else if (det.length <= 0) {
      return -314.15;
    }
    else if (det.length == 1) {
      return det[0][0];
    }
    else {
      return detCalc(det)[0][0];
    }
  }
  
  public static double[][] detCalc(double[][] det) {
    if (det.length == 2) {
      double[][] ret = new double[1][1];
      ret[0][0] = det[0][0] * det[1][1] - det[1][0] * det[0][1];
      return ret;
    }
    return det;
  }
  
  //wtf means write to file
  public static void wtf(String s) {
    try {
      BufferedWriter out = new BufferedWriter(new FileWriter(output, true));
      out.write(s);
      out.close();
    }
    catch(Exception e) {
      System.out.println("IO error: " + e.getMessage());
    }
  }

  public static void print(double[][] a) {
    a = posZero(a);
    for (int i = 0; i < a.length; i++) {
      System.out.print("|");
      for (int j = 0; j < a[0].length; j++) {
	System.out.printf("%6.3f ", a[i][j]);
	if (j == a.length-1) { 
	  System.out.print("    ");
	}
      }
      System.out.print(" |\n");
    }
  }
  public static void write(double[][] a) {
    a = posZero(a);
    for (int i = 0; i < a.length; i++) {
      wtf("|");
      for (int j = 0; j < a[0].length; j++) {
	wtf(String.format("%6.3f ", a[i][j]));
	if (j == a.length-1) { 
	  wtf("    ");
	}
      }
      wtf(" |\n");
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

  public static void f(double[][] a) {
    wtf("Original matrix:\n");
    write(a);
    System.out.println("Original matrix:");
    print(a);
    for (int i = 0; i < a.length; i++) {
      if (a[i][i] != 1 && a[i][i] != 0) {
	double n = 1/a[i][i];
	wtf(String.format("R%d * 1/%.2f --> R%d\n", i+1, a[i][i], i+1));
	System.out.printf("R%d * 1/%.2f --> R%d\n", i+1, a[i][i], i+1);
	for (int j = 0; j < a[0].length; j++) {
	  a[i][j] *= n;
	}
	write(a);
	print(a);
      }
      
      for (int k = 1; i + k < a.length; k++) {
	double n = a[i+k][i] * -1;
	wtf(String.format("R%d * %.2f + R%d --> R%d\n", i+1, n, i+k+1, i+k+1));
	System.out.printf("R%d * %.2f + R%d --> R%d\n", i+1, n, i+k+1, i+k+1);
	for (int j = 0; j < a[0].length; j++) {
	  a[i+k][j] += n*a[i][j];
	}
	write(a);
	print(a);
      }
    }
    // ref complete
    for (int i = a.length-1; i >= 0; i--) {
      for (int k = 1; i-k >= 0; k++) {
	double n = a[i-k][i] * -1;
	wtf(String.format("R%d * %.2f + R%d --> R%d\n", i+1, n, i-k+1, i-k+1));	
	System.out.printf("R%d * %.2f + R%d --> R%d\n", i+1, n, i-k+1, i-k+1);
	for (int j = 0; j < a[0].length; j++) {
	  a[i-k][j] += n*a[i][j];
	}
	write(a);
	print(a);
      }
    }
  }
} 

