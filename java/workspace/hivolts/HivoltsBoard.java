import javax.swing.JApplet;
import java.awt.*;

public class HivoltsBoard extends JApplet {
    //    Mho mho = new Mho(Color.red);
   // Fence fence = new Fence(0, 0);
        Player player;
    public void init() {
       
    }
    public void paint(Graphics g) {
        //draw grid
        g.setColor(Color.BLACK);
        for(int i = 0; i < 13; i++) {
            g.fillRect(0, i * Dimensions.GRID_SIZE - 1, 384, 2);
            g.fillRect(i * 32 - 1, 0, 2, 384);
        }
        //end grid

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                player = new Player(i, j, Color.BLUE);
                player.paint(g);
            }
        }
	//fence.paint(g);
    }

}
