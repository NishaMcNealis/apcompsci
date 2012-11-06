import java.io.*;
public class Exercise2 {
    public static void cat(File file) {
	RandomAccessFile input = null;
	String line = null;
    
	try {
	    input = new RandomAccessFile(file, "r");
	    while ((line = input.readLine()) != null) {
		System.out.println(line);
	    }
	    return;
       	} catch (FileNotFoundException e) {
	    System.err.println(file + " not found");
	} catch(IOException e) {
	    System.err.println(e.toString());
	} finally {
	    if (input != null) {
		try{input.close();}
		catch(IOException e) {
		    System.err.println(e.toString());
		}
	    }
	}
    }
}