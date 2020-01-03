package com.apple;
import com.zoo.*;
//패키지 연습
public class Apple {
	
	public static void main(String[] args) {
		System.out.println("빨간 사과");
		
		Zoo zoo = new Zoo();
		zoo.tiger();
//		zoo.giraffe();
//		zoo.elephant();
//		zoo.lion();		//외부 패키지는 public접근제어자가 아닌이상 사용불가 (상속시 protected는 예외)
		
	}
}
