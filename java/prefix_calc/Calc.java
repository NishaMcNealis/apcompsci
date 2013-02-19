import java.lang.Math;
import java.util.ArrayList;
import java.lang.Character;

class Calc {
  public static String prefix_string = "+ 1 * 3 4";

  public static String[] prefix_arr;
  public static ArrayList<Character> ops;
  public static OurStack op_stack, arg_stack;

  public static void main() {
    op_stack = arg_stack = new OurStack();
    ops = new ArrayList<Character>();
    ops.add('+');
    ops.add('-');
    ops.add('*');
    ops.add('/');
    ops.add('^');
    prefix_arr = prefix_string.split(" ");

    System.out.println(prefix_arr.toString());
  }

  public boolean is_op(char c) {
    return ops.contains(c);
  }

  public int do_op(char op, int a, int b) {
    int res;
    switch (op) {
    case '+':
      res = a+b;
      break;
    case '-':
      res = a-b;
      break;
    case '*':
      res = a*b;
      break;
    case '/':
      res = a/b;
      break;
    case '^':
      res = (int) Math.pow(a, b);
      break;
    default:
      res = 0;
      break;
    }
    return res;
  }
}