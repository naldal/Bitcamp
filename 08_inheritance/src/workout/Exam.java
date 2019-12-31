package workout;

import java.util.Scanner;

public class Exam {
	Scanner sc = new Scanner(System.in);
	
	private String name;
	private String dap;
	private char[] ox;
	private int score;
	private final String JUNG="11111"; //정답-상수화
	
	public Exam() {
		System.out.println("이름 입력 : ");
		this.name = sc.next();
		
		System.out.println("답 입력 : ");
		ox= new char[5];
		String tmp = sc.next();
		for(int i=0; i<ox.length; i++) {
			ox[i] = tmp.charAt(i);
		}
		
		System.out.println("이름\t1 2 3 4 5 \t점수");
		compare();
		
	}
	
	public void compare() {
		for(int i=0; i<ox.length; i++) {
			
			if(ox[i]==JUNG.charAt(i)) {
				score+=20;
			}
			
			if(ox[i]=='1') {
				ox[i]='O';
			} else {
				ox[i]='X';
			}
		}
	}
	
	public String getDap() {
		for(int i=0; i<ox.length; i++) {
			dap+=(char)ox[i]+49;
		}
		return dap;
	}
	
	public String getName() {
		return name;
	}
	
	public void getOx() {
		for(int i=0; i<ox.length; i++) {
			System.out.print(ox[i]+" ");	
		}
	}
	
	public int getScore() {
		return score;
	}
}
