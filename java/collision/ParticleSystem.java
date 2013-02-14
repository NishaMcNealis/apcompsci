import java.util.ArrayList;
import java.awt.Graphics;

class ParticleSystem {
  private ArrayList<Point> points;
  private int index;
 
  public ParticleSystem(ArrayList<Point> points) {
    this.points = points;
    this.index = 0;
  }

  public void assignID(Point p) {
    p.setID(this.index);
    this.index++;
  }

  public void assignIDs(ArrayList<Point> points) {
    for (Point p : points) assignID(p);
  }

  public ParticleSystem() {
    this.points = new ArrayList<Point>();
  }
  
  public void render(Graphics g) {
    for (Point k : points) k.draw(g);
  }
}
