package io;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {
            
	public static void main(String[] args) throws IOException {
		//DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt"));
		
		//FileOutputStream fos = new FileOutputStream("result.txt");
		
		File file = new File("result.txt");
		FileOutputStream fos = new FileOutputStream(file);
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("홍길동");
		dos.writeInt(25);
		dos.writeFloat(185.3f);
		dos.close();
		
		FileInputStream fis = new FileInputStream(file);
		DataInputStream dis = new DataInputStream(fis);
		System.out.println("이름 = "+dis.readUTF());
		System.out.println("나이 = "+dis.readInt());
		System.out.println("키 = "+dis.readFloat());
		
		dis.close();
	}
}