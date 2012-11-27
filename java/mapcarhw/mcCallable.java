import java.util.ArrayList;
import java.lang.reflect.Method;
import java.util.Arrays;

public class mcCallable {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(4);
      }};
    int[] a = new int[] {1, 3, 4};
    OurInterface o = new OurInterface() {
        public int function(int i) {
          return 2*i;
        }
        public double function(double i) {
          return 2*i;
        }
      };
    // requires Arrays.toString() on result to print for arrays
    // requires .toString() on result to print for ArrayList
    System.out.println(Arrays.toString(mapcar(o, a)));
  }
  
  public static ArrayList<Integer> mapcar(OurInterface o, ArrayList<Integer> a) {
    for(int i = 0; i < a.size(); i++) {
      a.set(i, o.function(a.get(i)));
    }
    return a;
  }

  public static int[] mapcar(OurInterface o, int[] a) {
    for (int i = 0; i < a.length; i++) {
      a[i] = o.function(a[i]);
    }
    return a;
  }
}

interface OurInterface {
  int function(int i);
  double function(double i);
}