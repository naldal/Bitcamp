package class_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ComputeMain {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Compute[] cp = new Compute[3];
		
		for(int i=0; i<3; i++) {
			cp[i] = new Compute();
			System.out.print("x 입력 : ");
			
			cp[i].setX(Integer.parseInt(br.readLine()));
			System.out.print("y 입력 : ");
			
			cp[i].setY(Integer.parseInt(br.readLine()));
			cp[i].calc();
			System.out.println();
		}
		
		System.out.println("X\tY\tSUM\tSUB\tMUL\tDIV");
		
		for(Compute data : cp) {
			System.out.println(data.getX()+"\t"+data.getY()+"\t"+data.getSum()+"\t"+data.getSub()+"\t"+data.getMul()+"\t"+String.format("%.2f",data.getDiv()));
		}
	}
}

