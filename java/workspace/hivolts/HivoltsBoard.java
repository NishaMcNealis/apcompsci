import javax.swing.JApplet;
import java.awt.*;

public class HivoltsBoard extends JApplet {
    
    public void init() {
       
    }
    public void paint(Graphics g) {
        //draw grid
        g.setColor(Color.BLACK);
        for(int i = 0; i < 13; i++) {
            g.fillRect(0, i * Dimensions.GRID_SIZE - 1, 384, 2);
            g.fillRect(i * Dimensions.GRID_SIZE - 1, 0, 2, 384);
        }
        //end grid
        Mho mho = new Mho(2, 3);
        mho.paint(g);
        Fence fence = new Fence(3, 5);
        fence.paint(g);
       /* for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                Player player = new Player(i, j, Color.BLUE);
                player.paint(g);
            }
        } */
    }

}
