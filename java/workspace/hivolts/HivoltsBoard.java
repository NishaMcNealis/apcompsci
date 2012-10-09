import javax.swing.JApplet;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class HivoltsBoard extends Applet implements KeyListener {
    Grid grid = new Grid();

    public void init() {
	addKeyListener(this);
    }

    public void paint(Graphics g) {
	//draw grid lines
	g.setColor(Color.BLACK);
	for(int i = 0; i < Globals.SIDE_LENGTH; i++) {
	    g.fillRect(0, i * Globals.GRID_SIZE - 1, Globals.SIDE_LENGTH_PX, 2);
	    g.fillRect(i * Globals.GRID_SIZE - 1, 0, 2, Globals.SIDE_LENGTH_PX);
	}
	//end grid lines
        
	grid.paint(g);
    }

    public void keyTyped(KeyEvent e) {
	char c = e.getKeyChar();
	if (grid.charInArray(c, grid.keyList)) {
	    grid.keyAction(c);
	    grid.moveMhos();
	    repaint();
	}
    }
    
    public void keyReleased(KeyEvent e){}
    public void keyPressed(KeyEvent e){}
}
