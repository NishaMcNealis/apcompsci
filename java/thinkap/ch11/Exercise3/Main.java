class Main {
  public static void printRational(Rational r) {
    System.out.println(r.toDouble());
  }

  public static Rational addRational(Rational a, Rational b) {
    int common = Rational.lcm(a.den, b.den);
    int anum = a.num*common/a.den;
    int bnum = b.num*common/b.den;
    int numsum = a.sign*anum+b.sign*bnum;
    int sign = a.sign*b.sign;
    Rational r = new Rational(sign*numsum, common);
    r.reduce();
    return r;
  }

  public static void main(String[] args) {
    Rational r = new Rational(6,8);

    r.printParts();

    r.negate();
    printRational(r);

    r.invert();
    printRational(r);

    r.reduce();
    r.printParts();

    printRational(addRational(new Rational(-3,4), new Rational(3,4)));
  }
}