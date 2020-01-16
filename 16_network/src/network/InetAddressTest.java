package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		//InetAddress naver = new InetAddress(); 기본생성자 자체를 사용못하게 막아놓음
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.out.println("NAVER IP = "+naver.getHostAddress());
		System.out.println();
		
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("LOCAL IP = "+local.getHostAddress());
		System.out.println();
		
		InetAddress[] ar = InetAddress.getAllByName("www.daum.net");
//		for(int i=0 ; i<ar.length; i++) {
//			System.out.println(ar[i].getHostAddress());
//		}
		
		for(InetAddress data : ar) {
			System.out.println("daum IP = "+data.getHostAddress());
		}
	}	
}
