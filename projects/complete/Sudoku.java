import java.lang.Character;

class Sudoku {
  public static void main(String[] args) { 
    String exp = args[0];
    String[] rows = rows_from_string(exp);
    String[] cols = cols_from_rows(rows);
    String[] squares = squares_from_cols(cols);
    System.out.println(cols[0]);
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

  public static String[] cols_from_rows(String[] a) {
    String[] c = new String[9];
    for (int i = 0; i < c.length; i++) {
      c[i] = "";
    }
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < 9; j++) {
        c[j] += a[i].charAt(j);
      }
    }
    return c;
  }

  public static String[] squares_from_cols(String[] c) {
    String[] s = new String[9];
    for (i = 0; i < c.length; i++) {
      
    }
  }
}
