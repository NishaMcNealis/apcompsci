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
    for (int i = 0; i < samplesize; i++) {
      a.push(rand.nextInt(datasize));
    }
  }

  public static void Search(int element) {

  }

  public static int SearchTest(int samplesize, int datasize) {

  }

  public static void Delete(int index) {

  }

  public static int DeleteTest(int samplesize, int datasize) {
    
  }
}
