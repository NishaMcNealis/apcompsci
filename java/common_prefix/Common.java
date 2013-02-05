public class Common {
  public static void main(String[] args) {
    String first = "Fishsticks";
    String second = "Fishguts";

    String third = "Kuszmaul!";
    String fourth = "Where do bears go shopping?\nAt the maul!";

    System.out.println(prefix(first, second));
    System.out.println(suffix(third, fourth));
  }

  public static String prefix(String a, String b) {
    String ret = "";
    int size = a.length();
    if(b.length() < a.length()) {
      size = b.length();
    }

    for(int i = 0; i < size; i++) {
      if(a.substring(0,i).equals(b.substring(0,i))) {
	ret = a.substring(0,i);
      }
    }
    
    return ret;
  }
  
  public static String suffix(String a, String b) {
    String ret = "";
    int size = a.length();
    if(b.length() < a.length()) {
      size = b.length();
    }
    
    for(int i = 1; i < size; i++) {
      if(a.substring(a.length()-i).equals(b.substring(b.length()-i))) {
      ret = a.substring(a.length()-i);
      }
    }
    
    return ret;
  }
}

