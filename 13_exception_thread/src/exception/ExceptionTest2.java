package exception;

import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.IOException;

public class ExceptionTest2 {

	private static int dan;
	
	public static void main(String[] args) throws IOException{
		ExceptionTest2 et = new ExceptionTest2();
		et.input();
		et.output();
	}
	
	public void input() throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("���ϴ� �� ");
		dan = Integer.parseInt(br.readLine());
	}
	
	public void output() {
		for(int j=1; j<10; j++) {
			if(dan>9||dan<2) {
				try {
					//throw new Exception("�����ʰ�!!!");
					throw new MakeException("�����ʰ�!!!");
				} catch(Exception e) {
					e.printStackTrace();
				}
				return;
			} else {
				System.out.println(dan+"*"+j+"="+dan*j);
			}
		}
	}
}
