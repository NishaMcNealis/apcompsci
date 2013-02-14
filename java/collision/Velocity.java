public class Velocity {
  private double x;
  private double y;
  private double m;
  private double t;

  public Velocity() {
    x = y = 0;
    recalcLinear();
  }

  public Velocity(double a, double b, boolean isLin) {
    if (isLin) {
      x = a;
      y = b;
      recalcLinear();
    }
    else {
      m = a;
      t = b;
      recalcTrig();
    }
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public double getM() {
    return m;
  }

  public double getT() {
    return t;
  }

  private void recalcLinear() {
    m = Math.sqrt(x*x+y*y);
    t = Math.atan(y/x);
  }


  private void recalcTrig() {
    x = m*Math.cos(t);
    y = m*Math.sin(t);
  }

  public void setX(double x) {
    this.x = x;
    recalcLinear();
  }

  public void setY(double y) {
    this.y = y;
    recalcLinear();
  }

  public void setM(double m) {
    this.m = m;
    recalcTrig();
  }

  public void setT(double t) {
    this.t = t;
    recalcTrig();
  }
}