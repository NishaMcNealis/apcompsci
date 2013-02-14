import java.awt.*;
import javax.swing.*;

public class CollisionFrame extends JFrame {
  private ParticleSystem system;

  public CollisionFrame() {
    init();
  }

  public void init() {
    setTitle("'round and 'round the points will go; where they stop, nobody knows");
    setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT+Constants.FRAME_OFFSET);
    
    system = new ParticleSystem(Constants.POINT_NUMBER);
  }
  
  public void paint(Graphics g) {
    system.render(g);
  }
}
