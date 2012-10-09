import java.awt.*;

public abstract class Unit {
  protected static Color color;
  protected static int xcoord, ycoord;
  
  public void setX(int x) {
    xcoord = x;
  }
  public void setY(int y) {
    ycoord = y;
  }

  public int getX() {
    return xcoord;
  }
  public int getY() {
    return ycoord;
  }

  public abstract void paint(Graphics g);
}
