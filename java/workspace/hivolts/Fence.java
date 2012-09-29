import java.awt.*;

public class Fence extends Unit{

    public Fence(int x, int y) {
	    xcoord = x;
	    ycoord = y;
        color = Color.ORANGE;
    }
    
    public void setX(int x) {
        xcoord = x;
    }
    public void setY(int y) {
        ycoord = y;
    }

    public void paint(Graphics g) {
	    g.setColor(color);
        g.fillRect(xcoord * Globals.GRID_SIZE + (Globals.GRID_SIZE - Globals.UNIT_SIZE) / 2, ycoord * Globals.GRID_SIZE + (Globals.GRID_SIZE - Globals.UNIT_SIZE) / 2, Globals.UNIT_SIZE, Globals.UNIT_SIZE);
    }
}
