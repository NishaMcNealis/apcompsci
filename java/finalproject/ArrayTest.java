import java.util.Random;

public class ArrayTest implements DataStructure {

  public static int[] a;

  public static void Insert(int element) {
    int[] b = new int[a.length + 1];
    
    for(int i = 0; i < a.length; i++) {
      b[i] = a[i];
    }

    b[a.length] = element;

    a = b;
  }

  public static int InsertTest(int samplesize, int datasize) {
    a = new int[0];
    Random rand = new Random();

    int start = System.nanoTime();
    for(int i = 0; i < samplesize; i++) {
      Insert(rand.nextInt(datasize));
    }
    return System.nanoTime() - start;
  }

  public static void Search(int element) {
    for(int i : a) {
      if(i == element) return true;
    }
    return false;
  }

  public static int SearchTest(int samplesize, int datasize) {
    Random rand = new Random();

    int start = new Random();
    for(int i = 0; i < samplesize; i++) {
      Search(rand.nextInt(datasize));
    }
    return System.nanoTime() - start;
  }

  public static void Delete(int index) {
    int[] b = new int[a.length - 1];

    for(int i = 0; i < a.length; i++) {
      if(i < index) b[i] = a[i];
      else if(i > index) b[i-1] = a[i];
    }
  }

  public static int DeleteTest(int samplesize, int datasize) {
    Random rand = new Random();

    int start = new Random();
    for(int i = 0; i < samplesize; i++) {
      Delete(rand.nextInt(datasize));
    }
    return System.nanoTime() - start;
  }
}
