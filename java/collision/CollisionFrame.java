import java.awt.*;
import java.util.Random;
import javax.swing.*;
import java.awt.Graphics;

public class CollisionFrame extends JFrame {
  private CollisionPanel panel;
  Random rand = new Random();
  
  public CollisionFrame() {
    this.setTitle("'round and 'round the points will go; where they stop, nobody knows");
    this.setSize(Constants.FRAME_WIDTH,Constants.FRAME_HEIGHT);
  }
}

class CollisionPanel extends JPanel {
  private CollisionPanel() {
    setBackground(Constants.FRAME_BACKGROUND);
  }
  
  private CollisionPanel(Color c) {
    setBackground(c);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
  }
}
