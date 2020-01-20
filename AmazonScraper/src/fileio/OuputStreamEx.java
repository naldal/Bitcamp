package fileio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OuputStreamEx {
	public static void main(String[] args) {
		try {
			OutputStream output = new FileOutputStream("D:/output.txt");
			String str = "오늘 날씨는 아주 좋습니다";
			byte[] by=str.getBytes();
			output.write(by);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
