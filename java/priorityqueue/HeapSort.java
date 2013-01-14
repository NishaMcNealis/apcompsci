import java.util.PriorityQueue;
import java.util.ArrayList;

public class HeapSort {
  public static ArrayList<Integer> heapSort(ArrayList<Integer> list) {
    PriorityQueue<Integer> x = new PriorityQueue<Integer>(list);

    ArrayList<Integer> ret = new ArrayList<Integer>();

    while(x.peek() != null) {
      ret.add(x.poll());
    }

    return ret;
  }
}