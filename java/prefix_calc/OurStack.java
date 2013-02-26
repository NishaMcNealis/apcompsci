import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.Arrays;

class OurStack {
  private ArrayList<BigDecimal> stack;

  public OurStack() {
    stack = new ArrayList<BigDecimal>();
  }

  public OurStack(ArrayList<BigDecimal> stack) {
    this.stack = stack;
  }

  public void push(BigDecimal a) {
    stack.add(a);
  }

  public BigDecimal peek() {
    return stack.get(stack.size()-1);
  }

  public BigDecimal peek(int i) {
    return stack.get(i);
  }

  public BigDecimal pop() {
    BigDecimal a = peek();
    stack.remove(stack.size()-1);
    return a;
  }

  public BigDecimal pop(int i) {
    BigDecimal a = peek(i);
    stack.remove(i);
    return a;
  }

  public void print() {
    System.out.print("[");
    for (BigDecimal bd : stack) {
      System.out.print(bd+", ");
    }
    System.out.println("]");
  }
}
