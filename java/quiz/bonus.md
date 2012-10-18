#Topic: Recursion

##Question Four
### Write the following iterative functions recursively.
<pre>public static int j(int x) {
  int y = 1;
  for (int i = x; i &gt; 0; i--)
    y *= i;
  return y;
}

public static int z(int x) {
  int q, l = q = 0;
  for (int i = 0; i &lt; x; i++) {
    int t = q;
    q = l;
    l = t + q;
  }
  return q;
}</pre>