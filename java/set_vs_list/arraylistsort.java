import java.util.Random;
import java.util.ArrayList;

class arraylistsort {
  final static int MAX_VALUE = 1000000;
  final static int NUM_ELEMENTS = 10000000;
  final static double SAMPLE_SIZE = 100;

  public static void main(String[] args) {
    long avg = 0;
    for (int z = 0; z < SAMPLE_SIZE; z++) {
      ArrayList<Integer> q = new ArrayList();
      Random rand = new Random();
      long start = System.nanoTime();
      for (int i = 0; i < NUM_ELEMENTS; i++) {
        insertionsort(rand.nextInt(MAX_VALUE+1), q);
      }
      avg += System.nanoTime()-start;
    }
    System.out.println((avg/SAMPLE_SIZE)/1000000000.0);
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