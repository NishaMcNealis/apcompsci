import java.awt.*;
import java.util.Random;
import java.util.Arrays;

public class Grid {
    Square[][] squares = new Square[Globals.SIDE_LENGTH][Globals.SIDE_LENGTH];

    //with structure [x,y]
    int[][] border  = new int[Globals.BORDER_COUNT] [2];
    int[][] inner   = new int[Globals.INNER_SIZE]   [2];
    int[][] all     = new int[Globals.ALL_SIZE]     [2];

    int[][] mhoList = new int[Globals.MHO_COUNT]    [2];

    int[] you       = new int[2];

    public Grid() {
	int bcount = 0;
	int icount = 0;
	int acount = 0;
	for (int y = 0; y < Globals.SIDE_LENGTH; y++) {
	    for (int x = 0; x < Globals.SIDE_LENGTH; x++) {
		all[acount] = new int[]{x, y};
		acount++;
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
	for (int i = 0; i < all.length; i++) {
	    squares[all[i][0]][all[i][1]] = new Square(all[i][0], all[i][1]);
	}

	//iterates over border squares, placing fences
	for (int i = 0; i < border.length; i++) {
	    squares[border[i][0]][border[i][1]].setValue(Globals.FENCE_VALUE);
	}
	
	//randomly generates fences, mhos, and you
	generateBlocks(Globals.FENCE_VALUE, Globals.FENCE_COUNT);
	generateBlocks(Globals.MHO_VALUE, Globals.MHO_COUNT);
	generateBlocks(Globals.YOU_VALUE, Globals.YOU_COUNT);
    }

    public void paint(Graphics g) {   
	for (int i = 0; i < all.length; i++) {
	    squares[all[i][0]][all[i][1]].paint(g);
	}
    }
    
    public void generateBlocks(int blockValue, int count) {
	for(int i = 0; i < count; i++) {
	    Random random = new Random();
	    while(true) {
		int x = random.nextInt(Globals.INNER_LENGTH) + 1;
		int y = random.nextInt(Globals.INNER_LENGTH) + 1;
		if(blockValue == Globals.MHO_VALUE) {
		    mhoList[i] = new int[]{x, y};
		}
		if(blockValue == Globals.YOU_VALUE) {
		    you = new int[]{x, y};
		}
		if(squares[x][y].getValue() == Globals.BLANK_VALUE) {
		    squares[x][y].setValue(blockValue);
		    break;
		}
	    }
	}
    }

    public int abs(int n) {
	if(n > 0) return n;
	else return -n;
    }

    public int getSign(int n) {
	return n/abs(n);
    }

    public void moveMho(int x, int y) {
	squares[x][y].setValue(Globals.BLANK_VALUE);
	if(x == you[0]) {
	    
	}
    }
    
    public void moveMhos() {
	for (int i = 0; i < mhoList.length; i++) {
	    int x = mhoList[i][0];
	    int y = mhoList[i][1];
	    squares[x][y].s
	}
    }
}