import java.util.ArrayList;
import java.lang.Character;
import java.util.Collections;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

class Calc {
  public static String prefix_string = "/ 2 + 4 3";
  public static String postfix_string;

  public static ArrayList<String> postfix;
  public static OurStack res = new OurStack();

  public static void main(String[] args) {
    postfix_string = reverse(prefix_string);
    postfix = new ArrayList<String>();
    Collections.addAll(postfix, postfix_string.split(" "));
    System.out.println(process(postfix));
  }

  public static BigDecimal process(ArrayList<String> post) {
    for (String s : post) {
      if (isDouble(s)) {
        res.push(BigDecimal.valueOf(Double.parseDouble(s)));
      }
      else {
        BigDecimal a = res.pop();
        BigDecimal b = res.pop();
        res.push(do_op(s.charAt(0), a, b));
      }
    }
    return res.peek();
  }

  public static String reverse(String s) {
    return new StringBuffer(s).reverse().toString();
  }

  public static BigDecimal do_op(char op, BigDecimal a, BigDecimal b) {
    BigDecimal res;
    switch (op) {
    case '+':
      res = a.add(b);
      break;
    case '-':
      res = a.subtract(b);
      break;
    case '*':
      res = a.multiply(b);
      break;
    case '/':
      res = a.divide(b, new MathContext(12, RoundingMode.HALF_UP));
      break;
    case '^':
      res = a.pow(b.toBigInteger().intValue());
      break;
    default:
      res = BigDecimal.valueOf(0);
      break;
    }
    return res;
  }

  public static boolean isDouble (String s) {
   try {
     Double.parseDouble(s);
     return true;
   }
   catch (Exception e) {
     return false;
   }
  }
}