package class_2;

import java.util.StringTokenizer;

public class Token {
	
	public static void main(String[] args) {
		String str = "학원,집,,게임방";
		
		StringTokenizer st = new StringTokenizer(str, ",");
		System.out.println("토큰개수 ="+st.countTokens()); // 학원/집/게임방 <-- 배열로 못돌림 012 없음
		
		while(st.hasMoreTokens()) {	// 토큰 있는지 없는지
			System.out.println(st.nextToken()); // 현재 토큰 꺼내고 다음으로 이동 없으면 false까지 	
		}
		//토큰 True/False --> 토큰을 꺼내고 다음으로 이동 (반복)
		//마지막 토큰꺼내고 없으면 False 
		
		System.out.println("--------------");
		
		String[] ar = str.split(","); //",,"사이의 공백도 구함, 배열이기때문에 length로 길이구할 수 있음
		for(String data:ar) {
			System.out.println(data);
		}
	}
	
}
