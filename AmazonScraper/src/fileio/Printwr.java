package fileio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Printwr {
	
	public static void main(String[] args) {
		
		File file = new File("D:/hello.txt");
		
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file));
			
			pw.println();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
