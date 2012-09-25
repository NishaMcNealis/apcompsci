import java.awt.*;

public class Player {
    protected Color color;
    protected int xcoord, ycoord;

    public Player() {
        color = Color.BLACK;
        xcoord = ycoord = 0;
    }
    public Player(int x, int y, Color c) {
        xcoord = x;
        ycoord = y;
        color = c;
    }
    
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(xcoord * Dimensions.GRID_SIZE + (Dimensions.GRID_SIZE - Dimensions.UNIT_SIZE) / 2, ycoord * Dimensions.GRID_SIZE + (Dimensions.GRID_SIZE - Dimensions.UNIT_SIZE) / 2, Dimensions.UNIT_SIZE, Dimensions.UNIT_SIZE);
    } 
}

