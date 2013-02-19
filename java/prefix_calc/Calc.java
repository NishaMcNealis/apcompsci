import java.lang.Math;
import java.util.ArrayList;
import java.lang.Character;

class Calc {
  public static String prefix_string = "+ 1 * 3 4";
  public static String postfix_string;

  public static ArrayList<Character> ops;

  public static OurStack postfix;
  public static OurStack res;

  public static void main(String[] args) {
    res = new OurStack();

    ops = new ArrayList<String>();
    ops.add('+');
    ops.add('-');
    ops.add('*');
    ops.add('/');
    ops.add('^');
    
    postfix_string = reverse(prefix_string);
    postfix = new OurStack(new ArrayList<String>(postfix_string.split(" ")));

    pretty_print(postfix);
  }

  public static int process(ArrayList<String> post) {
    String x;
    int a, b, res = 0;

    for (String s : postfix_string) {
      if (is_dig(s)) {
        res.push(Integer.parseInt(s));
      }
      else {
        b = res.pop();
        a = res.pop();
        
      }
    }
  }

  public static void pretty_print(String[] arr) {
    for (String s : arr) {
      System.out.print(s+",");
    }
    System.out.println("");
  }

  public static String reverse(String s) {
    return new StringBuffer(s).reverse().toString();
  }

  public boolean is_op(String s) {
    return ops.contains(s);
  }

  public boolean is_dig(Character c) {
    return Character.isDigit(c);
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