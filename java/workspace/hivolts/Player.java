import java.awt.*;

public class Player extends Unit {

    public Player(int x, int y, Color c) {
        xcoord = x;
        ycoord = y;
        color = c;
    }

    public void move(int x, int y) {
	setX(x);
	setY(y);
    }
    
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(xcoord * Globals.GRID_SIZE + (Globals.GRID_SIZE - Globals.UNIT_SIZE) / 2, ycoord * Globals.GRID_SIZE + (Globals.GRID_SIZE - Globals.UNIT_SIZE) / 2, Globals.UNIT_SIZE, Globals.UNIT_SIZE);
    } 
}

