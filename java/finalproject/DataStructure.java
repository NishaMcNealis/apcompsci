public interface DataStructure {

  public static void Insert(int element);

  public static int InsertTest(int samplesize, int datasize);
  //calls Construct method of class
  //starts timer
  //inserts to the array
  //ends timer
  //returns time spent
    

  public static void Search(int element);

  public static int SearchTest(int samplesize, int datasize);
  //calls Construct method of class
  //starts timer
  //see if the array contains a randomly generated element
  //ends timer
  //returns time spent

  public static void Delete(int index);

  public static int DeleteTest(int samplesize, int datasize);
  //calls Construct method of class
  //starts timer
  //removes element at random index and shifts all other elements
  //ends timer
  //returns time spent
}
