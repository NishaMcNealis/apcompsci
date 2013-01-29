import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*

needs:
-isEmpty

*/

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
    T last = (T) c.toArray()[size()-1];
    
  }

  public T pop(int index) {

  }

  public T peek() {

  }

  public T peek(int index) {

  }
}
