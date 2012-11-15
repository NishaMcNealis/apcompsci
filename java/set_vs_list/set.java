import java.util.Random;
import java.util.TreeSet;

public class set {
    final static int MAX_VALUE = 1000000;
    final static int NUM_OF_ELEMENTS = 10000000;
    final static double SAMPLE_SIZE = 2;

    public static void main(String[] args)  {
	long timeSum = 0;

	for(int i = 0; i < SAMPLE_SIZE; i++) {
	    Random rand = new Random();

	    TreeSet<Integer> mySet = new TreeSet<Integer>();
	    long start = System.nanoTime();
	    for(int j = 0; j < NUM_OF_ELEMENTS; j++) {
		mySet.add(rand.nextInt(MAX_VALUE + 1));
	    }
	    
	    timeSum += System.nanoTime() - start;
	}
	System.out.println("Elapsed time average:  " + (timeSum/SAMPLE_SIZE)/1000000000.0);
	

    }
}