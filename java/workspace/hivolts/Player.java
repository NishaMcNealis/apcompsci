\import java.awt.*;

public class Player extends Unit {

    public Player(int x, int y, Color c) {
        xcoord = x;
        ycoord = y;
        color = c;
    }

    public void move(int x, int y) {
	setX(x);
	setY(y);
    }

    public void translate(int x, int y) {
	move(xcoord + x, ycoord + y);
    }

    public void moveUp()        { translate(0, -1);  }
    public void moveDown()      { translate(0, 1);   }
    public void moveLeft()      { translate(-1, 0);  }
    public void moveRight()     { translate(1, 0);   }
    public void moveUpLeft()    { translate(-1, -1); }
    public void moveUpRight()   { translate(1, -1);  }
    public void moveDownLeft()  { translate(-1, 1);  }
    public void moveDownRight() { translate(1, 1);   }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(xcoord * Globals.GRID_SIZE + (Globals.GRID_SIZE - Globals.UNIT_SIZE) / 2, ycoord * Globals.GRID_SIZE + (Globals.GRID_SIZE - Globals.UNIT_SIZE) / 2, Globals.UNIT_SIZE, Globals.UNIT_SIZE);
    } 
}

