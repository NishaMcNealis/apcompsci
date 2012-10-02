import java.awt.*;
import java.util.Random;

public class Grid {
    Square[][] squares = new Square[Globals.SIDE_LENGTH][Globals.SIDE_LENGTH];

    //with structure [x,y]
    int[][] border = new int[Globals.BORDER_COUNT][2];
    int[][] inner  = new int[Globals.INNER_SIZE][2];
    int[][] all    = new int[Globals.ALL_SIZE][2];
    int[][] mhoList = new int[Globals.MHO_COUNT][2];

    public Grid() {
	int bcount = 0;
	int icount = 0;
	for (int y = 0; y < Globals.SIDE_LENGTH; y++) {
	    for (int x = 0; x < Globals.SIDE_LENGTH; x++) {
		all[y] = new int[]{x, y};
		if (x == Globals.SIDE_LENGTH-1 || x == 0 || y == Globals.SIDE_LENGTH-1 || y == 0) {
		    border[bcount] = new int[]{x,y};
		    bcount++;
		}
		else {
		    inner[icount] = new int[]{x,y};
		    icount++;
		}
	    }
	}

	//iterates over all, creating squares
	for (int p : all) {
	    squares[all[p][0]][all[p][1]] = new Square(all[p][0],all[p][1]);
	}

	//iterates over border squares, placing fences
	for (int p : border) {
	    squares[border[p[0]]][border[p[1]]].setValue(Globals.FENCE_VALUE);
	}

	//randomly generates fences, mhos, and you
	generateBlocks(Globals.FENCE_VALUE, Globals.FENCE_COUNT);
	generateBlocks(Globals.MHO_VALUE, Globals.MHO_COUNT);
	generateBlocks(Globals.YOU_VALUE, Globals.YOU_COUNT);
    }

    public void paint(Graphics g) {   
	for (int i : all) {
	    squares[all[i[0]]] [all[i[1]]].paint(g);
	}
    }
    
    public void generateBlocks(int blockValue, int count) {
	for(int i = 0; i < count; i++) {
	    Random random = new Random();
	    while(true) {
		int x = random.nextInt(Globals.INNER_LENGTH) + 1;
		int y = random.nextInt(Globals.INNER_LENGTH) + 1;
		if(blockValue == Globals.MHO_VALUE) {
		    mhoList[i][0] = x;
		    mhoList[i][1] = y;
		}
		if(squares[x][y].getValue() == 0) {
		    squares[x][y].setValue(blockValue);
		    break;
		}
	    }
	}
    }

}