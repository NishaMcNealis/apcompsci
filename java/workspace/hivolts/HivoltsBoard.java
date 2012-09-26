import javax.swing.JApplet;
import java.awt.*;

public class HivoltsBoard extends JApplet {
    
    public void init() {
       
    }
    public void paint(Graphics g) {
        //draw grid lines
        g.setColor(Color.BLACK);
        for(int i = 0; i < 13; i++) {
            g.fillRect(0, i * Dimensions.GRID_SIZE - 1, 384, 2);
            g.fillRect(i * Dimensions.GRID_SIZE - 1, 0, 2, 384);
        }
        //end grid lines
        
        Grid grid = new Grid();
        grid.paint(g);
    }

}
