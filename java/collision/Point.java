import java.awt.Graphics;

public class Point {
  private double x, y;
  private int id;

  public Point(int id) {
    setX(0);
    setY(0);
    this.id = id;
  }

  public Point(double x, double y) {
    setX(x);
    setY(y);
  }

  public void setID(int a) {
    this.id = a;
  }

  public int getID() {
    return this.id;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public double distanceTo(Point a) {
    return Math.sqrt(Math.pow(a.getX()-x,2) + Math.pow(a.getY()-y,2));
  }

  public void draw(Graphics g) {
    int d = 2*Constants.POINT_RADIUS;
    g.setColor(Constants.POINT_COLOR);
    g.drawOval((int) x, (int) y, d, d);
  }

  public String toString() {
    return "(" + x + "," + y + ")";
  }
}
