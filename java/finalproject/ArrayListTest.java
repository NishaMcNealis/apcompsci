import java.util.Random;
import java.util.ArrayList;

public class ArrayListTest {

  public static ArrayList<Integer> a;

  public static void Insert(int element) {
    a.push(element);
  }

  public static int InsertTest(int samplesize, int datasize) {
    a = new ArrayList<Integer>();
    Random rand = new Random();

    int start = System.nanoTime();
    for (int i = 0; i < samplesize; i++) {
      Insert(rand.nextInt(datasize));
    }
    return System.nanoTime()-start;
  }

  public static void Search(int element) {
    for (int i = 0; i < a.size(); i++) {
      if (a.get(i) == element) {
        break;
      }
    }
  }

  public static int SearchTest(int samplesize, int datasize) {
    Random rand = new Random();

    int start = System.nanoTime();
    Search(rand.nextInt(datasize));
    return System.nanoTime-start;
  }

  public static void Delete(int index) {
    a.remove(index);
  }

  public static int DeleteTest(int samplesize, int datasize) {
    Random rand = new Random();

    int start = System.nanoTime();
    Delete(rand.nextInt(datasize));
    return System.nanoTime-start;
  }
}
