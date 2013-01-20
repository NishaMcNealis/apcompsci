import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Run {
  public static final int NUM_TRIALS_PER = 100;
  public static final int HIGH_RANGE_TESTED = 1000; //10^x
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
    int j = 1000;

    try {
      PrintWriter ALOut = new PrintWriter(new BufferedWriter(new FileWriter("ArrayListTest.csv")), true);
      PrintWriter AOut = new PrintWriter(new BufferedWriter(new FileWriter("ArrayTest.csv")), true);
      PrintWriter TSOut = new PrintWriter(new BufferedWriter(new FileWriter("TreeSetTest.csv")), true);
      PrintWriter HMOut = new PrintWriter(new BufferedWriter(new FileWriter("HashMapTest.csv")), true);

      ALOut.println("StructureName,ElementRange,SizeRange,InsertAverage,SearchAverage,DeleteAverage");
      AOut.println("StructureName,ElementRange,SizeRange,InsertAverage,SearchAverage,DeleteAverage");
      TSOut.println("StructureName,ElementRange,SizeRange,InsertAverage,SearchAverage,DeleteAverage");
      HMOut.println("StructureName,ElementRange,SizeRange,InsertAverage,SearchAverage,DeleteAverage");

      for(int i = 1; i <= HIGH_RANGE_TESTED; i++) {
        // testing arraylist
        long ins_avg, search_avg, del_avg = ins_avg = search_avg = 0;

        for(int k = 0; k < NUM_TRIALS_PER; k++) {
          al = new ArrayListTest();
          ins_avg += al.InsertTest(i,j);
          search_avg += al.SearchTest(i,j);
          del_avg += al.DeleteTest(i,j);
        }
        ins_avg /= NUM_TRIALS_PER;
        search_avg /= NUM_TRIALS_PER;
        del_avg /= NUM_TRIALS_PER;
        ALOut.printf("ArrayList,%d,%d,%d,%d,%d\n",i,j,ins_avg,search_avg,del_avg);
	
        // testing array
        ins_avg = search_avg = del_avg = 0;
        for(int k = 0; k < NUM_TRIALS_PER; k++) {
          a = new ArrayTest();	    
          ins_avg += a.InsertTest(j,i);
          search_avg += a.SearchTest(j,i);
          del_avg += a.DeleteTest(j,i);
        }
        ins_avg /= NUM_TRIALS_PER;
        search_avg /= NUM_TRIALS_PER;
        del_avg /= NUM_TRIALS_PER;
        AOut.printf("Array,%d,%d,%d,%d,%d\n",i,j,ins_avg,search_avg,del_avg);

        // testing treeset
        ins_avg = search_avg = del_avg = 0;
        for(int k = 0; k < NUM_TRIALS_PER; k++) {
          ts = new TreeSetTest();
          ins_avg += ts.InsertTest(j,i);
          search_avg += ts.SearchTest(j,i);
          del_avg += ts.DeleteTest(j,i);
        }
        ins_avg /= NUM_TRIALS_PER;
        search_avg /= NUM_TRIALS_PER;
        del_avg /= NUM_TRIALS_PER;
        TSOut.printf("TreeSet,%d,%d,%d,%d,%d\n",i,j,ins_avg,search_avg,del_avg);

        // testing hashmap
        ins_avg = search_avg = del_avg = 0;
        for(int k = 0; k < NUM_TRIALS_PER; k++) {
          hm = new HashMapTest();
          ins_avg += hm.InsertTest(i,j);
          search_avg += hm.SearchTest(i,j);
          del_avg += hm.DeleteTest(i,j);
        }
        ins_avg /= NUM_TRIALS_PER;
        search_avg /= NUM_TRIALS_PER;
        del_avg /= NUM_TRIALS_PER;
        HMOut.printf("HashMap,%d,%d,%d,%d,%d\n",i,j,ins_avg,search_avg,del_avg);

        if (i%90 == 0) System.out.println("reached range: "+i);
      }

      ALOut.close();
      AOut.close();
      TSOut.close();
      HMOut.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
