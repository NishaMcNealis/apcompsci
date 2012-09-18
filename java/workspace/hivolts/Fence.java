import java.awt.*;

public class Fence {
    public static int x, y;

    public Fence(int newx, int newy) {
	x = newx;
	y = newy;
    }

    public static void paint(Graphics g) {
	g.setColor(Color.ORANGE);
	g.fillRect(x * 32, y * 32, 24, 24);
    }
}
