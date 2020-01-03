package com.zoo.safari;

import com.zoo.Zoo;

public class Safari extends Zoo{
	
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		
		zoo.tiger();
		//zoo.giraffe();  :error 자식클래스가 생성되지 않은 상태에서 protected 사용불가능 (부모클래스밖에 메모리에 잡히지 않음)
		
		Safari safari = new Safari();
		safari.tiger();
		safari.giraffe();
//		safari.elephant();
//		safari.lion();  
		
	}
}
