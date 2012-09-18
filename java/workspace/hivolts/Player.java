import java.awt.*;

public class Player {
    final int GRID_SIZE = 32;
    protected Color color;
    protected int xcoord, ycoord;
    public Player() {
        color = Color.BLACK;
        xcoord = ycoord = 0;
    }
    
    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(xcoord * GRID_SIZE, ycoord * GRID_SIZE, 24, 24);
    } 
}

