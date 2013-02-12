import java.awt.*;
import java.util.Random;
import javax.swing.*;
import java.awt.Graphics;

public class CollisionFrame {
  private CollisionPanel panel;
  Random rand = new Random();
  
  public CollisionFrame() {
    this.setTitle("'round and 'round the points will go; where they stop, nobody knows");
    this.setSize(600,400);
  }
}

class CollisionPanel extends JPanel {
  private CollisionPanel() {
    setBackground(Color.WHITE);
  }
  
  private CollisionPanel(Color c) {
    setBackground(c);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
  }
}