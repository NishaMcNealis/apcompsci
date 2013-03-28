import java.util.Random;

public class Run {
  public static BSTNode tree;

  public static void main(String[] args) {
    System.out.println(run(10000));
  }

  public static double run(int numTrials) {
    double sum = 0;

    for (int i = 0; i < numTrials; i++) {
      sum += trial();
    }

    return sum/numTrials;
  }
  
  public static int trial() {
    tree = new BSTNode(randomize(1000));
    return tree.getDepth(tree);
  }
    
  public static int[] randomize(int total) {
    Random rand = new Random();
    Integer[] arr = new Integer[total];
    boolean watchdogge;
    
    for (int i = 0; i < total; i++) {
      watchdogge = true;
      while (watchdogge) {
	int r = (int) (rand.nextDouble() * total);

	if (arr[r] == null) {
	  arr[r] = i;
	  watchdogge = false;
	}
      }
    }
    return toIntArr(arr);
  }

  public static int[] toIntArr(Integer arr[]) {
    int[] ret = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      ret[i] = arr[i];
    }

    return ret;
  }
}