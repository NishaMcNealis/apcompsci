import java.util.Random;
import java.util.TreeSet;

public class TreeSetTest implements DataStructure {

  public static TreeSet<Integer> t;

  public static void Insert(int element) {
    t.add(element);
  }

  public static int InsertTest(int samplesize, int datasize) {
    t = new TreeSet<Integer>();
    Random rand = new Random();

    int start = System.nanoTime();
    for (int i = 0; i < samplesize; i++) {
      Insert(rand.nextInt(datasize));
    }
    return System.nanoTime()-start;
  }

  public static void Search(int element) {
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

  public static int SearchTest(int samplesize, int datasize) {
    Random rand = new Random();

    int start = System.nanoTime();
    Search(rand.nextInt(datasize));
    return System.nanoTime()-start;
  }
  
  public static void Delete(int element) {
    t.remove(element);
  }

  public static int DeleteTest(int samplesize, int datasize) {
    Random rand = new Random();

    int start = System.nanoTime();
    Delete(rand.nextInt(datasize)); // by element, not index
    return System.nanoTime()-start;
  }
}
