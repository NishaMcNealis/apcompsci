import java.util.ArrayList;
import java.lang.reflect.Method;

public class Mapcar {
    
    public static void main(String[] args) {
	ArrayList<Integer> list = new ArrayList<Integer> () {{
		add(1);
		add(2);
		add(4);
	    }};
	Class[] paramtypes = new Class[1];
	paramtypes[0] = ArrayList.class;

	Mapcar m = new Mapcar();
	System.out.println(m.mapcar(m, Mapcar.class.getMethod("function", paramtypes), list).toString());
    }
    
    public static ArrayList<Integer> mapcar(Object o, Method f, ArrayList<Integer> a) {
	Object[] params = new Object[1];
	for(int i = 0; i < a.size(); i++) {
	    params[0] = a.get(i);
	    System.out.println(f.invoke(o, params));
// a.set(i, f.invoke(o, params));
	}
	return a;
    }
    
    public static int function(int n) {
	//as an example
	return 2*n;
    }
}