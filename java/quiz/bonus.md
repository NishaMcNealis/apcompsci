#Topic: Recursion

##Question Four
### Write the following iterative function recursively.
<pre>public static int f(int x) {
  int y = 1;
  for (int i = x; i > 0; i--) {
    y *= i;
  }
  return y;
}</pre>