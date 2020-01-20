package fileio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferdWriter11 {

	public static void main(String[] args) {
		
		File file = new File("D:/hello.txt");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			
			bw.write("hello world! \n");
			bw.write("this is bufferd writer!");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
