import java.awt.Graphics;

public class Point {
  private double x, y;
  private Velocity v;

  private int id;

  public Point() {
    setX(0);
    setY(0);
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
  
  public double distanceTo(Point p) {
    return Math.sqrt(Math.pow(p.getX()-x,2) + Math.pow(p.getY()-y,2));
  }

  public boolean closeTo(Point p) {
    return distanceTo(p) <= Constants.POINT_RADIUS*2;
  }

  public boolean sameAs(Point p) {
    return getID() == p.getID();
  }

  public void interact(Point k) {
    
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
