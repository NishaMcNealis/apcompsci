import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Random;

class ParticleSystem {
  private ArrayList<Point> points;
  private int index;
 
  public ParticleSystem(ArrayList<Point> points) {
    this.index = 0;
    this.points = points;
    assignIDs();
  }

  public ParticleSystem(int n) {
    Random rand = new Random();
    points = new ArrayList<Point>();

    for(int i = 0; i < n; i++) {
      Velocity v = new Velocity();
      v.setM(rand.nextInt(Constants.POINT_MAX_M));
      v.setT(rand.nextInt(Constants.POINT_MAX_T));

      Point p = new Point();
      p.setX(rand.nextInt(Constants.FRAME_WIDTH));
      p.setY(Constants.FRAME_OFFSET + rand.nextInt(Constants.FRAME_HEIGHT));
      p.setV(v);
      points.add(p);
    }
    assignIDs();
  }

  public void computeFrame() {
    for (Point p : points) {
      for (Point k : points) {
        if (p.sameAs(k)) continue;
        else if (p.closeTo(k)) {
          // oooooooooomg render
        }
      }
    }
  }

  public void assignID(Point p) {
    p.setID(this.index);
    this.index++;
  }

  public void assignIDs() {
    for (Point p : points) assignID(p);
  }

  public void render(Graphics g) {
    for (Point p : points) p.draw(g);
  }

  public boolean haveFrame() {
    return true;
  }
}
