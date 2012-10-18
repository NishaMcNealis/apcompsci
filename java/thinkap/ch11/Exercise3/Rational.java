class Rational {
  public int num, den;
  public int sign;

  public Rational() {
    num = den = 0;
    sign = 1;
  }

  public Rational(int nnum, int nden) {
    sign = getSign(nnum*nden);
    num = abs(nnum);
    den = abs(nden);
  }

  public void negate() {
    sign = -sign;
  }

  public void invert() {
    int a = num;
    num = den;
    den = a;
  }

  public void printParts() {
    System.out.println(sign*num + "/" + den);
  }

  public double toDouble() {
    return sign*((double) num)/den;
  }

  public static int abs(int a) {
    if (a < 0) return -a;
    return a;
  }

  public static int getSign(int a) {
    if (a == 0) return 1;
    return abs(a)/a;
  }

  public static int gcd(int a, int b) {
    if (b > a) return gcd(b, a);
    if (b == 0) return a;
    return gcd(b, a%b);
  }

  public static int lcm(int a, int b) {
    return abs(a)*abs(b)/gcd(a, b);
  }
  
  public void reduce() {
    int g = gcd(num, den);
    num = num/g;
    den = den/g;
  }
}

/*

Generally, object methods will be more concise, especially if you already
have instances. The more natural way is context dependent; if you want Math.random(),
you're not going to want to create a Math instance. That's crazy talk.

*/