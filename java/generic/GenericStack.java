import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class GenericStack<T> extends GenericMax {
  private Collection c;

  public static void main(String[] args) {
    
  }

  public boolean isEmpty() {
    return c.isEmpty();
  }

  public int size() {
    return c.size();
  }

  public int copy(int morespace) {
    // provide your own code here for copying the Collection into a Collection of greater size
  }

  public int push(T e) {
    c.add((Object) e);
  }

  public T pop() {
    T last = (T) c.toArray()[c.size()-1];
    Collection temp;
    Object[] arr = deleteFromArray(c.toArray(),size()-1));
  for(int i = 0; i < arr.length; i++) {
    temp.add(arr[i]);
  }
  c = temp;
  return last;
  }

  public T peek() {
    return (T) c.toArray()[size()-1];
  }

  public Object[] deleteFromArray(Object[] a,int index) {
    Object[] b = new Object[a.length - 1];

    for(int i = 0; i < a.length; i++) {
      if(i < index) b[i] = a[i];
      else if(i > index) b[i-1] = a[i];
    }
  }
}
