public interface DataStructure {

    public static int[] Construct(int samplesize, int datasize);
	//defines an array with specified length
	//creates random ints between 0 and datasize to fill each slot
	//returns the array

    public static int Insert(int samplesize, int datasize);
	//calls Construct
	//starts timer
	//inserts to the array
	//ends timer
	//returns time spent
    

    public static int Search(int samplesize, int datasize);
	//calls Construct
	//starts timer
	//see if the array contains a randomly generated element
	//ends timer
	//returns time spent
    

    public static int Delete(int samplesize, int datasize);
	//calls Construct
	//starts timer
	//removes element at random index and shifts all other elements
	//ends timer
	//returns time spent
    
}
