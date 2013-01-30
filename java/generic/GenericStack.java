import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class GenericStack<T> extends GenericMax {
  private Collection c;

  public static void main(String[] args) {
    // do something, i guess...?
  }

  public boolean isEmpty() {
    return c.isEmpty();
  }

  public int size() {
    return c.size();
  }

  public int copy(int morespace) {
    Collection temp;
    Object[] arr = c.toArray();
    for (int i = 0; i < size(); i++) {
      temp.add(arr[i]);
    }
    for (int i = 0; i < morespace; i++) {
      temp.add(null);
    }
    c = temp;
    return size();
  }

  public int push(T e) {
    c.add((Object) e);
  }

  public T pop() {
    Collection temp;
    Object[] arr = deleteFromArray(c.toArray(),size()-1);

    for(int i = 0; i < arr.length; i++) {
      temp.add(arr[i]);
    }

    T last = peek();
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
