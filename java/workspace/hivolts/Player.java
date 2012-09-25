import java.awt.*;

public class Player {
    final int GRID_SIZE = 32;
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
        g.fillOval(xcoord * GRID_SIZE, ycoord * GRID_SIZE, 24, 24);
    } 
}

