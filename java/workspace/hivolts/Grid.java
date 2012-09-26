import java.awt.*;
import java.util.Random;

public class Grid {
        //a value of 1 signifies the player, 2 signifies a mho, and 3 signifies a fence
    Square[] borderSquares;
    Square[] innerSquares = new Square[111];


    public Grid() {
        //creates a border of fences
        borderSquares = new Square[]{new Square(0, 0), new Square(0, 1), new Square(0, 2), new Square(0, 3), new Square(0, 4), new Square(0, 5), new Square(0, 6), new Square(0, 7), new Square(0, 8), new Square(0, 9), new Square(0, 10), new Square(0, 11), new Square(11, 0), new Square(11, 1), new Square(11, 2), new Square(11, 3), new Square(11, 4), new Square(11, 5), new Square(11, 6), new Square(11, 7), new Square(11, 8), new Square(11, 9), new Square(11, 10), new Square(11, 11), new Square(1, 0), new Square(2, 0), new Square(3, 0), new Square(4, 0), new Square(5, 0), new Square(6, 0), new Square(7, 0), new Square(8, 0), new Square(9, 0), new Square(10, 0), new Square(1, 11), new Square(2, 11), new Square(3, 11), new Square(4, 11), new Square(5, 11), new Square(6, 11), new Square(7, 11), new Square(8, 11), new Square(9, 11), new Square(10, 11)}; 
        for(int i = 0; i < borderSquares.length; i++) {
            borderSquares[i].setValue(3);
        }
            
        //creates squares inside the border    
        for(int i = 11; i < innerSquares.length; i++) {
            int x = i % 10;
            if (i % 10 == 0) {
                x = 10;
            }
            int y = (int) (String.valueOf(Math.abs((long)i)).charAt(0) - '0');
            innerSquares[i] = new Square(x, y);
        }
        //creates 20 randomly located fences
        for(int i = 0; i < 20; i++) {
            Random random = new Random();
            boolean valid = false;
            while(valid == false) {
                int x = random.nextInt(10) + 1;
                int y = random.nextInt(10) + 1;
                if(innerSquares[10 * y + x].getValue() == 0) {
                    innerSquares[10 * y + x].setValue(3);
                    valid = true;
                }
            }
        }
        //creates 12 randomly located mhos
        for(int i = 0; i < 12; i++) {
            Random random = new Random();
            boolean valid = false;
            while(valid == false) {
                int x = random.nextInt(10) + 1;
                int y = random.nextInt(10) + 1;
                if(innerSquares[10 * y + x].getValue() == 0) {
                    innerSquares[10 * y + x].setValue(2);
                    valid = true;
                }
            }
        }
        //creates 1 randomly located you
        for(int i = 0; i < 1; i++) {
            Random random = new Random();
            boolean valid = false;
            while(valid == false) {
                int x = random.nextInt(10) + 1;
                int y = random.nextInt(10) + 1;
                if(innerSquares[10 * y + x].getValue() == 0) {
                    innerSquares[10 * y + x].setValue(1);
                    valid = true;
                }
            }
        }

    }


    public void paint(Graphics g) {   
		for(int i = 0; i < borderSquares.length; i++) {
            borderSquares[i].paint(g);
        }

        for(int i = 11; i < innerSquares.length; i++) {
            innerSquares[i].paint(g);
        }
    }
}
