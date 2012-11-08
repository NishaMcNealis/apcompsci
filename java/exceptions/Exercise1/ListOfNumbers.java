//begin code from oracle
import java.io.*;
import java.util.Vector;

public class ListOfNumbers {
    private Vector<Integer> victor;
    private static final int SIZE = 10;

    public ListOfNumbers () {
        victor = new Vector<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            victor.addElement(new Integer(i));
    }
    public void writeList() {
        PrintWriter out = null;

        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("OutFile.txt"));
        
            for (int i = 0; i < SIZE; i++)
                out.println("Value at: " + i + " = " + victor.elementAt(i));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Caught ArrayIndexOutOfBoundsException: " +
			       e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
//end code from oracle
    public void readList(File file) {
	try {
	    FileInputStream fStream = new FileInputStream(file);
	    DataInputStream dStream = new DataInputStream(fStream);
	    BufferedReader reader   = new BufferedReader(new InputStreamReader(dStream));
	    String line;
	    while((line = reader.readLine()) != null) {
		int i = Integer.parseInt(line);
		System.out.println(i);
		victor.addElement(i);
	    }
	}
	catch(FileNotFoundException e) {
	    System.err.println("File not found.");
	}
	catch(IOException e) {
	    System.err.println(e.getMessage());
	}
    }
}
