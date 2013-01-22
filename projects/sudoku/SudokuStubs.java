import java.lang.Character;

class Sudoku {
  public static void main(String[] args) { 
    //execute the entire program based on argument
    //print true if solution is valid; false if invalid
  }
  
  public static boolean string_include(String s, char c) {
    //return true if the string contains the character
  }

  public static boolean segment_valid(String seg) {
    //return true if the segment (a group of numbers) is valid
  }

  public static boolean section_valid(String[] segs) {
    //return true if the section (a group of segments) is valid
  }

  public static boolean puzzle_valid(String[] rows, String[] cols, String[] squares) {
    //return true if the entire puzzle is valid
  }

  public static String[] rows_from_string(String s) {
    //returns an array of rows based on the input string
  }

  public static String[] cols_from_rows(String[] a) {
    //returns an array of columns based on an array of rows
  }

  public static String section_from_string(String s, int which) {
    //returns a 'square' based on a string
  }

  public static String[] squares_from_rows(String[] r) {
    //returns an array of 'squares' based on an array of rows
  }
}
