import java.util.Random;

public class Run {
  public static void main(String[] args) {
    BSTNode tree = new BSTNode();

  }
}

public BinarySearch populate(int[] arr) {
  for(int i = 0; i < arr.length; i++) {
    tree.insert(arr[i]);
  }
}

public int[] randomize(int total) {
  Random rand = new Random();
  Integer[] arr = new Integer[1000];
  boolean watchdoge;

  for(int i = 0; i < total; i++) {
    watchdoge = true;
    while(watchdoge) {
      r = (int)(r.nextDouble() * 1000);
      if(arr[r] == null) {
	arr[r] = i;
	watchdoge = false;
      }
    }
  }
  
  return arr;
}