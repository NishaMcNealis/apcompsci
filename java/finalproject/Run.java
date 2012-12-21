import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Run {
  public static final int NUM_TRIALS_PER = 10;
  public static final int HIGH_RANGE_TESTED = 10; //10^x
  public static final int HIGH_SIZE_TESTED = 10; //10^x
  public static void main(String[] args) {
    //main method
    runops();
  }
    
  public static void runops() {
    //runs all of the operations set out in other files

    ArrayListTest al;
    ArrayTest a;
    TreeSetTest ts;
    HashMapTest hm;

    for(int i = 1; i <= HIGH_RANGE_TESTED; i++) {
      for(int j = 1; j <= HIGH_SIZE_TESTED; j++) {
        // testing arraylist
	long ins_avg, search_avg, del_avg = ins_avg = search_avg = 0;

	try {
        
	  PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ArrayListTest.csv")));

	  out.println("StructureName,ElementRange,SizeRange,InsertAverage,SearchAverage,DeleteAverage");

	  for(int k = 0; k < NUM_TRIALS_PER; k++) {
	    al = new ArrayListTest();
	    ins_avg += al.InsertTest(i,j);
	    search_avg += al.SearchTest(i,j);
	    del_avg += al.DeleteTest(i,j);
	  }
	  ins_avg /= NUM_TRIALS_PER;
	  search_avg /= NUM_TRIALS_PER;
	  del_avg /= NUM_TRIALS_PER;
	  out.printf("ArrayList,%d,%d,%d,%d,%d\n",i,j,ins_avg,search_avg,del_avg);
	
	  out.close();

	  out = new PrintWriter(new BufferedWriter(new FileWriter("ArrayTest.csv")));

	  out.println("StructureName,ElementRange,SizeRange,InsertAverage,SearchAverage,DeleteAverage");

	  // testing array
	  ins_avg = search_avg = del_avg = 0;
	  for(int k = 0; k < NUM_TRIALS_PER; k++) {
	    ins_avg += a.InsertTest(j,i);
	    search_avg += a.SearchTest(j,i);
	    del_avg += a.DeleteTest(j,i);
	  }
	  ins_avg /= NUM_TRIALS_PER;
	  search_avg /= NUM_TRIALS_PER;
	  del_avg /= NUM_TRIALS_PER;
	  out.printf("Array,%d,%d,%d,%d,%d",i,j,ins_avg,search_avg,del_avg);

	  out.close();

	  out = new PrintWriter(new BufferedWriter(new FileWriter("TreeSetTest.csv")));

	  out.println("StructureName,ElementRange,SizeRange,InsertAverage,SearchAverage,DeleteAverage");

	  // testing treeset
	  ins_avg = search_avg = del_avg = 0;
	  for(int k = 0; k < NUM_TRIALS_PER; k++) {
	    ins_avg += ts.InsertTest(j,i);
	    search_avg += ts.SearchTest(j,i);
	    del_avg += ts.DeleteTest(j,i);
	  }
	  ins_avg /= NUM_TRIALS_PER;
	  search_avg /= NUM_TRIALS_PER;
	  del_avg /= NUM_TRIALS_PER;
	  out.printf("TreeSet,%d,%d,%d,%d,%d",i,j,ins_avg,search_avg,del_avg);

	  out.close();

	  out = new PrintWriter(new BufferedWriter(new FileWriter("HashMapTest.csv")));

	  out.println("StructureName,ElementRange,SizeRange,InsertAverage,SearchAverage,DeleteAverage");

	  // testing hashmap
	  ins_avg = search_avg = del_avg = 0;
	  for(int k = 0; k < NUM_TRIALS_PER; k++) {
	    ins_avg += hm.InsertTest(i,j);
	    search_avg += hm.SearchTest(i,j);
	    del_avg += hm.DeleteTest(i,j);
	  }
	  ins_avg /= NUM_TRIALS_PER;
	  search_avg /= NUM_TRIALS_PER;
	  del_avg /= NUM_TRIALS_PER;
	  out.printf("HashMap,%d,%d,%d,%d,%d\n",i,j,ins_avg,search_avg,del_avg);
	
	  out.close();
	} catch (IOException ie) {
	  ie.printStackTrace();
	  System.err.println("something odd happened");
	}
      }
    }
  }
}
