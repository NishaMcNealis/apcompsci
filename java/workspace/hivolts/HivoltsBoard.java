import javax.swing.JApplet;
import java.awt.*;
import java.awt.event.*;

public class HivoltsBoard extends JApplet implements KeyListener {
  Grid grid = new Grid();

  public void init() {
    addKeyListener( this );
  }

  public void paint(Graphics g) {
    //draw grid lines
    g.setColor(Color.BLACK);
    for(int i = 0; i < 13; i++) {
      g.fillRect(0, i * Globals.GRID_SIZE - 1, 384, 2);
      g.fillRect(i * Globals.GRID_SIZE - 1, 0, 2, 384);
    }
    //end grid lines
        
    grid.paint(g);
  }

  public void keyTyped(KeyEvent e) {
    char c = e.getKeyChar();
    grid.keyAction(c);
    grid.moveMhos();
    repaint();	
  }
}
