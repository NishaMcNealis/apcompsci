import java.util.ArrayList;
import java.lang.reflect.Method;

public class mcCallable {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(4);
      }};
    OurInterface o = new OurInterface() {
        public int function(int i) {
          return 2*i;
        }
      };
    System.out.println(mapcar(o, list).toString());
  }

    public static ArrayList<Integer> mapcar(OurInterface o, ArrayList<Integer> a) {
	for(int i = 0; i < a.size(); i++) {
          a.set(i, o.function(a.get(i)));
	}
	return a;
    }
}

interface OurInterface {
  int function(int i);
}