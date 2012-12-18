import java.util.Random;
import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest {

  public static ArrayList<Integer> a;

  public void Insert(int element) {
    a.add(element);
  }

  public long InsertTest(int samplesize, int datasize) {
    a = new ArrayList<Integer>();
    Random rand = new Random();

    long start = System.nanoTime();
    for (int i = 0; i < samplesize; i++) {
      Insert(rand.nextInt(datasize+1));
    }
    return System.nanoTime()-start;
  }

  public void Search(int element) {
    for (int i = 0; i < a.size(); i++) {
      if (a.get(i) == element) {
        break;
      }
    }
  }

  public long SearchTest(int samplesize, int datasize) {
    Random rand = new Random();

    long start = System.nanoTime();
    Search(rand.nextInt(datasize+1));
    return System.nanoTime()-start;
  }

  public void Delete(int index) {
    a.remove(index);
  }

  public long DeleteTest(int samplesize, int datasize) {
    Random rand = new Random();

    long start = System.nanoTime();
    Delete(rand.nextInt(datasize+1));
    return System.nanoTime()-start;
  }
}
