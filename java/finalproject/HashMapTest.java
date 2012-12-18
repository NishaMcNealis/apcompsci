import java.util.Random;
import java.util.HashMap;

public class HashMapTest implements DataStructure {

  static HashMap<Integer, Integer> h;

  public static void Insert(int element) {
    h.put(element, element);
  }

  public static long InsertTest(int samplesize, int datasize) {
    h = new HashMap<Integer, Integer>(0);
    Random rand = new Random();

    int start = System.nanoTime();
    for(int i = 0; i < samplesize; i++) {
      Insert(rand.nextInt(datasize));
    }
    
    return System.nanoTime() - start;
  }

  public static void Search(int element) {
    h.containsKey(element);
  }

  public static long SearchTest(int samplesize, int datasize) {
    Random rand = new Random();

    int start = System.nanoTime();
    Search(rand.nextInt(datasize));      
    return System.nanoTime() - start;
  }
  
  public static void Delete(int index) {
    h.remove(index);
  }
  
  public static long DeleteTest(int samplesize, int datasize) {
    Random rand = new Random();

    int start = System.nanoTime();
    Delete(rand.nextInt(datasize));
    return System.nanoTime() - start;
  }
