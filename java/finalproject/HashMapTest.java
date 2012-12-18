import java.util.Random;
import java.util.HashMap;

public class HashMapTest implements DataStructure {

  //declare public hashmap here to use in code

  static HashMap<Integer, Integer> h = new HashMap<Integer, Integer>(0);
	

  public static void Insert(int element) {
    h.put(element, element);
  }

  public static int InsertTest(int samplesize, int datasize) {
    h = new HashMap<Integer, Integer>(0);
    Random rand = new Random();

    int start = System.nanoTime();
    for(int i = 0; i < samplesize; i++) {
      Insert(rand.nextInt(datasize);
	     }
		
	return System.nanoTime() - start;
    }

    public static void Search(int element) {
      h.containsKey(element);
      break;
    }

    public static int SearchTest(int samplesize, int datasize) {
      Random rand = new Random();

      int start = System.nanoTime();
      for(int i = 0; i < samplesize; i++) {
	Search(rand.nextInt(datasize);
	       }
		
	  return System.nanoTime() - start;
      }

      public static void Delete(int index) {
	h.remove(index);
      }

      public static int DeleteTest(int samplesize, int datasize) {
	Random rand = new Random();

	int start = System.nanoTime();
	for(int i = 0; i < samplesize; i++) {
	  Delete(rand.nextInt(datasize);
		 }
		
	    return System.nanoTime() - start;
	}
      }
    }
  }
}
