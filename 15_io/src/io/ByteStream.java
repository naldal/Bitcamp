package io;

import java.io.BufferedInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

public class ByteStream {

	public static void main(String[] args) throws IOException {
		File file = new File("data.txt");

		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		int data;
		while((data = bis.read())!=-1) {
			System.out.print((char)data);
		}
		bis.close();
	}
}

/*
엔터 (\r\n)
\r : 맨앞으로 (ASCII 13)
\n : 다음줄로 (ASCII 10)
총 2byte
*/