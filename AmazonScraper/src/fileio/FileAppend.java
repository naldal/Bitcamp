package fileio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileAppend {

	public static void main(String[] args) {
		
		File file = new File("D:/hello.txt");
		
		try {
			FileWriter fw = new FileWriter(file, true);
			
			fw.write("hello world11");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
