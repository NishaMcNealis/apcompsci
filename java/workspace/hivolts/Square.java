import java.awt.*;
public class Square {
    private int xcoord, ycoord, value;

    public Square(int x, int y) {
        xcoord = x;
        ycoord = y;
        value = 0;
    }
    
    public void setValue(int v) {
        value = v;
    }
    public int getValue() {
        return value;
    }
    public int getX() {
        return xcoord;
    }
    public int getY() {
        return ycoord;
    }

    public void paint(Graphics g) {
        if(value == 0) {
        }
        else if(value == 1) {
            You you = new You(xcoord, ycoord);
            you.paint(g);
        }
        else if(value == 2) {
            Mho mho = new Mho(xcoord, ycoord);
            mho.paint(g);
        }
        else if(value == 3) {
            Fence fence = new Fence(xcoord, ycoord);
            fence.paint(g);
        }
    }
}
