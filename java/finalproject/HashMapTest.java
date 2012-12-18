import java.util.Random;
import java.util.HashMap;

public class HashMapTest implements DataStructure {

  public static HashMap<Integer, Integer> h;

  public void Insert(int element) {
    h.put(element, element);
  }

  public long InsertTest(int samplesize, int datasize) {
    h = new HashMap<Integer, Integer>(0);
    Random rand = new Random();

    long start = System.nanoTime();
    for(int i = 0; i < samplesize; i++) {
      Insert(rand.nextInt(datasize));
    }
    
    return System.nanoTime() - start;
  }

  public void Search(int element) {
    h.containsKey(element);
  }

  public long SearchTest(int samplesize, int datasize) {
    Random rand = new Random();

    long start = System.nanoTime();
    Search(rand.nextInt(datasize));      
    return System.nanoTime() - start;
  }
  
  public void Delete(int index) {
    h.remove(index);
  }
  
  public long DeleteTest(int samplesize, int datasize) {
    Random rand = new Random();

    long start = System.nanoTime();
    Delete(rand.nextInt(datasize));
    return System.nanoTime() - start;
  }
}
