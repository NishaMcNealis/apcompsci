public class myPoint {
  private double myX, myY;

  public myPoint() {
    myX = 0;
    myY = 0;
  }

  public myPoint(double x, double y) {
    myX = x;
    myY = y;
  }

  public double getX() {
    return myX;
  }

  public double getY() {
    return myY;
  }

  public void setX(double x) {
    myX = x;
  }

  public void setY(double y) {
    myY = y;
  }

  public double distanceTo(myPoint a) {
    return Math.sqrt(Math.pow(a.getX()-myX,2) + Math.pow(a.getY()-myY,2));
  }

  public String toString() {
    return "(" + myX + "," + myY + ")";
  }
}