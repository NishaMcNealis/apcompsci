import javax.swing.JApplet;
import java.awt.*;

public class HivoltsBoard extends JApplet {
    You you = new You(Color.blue);
    Mho mho = new Mho(Color.red);
    
    public void paint(Graphics g) {
        you.paint(g);
    }
}
