package com.zoo;

public class ZooMain {

	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		
		zoo.tiger();
		zoo.giraffe();
		zoo.elephant();
		// zoo.lion(); private 타 클래스에서 접근 불가
		
		
	}
}
