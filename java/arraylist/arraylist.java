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
  
  public void clear() {
    del.clear();

    arr = new int[arr.length];
  }

  public int[] clone() {
    return arr;
  }

  public boolean contains(int n) {
    for(int i = 0; i < arr.length; i++) {
      if(n == arr[i]) {
	return true;
      }
    }
    return false;
  }

  public void ensureCapacity(int min) {
    del.ensureCapacity(min);
    
    if(min > arr.length) {
      int[] inter = arr;
      arr = new int[min];
      
      for(int i = 0; i < inter.length; i++) {
	arr[i] = inter[i];
      }
    }
  }

  public int get(int index) {
    return arr[index];
  }
  
  public int indexOf(int n) {
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] == n) {
	return i;
      }
    }
    return -1;
  }

  public boolean isEmpty() {
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] != 0) {
	return false;
      }
    }
    return true;
  }

  public int lastIndexOf(int n) {
    for(int i = arr.length-1; i >= 0; i--) {
      if(arr[i] == n) {
	return i;
      }
    }
    return -1;
  }
  
  public int remove(int index) {
    del.remove(index);

    int ret = arr[index];
    int[] inter = arr;
    arr = new int[inter.length-1];
    for(int i = 0; i < index; i++) {
      arr[i] = inter[i];
    }
    for(int i = index; i < arr.length; i++) {
      arr[i] = inter[i+1];
    }

    return ret;
  }

  public int set(int index, int e) {
    del.set(index, e);

    int ret = arr[index];
    arr[index] = e;
    return ret;
  }
    
  public int size() {
    return arr.length;
  }

  public int[] toArray() {
    return arr;
  }

  public void trimToSize() {
    del.trimToSize();

    int nullspace = 0;
    for(int i = arr.length-1; i >= 0; i--) {
      if(arr[i] == 0) {
	nullspace++;
      }
      else{
	break;
      }
    }
    int[] inter = arr;
    arr = new int[inter.length-nullspace];
    for(int i = 0; i < arr.length; i++) {
      arr[i] = inter[i];
    }
  }
  
  // sync allows methods to be delegated to the arraylist
  public void sync() {
    arr = new int[del.size()];
    
    for(int i = 0; i < arr.length; i++) {
      arr[i] = del.get(i);
    }
  }
  
  // delegated because it is just a sequence of adding
  public boolean addAll(ArrayList<Integer> c) {
    boolean ret = del.addAll(c);
    sync();
    return ret;
  }

  // delegated because it is just a sequence of adding
  public boolean addAll(int index, ArrayList<Integer> c) {
    boolean ret = del.addAll(index, c);
    sync();
    return ret;
  }

  // delegated because remove is already done once
  public boolean remove(Object o) {
    boolean ret = del.remove(o);
    sync();
    return ret;
  }
}