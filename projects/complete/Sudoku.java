import java.lang.Character;

class Sudoku {
  public static void main(String[] args) { 
    String exp = args[0];
    System.out.println(rows_from_string(exp)[0]);
  }
  
  public static boolean string_include(String s, char c) {
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == c) {
	return true;
      }
    }
    return false;
  }

  public static boolean segment_valid(String seg) {
    for (int i = 1; i < 10; i++) {
      if (!string_include(seg, Character.forDigit(i, 10))) return false;
    }
    return true;
  }

  public static boolean segment_valid(String[] segs) {
    for (int i = 0; i < segs.length; i++) {
      if (!segment_valid(segs[i])) return false;
    }
    return true;
  }

  public static String[] rows_from_string(String s) {
    String[] a = new String[9];
    for (int i = 0; i < 9; i++) {
      a[i] = s.substring(i*9,i*9+9);
    }
    return a;
  }

  public static String[] columns_from_row_array(String[] a) {

  }
}