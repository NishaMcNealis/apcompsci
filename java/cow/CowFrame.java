import java.awt.*;
import javax.swing.JFrame;

public class CowFrame extends JFrame {
  public CowFrame () {
    init();
  }
  
  public void init() {
    setSize(700,600);
    setBackground(Color.WHITE);
    repaint();
  }
  
  public void paint(Graphics g) {
    g.drawRect(50, 100, 400, 200);
    g.setColor(Color.BLACK);
    g.drawOval(350, 50, 200, 100);
    g.drawRect(80, 272, 100, 172);
  }
}

