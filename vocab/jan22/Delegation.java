class Delegation1 {
    void salmon() {
	this.trout();
    }
 
    void trout() {
	System.out.println("1.trout");
    }
};
 
class Delegation2 {
    private Delegation1 d;
 
    public Delegation2(Delegation1 e) {
        d = e;
    }
 
    void salmon() {
	d.salmon();
    }
 
    void trout() {
	System.out.println("2.trout");
    }
}

public class Delegation {
    public static void main(String[] args) {
	Delegation1 d1 = new Delegation1();
	Delegation2 d2 = new Delegation2(d1);

	d2.salmon();
    }
}