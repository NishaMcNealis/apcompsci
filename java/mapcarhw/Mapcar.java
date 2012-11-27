import java.util.ArrayList;
import java.lang.reflect.Method;
import java.lang.Integer;
public class Mapcar {
    
    public static void main(String[] args) {
	ArrayList<Integer> list = new ArrayList<Integer> () {{
		add(1);
		add(2);
		add(4);
	    }};
	Class[] paramtypes = new Class[1];
	paramtypes[0] = ArrayList.class;
     
	try {
	    Method meth = Mapcar.class.getMethod("function", paramtypes);
	}
	catch (NoSuchMethodException e) {
	    System.err.println("No method found");
	}
	Mapcar m = new Mapcar();
	try {
	    System.out.println(m.mapcar(m, meth, list).toString());
	}
	catch (error e) {}
    }
    
    public static ArrayList<Integer> mapcar(Object o, Method f, ArrayList<Integer> a) {
	Object[] params = new Object[1];
	try {
	    for(int i = 0; i < a.size(); i++) {
		params[0] = a.get(i);
	
		a.set(i, Integer.parseInt(f.invoke(o, params).toString()));
	  
	    }
	}
	catch(Exception e) {
	    System.err.println(e.toString());
	}
	return a;
    }
    
    public static int function(int n) {
	//as an example
	return 2*n;
    }
}