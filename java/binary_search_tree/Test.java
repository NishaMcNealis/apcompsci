import java.util.Random;

public class Test {
  public static void main(String[] args) {
    BSTNode tree = new BSTNode();

  }

  public int run(int numTrials) {
    int sum;
    for(int i = 0; i < numTrials; i++) {
      sum += trial();
    }
    return sum/numTrials;
  }
  
  public int trial() {
    return getDepth(populate(randomize(1000)));
  }
  
  public BSTNode populate(int[] arr) {
    BSTNode tree = new BSTNode();
    for(int i = 0; i < arr.length; i++) {
      tree.insert(arr[i]);
    }    
    return tree;
  }
  
  public int[] randomize(int total) {
    Random rand = new Random();
    Integer[] arr = new Integer[1000];
    boolean watchdoge;
    
    for(int i = 0; i < total; i++) {
      watchdoge = true;
      while(watchdoge) {
	int r = (int)(rand.nextDouble() * 1000);
	if(arr[r] == null) {
	  arr[r] = i;
	  watchdoge = false;
	}
      }
    }
    return toIntArr(arr);
  }

  public int[] toIntArr(Integer arr[]) {
    int[] ret = new int[arr.length];
    for(int i = 0; i < arr.length; i++) {
      ret[i] = arr[i];
    }
    return ret;
  }
}