import java.awt.*;
import javax.swing.*;

public class CollisionFrame extends JFrame {
  private ParticleSystem system;

  public CollisionFrame() {
    init();
  }

  public void init() {
    setBackground(Constants.FRAME_BACKGROUND);
    setTitle("'round and 'round the points will go; where they stop, nobody knows");
    setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT+Constants.FRAME_OFFSET);
    
    system = new ParticleSystem(Constants.POINT_NUMBER);
  }
  
  public void paint(Graphics g) {
    system.prerender(g);
    system.computeFrame();
    system.render(g);

    try {
      Thread.currentThread().sleep(Constants.FRAME_REFRESH_RATE);
    }
    catch (InterruptedException ie) {
      System.err.println("Haha, your threading sucks");
    }

    if (system.haveFrame()) {
      repaint();
    }
  }
}
