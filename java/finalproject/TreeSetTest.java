import java.util.Random;
import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetTest implements DataStructure {

  public static TreeSet<Integer> t;

  public void Insert(int element) {
    t.add(element);
  }

  public long InsertTest(int samplesize, int datasize) {
    t = new TreeSet<Integer>();
    Random rand = new Random();

    long start = System.nanoTime();
    for (int i = 0; i < samplesize; i++) {
      Insert(rand.nextInt(datasize+1));
    }
    return System.nanoTime()-start;
  }

  public void Search(int element) {
    Iterator<Integer> it = t.iterator();
    int i = 0;

    while (it.hasNext()) {
      if (element == it.next()) {
        break;
      }
      else {
        i++;
      }
    }
  }

  public long SearchTest(int samplesize, int datasize) {
    Random rand = new Random();

    long start = System.nanoTime();
    Search(rand.nextInt(datasize+1));
    return System.nanoTime()-start;
  }
  
  public void Delete(int element) {
    t.remove(element);
  }

  public long DeleteTest(int samplesize, int datasize) {
    Random rand = new Random();

    long start = System.nanoTime();
    Delete(rand.nextInt(datasize+1)); // by element, not index
    return System.nanoTime()-start;
  }
}
