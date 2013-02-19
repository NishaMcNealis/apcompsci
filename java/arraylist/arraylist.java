import java.util.ArrayList;
import java.lang.Integer;

class arraylist {
  private ArrayList<Integer> del;
  private int[] arr;

  public arraylist() {
    del = new ArrayList<Integer>();
    
    arr = new int[10];
  }

  public arraylist(int initial) {
    del = new ArrayList<Integer>(initial);
    
    arr = new int[initial];
  }

  public boolean add(int e) {
    del.add(e);

    int[] inter = new int[arr.length+1];
    for(int i = 0; i < arr.length-1; i++) {
      inter[i] = arr[i];
    }
    inter[arr.length] = e;
    arr = inter;
    
    return true;
  }
  
  public boolean add(int index, int e) {
    del.add(index, e);

    int[] inter = new int[arr.length+1];
    int i;
    for(i = 0; i < index; i++) {
      inter[i] = arr[i];
    }
    inter[i++] = e;
    for(i = i; i < arr.length; i++) {
      inter[i+1] = arr[i];
    }
    return true;
  }
  
  
  // sync allows methods to be delegated to the arraylist
  public void sync() {
    arr = int[del.size()];
    
    for(int i = 0; i < arr.length; i++) {
      arr[i] = del.get(i);
    }
  }
  
  // begin delegation
  
}