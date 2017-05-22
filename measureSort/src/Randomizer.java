
import java.io.*;
import java.util.*;

public class Randomizer {
	
	public static void main(String[] args) {
		// The target file
		int numberSize = 10;
		// create random number max range
		int MaxNumber = 99;
       File out = new File("number"+ numberSize +".txt");
       FileWriter fw = null;
       // Try block: Most stream operations may throw IO exception
       try {
          // Create file writer object
    	   fw = new FileWriter(out);
          // Wrap the writer with buffered streams
          BufferedWriter writer = new BufferedWriter(fw);
          int line;
          Random random = new Random();
          while (numberSize > 0) {
              // Randomize an integer and write it to the output file
              line = random.nextInt(MaxNumber);
              writer.write(line + "\n");
              numberSize--;
              }
           // Close the stream
           writer.close();
           } catch (IOException e) {
	           e.printStackTrace();
	           System.exit(0);
           }
       }
}
