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
    Collection temp = new Collection();
    T[] temp = new T[c.size()-1];
    c = new T[].addAll(ArrayUtils.removeElement(c.toArray(),c.size()-1));
 
    return last;
  }

  public T peek() {
    return (T) c.toArray()[size()-1];
  }
}
