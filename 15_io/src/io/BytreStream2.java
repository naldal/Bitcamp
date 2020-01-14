package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SuppressWarnings("all")
public class BytreStream2 {

	public static void main(String[] args) throws Exception {
	
		File file = new File("data.txt");
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		
		int size = (int) file.length();
		
		byte[] ar = new byte[size];
		bis.read(ar, 0, size);
		
		System.out.println(new String(ar));
		
		bis.close();
				
	}
}
