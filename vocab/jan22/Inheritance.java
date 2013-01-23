public class Inheritance {
    private int x;
    private int y;
    
    public Inheritance() {
	x = 3;
	y = 1;
    }
    
    public Inheritance(int x1, int y1) {
	x = x1;
	y = y1;
    }
} 

public class Subclass extends Inheritance {
    int z;

    public Subclass() {
	super();
	z = 4;
    }
    
    public Subclass(int x1, int y1, int z1) {
	x = x1;
	y = y1;
	z = z1;
    }
}