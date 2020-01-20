package fileio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class outText1 {

	public static void main(String[] args) {
		
		File file = new File("D:/hello.txt");
		
		try {
			FileWriter fw = new FileWriter(file);
			
			fw.write("hello world");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
