public class Strings {
  public static void main(String[] args) {
    String st1, st2, st3, st4, st5;
    
    st1 = "foo";
    st2 = "foo";
    st3 = st1;
    st4 = "food";
    char c[] = {'f', 'o', 'o'};
    st5 = new String(c);

    //test for equality
    System.out.println(
		       "Using ==\n   "
		       + (st1 == st2) + " "
		       + (st1 == st3) + " "
		       + (st1 == st4.substring(0,3)) + " "
		       + (st1 == st5)
		       );     
    System.out.println(
		       "Using .equals()\n   "
		       + (st1.equals(st2)) + " "
		       + (st1.equals(st3)) + " "
		       + (st1.equals(st4.substring(0,3))) + " "
		       + (st1.equals(st5)) + " "
		       );
  }
}