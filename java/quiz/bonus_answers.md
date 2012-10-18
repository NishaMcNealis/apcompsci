#Topic: Recursion

##Question Four
### Write the following iterative functions recursively.
<pre>public static int j(int x) {
  if (x &lt; 2) {
    return 1;
  }
  else {
    return x*j(x-1);
  }
}

public static int z(int x) {
  if (x &lt; 2) {
    return 1;
  }
  else {
    return z(x-1)+x(x-2);
  }
}</pre>