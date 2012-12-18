public class Run {
  public static final int NUM_TRIALS_PER = 2;
  public static final int HIGH_RANGE_TESTED = 3; //10^x
  public static final int HIGH_SIZE_TESTED = 3; //10^x
  public static void main(String[] args) {
    //main method
    runops();
  }
    
  public static void runops() {
    //runs all of the operations set out in other files
	
    System.out.println("StructureName,ElementRange,SizeRange,InsertAverage,SearchAverage,DeleteAverage");

    for(int i = 0; i <= HIGH_RANGE_TESTED; i++) {
      for(int j = 0; j <= HIGH_SIZE_TESTED; j++) {
        // testing arraylist
        ArrayListTest al = new ArrayListTest();
        long ins_avg, search_avg, del_avg = ins_avg = search_avg = 0;
        for(int k = 0; k < NUM_TRIALS_PER; k++) {
          ins_avg += al.InsertTest(j,i);
          search_avg += al.SearchTest(j,i);
          del_avg += al.DeleteTest(j,i);
        }
        System.out.println(String.format("ArrayList,%d,%d,%d,%d,%d",i,j,ins_avg,search_avg,del_avg));

        /*        
        // testing array
        ArrayTest a = new ArrayTest();
        ins_avg = search_avg = del_avg = 0;
        for(int k = 0; k < NUM_TRIALS_PER; k++) {
          ins_avg += a.InsertTest(j,i);
          search_avg += a.SearchTest(j,i);
          del_avg += a.DeleteTest(j,i);
        }
        System.out.println(String.format("Array,%d,%d,%d,%d,%d",i,j,ins_avg,search_avg,del_avg));
        */

        // testing treeset
        TreeSetTest ts = new TreeSetTest();
        ins_avg = search_avg = del_avg = 0;
        for(int k = 0; k < NUM_TRIALS_PER; k++) {
          ins_avg += ts.InsertTest(j,i);
          search_avg += ts.SearchTest(j,i);
          del_avg += ts.DeleteTest(j,i);
        }
        System.out.println(String.format("TreeSet,%d,%d,%d,%d,%d",i,j,ins_avg,search_avg,del_avg));
        
        /*
        // testing hashmap
        HashMapTest hm = new HashMapTest();
        ins_avg = search_avg = del_avg = 0;
        for(int k = 0; k < NUM_TRIALS_PER; k++) {
          ins_avg += hm.InsertTest(j,i);
          search_avg += hm.SearchTest(j,i);
          del_avg += hm.DeleteTest(j,i);
        }
        System.out.println(String.format("HashMap,%d,%d,%d,%d,%d",i,j,ins_avg,search_avg,del_avg));
        */
      }
    }
  }
}
