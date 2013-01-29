import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class GenericMax<T> {
  public static void main(String[] args) {
    Collection<String> c = new ArrayList<String>();
    c.add("hello");
    c.add("world");
    c.add("zzzzzzzzz");
    c.add("i hate java");
    System.out.println(max(c));
  }

  public static <T extends Comparable<? super T>> boolean greater(T a, T b) {
    return a.compareTo(b) > 0;
  }

  public static <T extends Comparable<? super T>> T max(Collection c) {
    Iterator i = c.iterator();
    T max;
    if (i.hasNext()) max = (T) i.next();
    else return null;
    while (i.hasNext()) {
      T cur = (T) i.next();
      if (greater(cur, max)) max = cur;
    }
    return max;
  }
}
