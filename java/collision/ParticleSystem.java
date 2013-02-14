import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Random;

class ParticleSystem {
  private ArrayList<Point> points;
  private int index;
 
  public ParticleSystem(ArrayList<Point> points) {
    this.points = points;
    this.index = 0;
  }

  public ParticleSystem(int n) {
    Random rand = new Random();
    points = new ArrayList<Point>();

    for(int i = 0; i < n; i++) {
      Point p = new Point();
      p.setX(rand.nextInt(Constants.FRAME_WIDTH));
      p.setY(Constants.FRAME_OFFSET + rand.nextInt(Constants.FRAME_HEIGHT));
      Velocity v = new Velocity();
      v.setM(rand.nextInt(Constants.MAX_M));
      v.setT(rand.nextInt(Constants.MAX_T));

      points.add(p);
    }
    assignIDs();
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
}
