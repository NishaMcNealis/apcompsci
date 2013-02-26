import java.awt.Graphics;
import java.util.Random;

public class Point {
  private double x, y;
  private double m;
  private Velocity v;

  private int id;

  public Point() {
    setX(0);
    setY(0);
    setM(0);
  }

  public Point(double x, double y, double m) {
    setX(x);
    setY(y);
    setM(m);
  }

  public int getID() {
    return id;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public Velocity getV() {
    return v;
  }

  public double getM() {
    return m;
  }

  public void setID(int id) {
    this.id = id;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public void setV(Velocity v) {
    this.v = v;
  }

  public void setM(double m) {
    this.m = m;
  }
  
  public double distanceTo(Point k) {
    return Math.sqrt(Math.pow(k.getX()-x,2) + Math.pow(k.getY()-y,2));
  }

  public boolean closeTo(Point k) {
    double r = Constants.POINT_MASS_RADIUS_RATIO*m;
    return distanceTo(k) <= r*2;
  }

  public boolean sameAs(Point k) {
    return getID() == k.getID();
  }

  public Point[] interact(Point k) {
    Velocity u1 = new Velocity(v);
    Velocity u2 = new Velocity(k.v);

    Velocity v1 = u1.scale(m-k.m).add(u2.scale(2*k.m)).scale(1/(m+k.m));
    Velocity v2 = u2.scale(k.m-m).add(u1.scale(2*m)).scale(1/(m+k.m));

    setV(v1);
    k.setV(v2);

    Point[] ps = {this, k};
    return ps;
  }
  
  // t == milliseconds since last refresh
  public void move(int t) {
    x += v.getX() * t / 1000d;
    y += v.getY() * t / 1000d;
  }

  public void draw(Graphics g) {
    double d = Constants.POINT_MASS_RADIUS_RATIO*m;
    g.fillOval((int) x, (int) y, (int) d, (int) d);
  }

  public void erase(Graphics g) {
    double d = Constants.POINT_MASS_RADIUS_RATIO*m;
    g.fillOval((int) x, (int) y, (int) d, (int) d);
  }

  public String toString() {
    return "(" + x + "," + y + ")";
  }
}
