public class BinarySearch {
  Integer val;
  BinarySearch left;
  BinarySearch right;
  
  BinarySearch() {
    
  }
  
  BinarySearch(Integer n) {
    val = n;
  }

  public void insert(Integer n) {
    if(val == null) {
      val = n;
    }
    else if(n > val) {
      if (right == null) {
	right = new BinarySearch(n);
      }
      else {
	right.insert(n);
      }
    }
    else if(n < val) {
      if(left == null) {
	left = new BinarySearch(n);
      }
      else {
	left.insert(n);
      }
    }
  }
}