package fileio;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputBufferedStreamEx {
	public static void main(String[] args) throws IOException {
		BufferedOutputStream bs = null;
		
		try {
			bs= new BufferedOutputStream(new FileOutputStream("D:/output1.txt"));
			String str = "오늘 날씨가 아주 좋습니다";
			bs.write(str.getBytes());
			bs.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
