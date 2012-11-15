import java.util.Random;
import java.util.ArrayList;
import java.util.TreeSet;

class sortingtimes {
  final static int MAX_VALUE = 1000000;
  final static int NUM_ELEMENTS = 10000000;
  final static double SAMPLE_SIZE = 2;

  public static void main(String[] args) {
    long arraylisttime = 0, settime = 0;

    for (int z = 0; z < SAMPLE_SIZE; z++) {
      ArrayList<Integer> q = new ArrayList();
      TreeSet<Integer> mySet = new TreeSet<Integer>();

      Random rand = new Random();
      long start = System.nanoTime();

      for (int i = 0; i < NUM_ELEMENTS; i++) {
        insertionsort(rand.nextInt(MAX_VALUE+1), q);
      }
      arraylisttime += System.nanoTime()-start;

      start = System.nanoTime();
      for(int j = 0; j < NUM_ELEMENTS; j++) {
        mySet.add(rand.nextInt(MAX_VALUE + 1));
      }
      settime += System.nanoTime()-start;

    }

    System.out.println("list: " + (arraylisttime/SAMPLE_SIZE)/1000000000.0);
    System.out.println("set: "  + (settime/SAMPLE_SIZE)/1000000000.0);
  }

  public static void insertionsort(int val, ArrayList<Integer> a) {
    for (int i = 0; i < a.size(); i++) {
      if (i+1 < a.size()) {
        if (val >= a.get(i) && val <= a.get(i+1)) {
          a.add(i+1, val);
          return;
        }
      }
      else {
        a.add(val);
        return;
      }
    }
  }
}