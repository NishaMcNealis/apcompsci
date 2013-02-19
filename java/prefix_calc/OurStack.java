import java.util.ArrayList;

class OurStack {
  private ArrayList<Integer> stack;

  public OurStack() {
    stack = new ArrayList<Integer>();
  }

  public OurStack(ArrayList<Integer> stack) {
    this.stack = stack;
  }

  public void push(int a) {
    stack.add(a);
  }

  public int peek() {
    return stack.get(stack.size()-1);
  }

  public int peek(int i) {
    return stack.get(i);
  }

  public int pop() {
    int a = peek();
    stack.remove(stack.size()-1);
    return a;
  }

  public int pop(int i) {
    int a = peek(i);
    stack.remove(i);
    return a;
  }
}