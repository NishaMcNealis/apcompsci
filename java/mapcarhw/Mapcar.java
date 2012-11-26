
public class Mapcar {
    
    public static void main(String[] args) {
	ArrayList<Integer> list = new ArrayList<Integer> () {{
		add(1);
		add(2);
		add(4);
	    }};
	
	System.out.println(mapcar(methods.function, list).toString());
    }
    
    public static ArrayList<Integer> mapcar(Callable<Integer> f, ArrayList<Integer> a) {
	for(int i = 0; i < a.size(); i++) {
	    a.set(i, f.call(a.get(i)));
	}
	return a;
    }
}
/*
interface methods {
    int function(int e);
    }*/