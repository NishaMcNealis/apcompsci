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
        g.fillRect(xcoord * Dimensions.GRID_SIZE + (Dimensions.GRID_SIZE - Dimensions.UNIT_SIZE) / 2, ycoord * Dimensions.GRID_SIZE + (Dimensions.GRID_SIZE - Dimensions.UNIT_SIZE) / 2, Dimensions.UNIT_SIZE, Dimensions.UNIT_SIZE);
    }
}
