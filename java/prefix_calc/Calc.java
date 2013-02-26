import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

class Calc {
  public static String prefix_string;
  public static ArrayList<String> prefix;
  public static OurStack res = new OurStack();

  public static void main(String[] args) {
    prefix_string = args[0];
    prefix = new ArrayList<String>(Arrays.asList(prefix_string.split(" ")));
    Collections.reverse(prefix);

    System.out.println(process(prefix));
  }

  public static BigDecimal process(ArrayList<String> pre) {
    for (String s : pre) {
      // res.print();

      if (isNumber(s)) {
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

  public static boolean isNumber(String s) {
   try {
     Double.parseDouble(s);
     return true;
   }
   catch (Exception e) {
     return false;
   }
  }
}
