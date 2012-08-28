import java.awt.*;
import javax.swing.JFrame;

public class CowFrame extends JFrame {
    private final Color BISQUE = new Color(0xcdb79e);

    public CowFrame () {
	init();
    }
  
    public void init() {
	setSize(700,600);
	setBackground(Color.WHITE);
	repaint();
    }
  
    public void paint(Graphics g) {
	g.setColor(BISQUE);
	g.fillRect(50, 100, 400, 200);
	g.setColor(Color.BLACK);
	g.drawOval(350, 50, 200, 100);
	g.setColor(BISQUE);
	g.fillRect(80, 272, 60, 145);
	g.fillRect(170, 272, 60, 145);
	g.fillRect(260, 272, 60, 145);
	g.fillRect(350, 272, 60, 145);
	g.setColor(Color.BLACK);
	g.fillOval(72, 100, 172, 20);
	g.fillOval(92, 150, 172, 70);
	g.fillOval(300, 200, 120, 50);
    }
}

