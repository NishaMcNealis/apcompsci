public interface DataStructure {

  public void Insert(int element);

  public long InsertTest(int samplesize, int datasize);
  //calls Construct method of class
  //starts timer
  //inserts to the array
  //ends timer
  //returns time spent
    

  public void Search(int element);

  public long SearchTest(int samplesize, int datasize);
  //calls Construct method of class
  //starts timer
  //see if the array contains a randomly generated element
  //ends timer
  //returns time spent

  public void Delete(int index);

  public long DeleteTest(int samplesize, int datasize);
  //calls Construct method of class
  //starts timer
  //removes element at random index and shifts all other elements
  //ends timer
  //returns time spent
}
