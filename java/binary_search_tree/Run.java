import java.util.Random;

public class Run {
  public static BSTNode tree;
  public static int[] arr = new int[10];
  
  public static void main(String[] args) {
    tree = new BSTNode();

    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) ((new Random()).nextDouble()*arr.length);
    }

    tree.populate(arr);
  }

  public int[] randomize(int total) {
    Random rand = new Random();
    int r;
    int[] arr = new int[total];
    boolean watchdog;
  
    for(int i = 0; i < total; i++) {
      watchdog = true;
      while(watchdog) {
        r = (int) (rand.nextDouble() * total);
        if(new Integer(arr[r]) == null) {
          arr[r] = (int) i;
          watchdog = false;
        }
      }
    }
    return arr;
  }
}

