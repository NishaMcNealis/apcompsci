import java.util.Random;

public class ArrayTest implements DataStructure {

  public int[] a;

  public void Insert(int element) {
    int[] b = new int[a.length + 1];
    
    for(int i = 0; i < a.length; i++) {
      b[i] = a[i];
    }

    b[a.length] = element;

    a = b;
  }

  public long InsertTest(int samplesize, int datasize) {
    a = new int[0];
    Random rand = new Random();

    long start = System.nanoTime();
    for(int i = 0; i < samplesize; i++) {
      Insert(rand.nextInt(datasize));
    }
    return System.nanoTime() - start;
  }

  public void Search(int element) {
    for(int i : a) {
      if(i == element) break;
    }
  }

  public long SearchTest(int samplesize, int datasize) {
    Random rand = new Random();

    long start = System.nanoTime();
    for(int i = 0; i < samplesize; i++) {
      Search(rand.nextInt(datasize));
    }
    return System.nanoTime() - start;
  }

  public void Delete(int index) {
    int[] b = new int[a.length - 1];

    for(int i = 0; i < a.length; i++) {
      if(i < index) b[i] = a[i];
      else if(i > index) b[i-1] = a[i];
    }
  }

  public long DeleteTest(int samplesize, int datasize) {
    Random rand = new Random();

    long start = System.nanoTime();
    Delete(rand.nextInt(samplesize));
    return System.nanoTime() - start;
  }
}
