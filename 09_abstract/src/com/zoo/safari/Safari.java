package com.zoo.safari;

import com.zoo.Zoo;

public class Safari extends Zoo{
	
	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		
		zoo.tiger();
		//zoo.giraffe();  :error �ڽ�Ŭ������ �������� ���� ���¿��� protected ���Ұ��� (�θ�Ŭ�����ۿ� �޸𸮿� ������ ����)
		
		Safari safari = new Safari();
		safari.tiger();
		safari.giraffe();
//		safari.elephant();
//		safari.lion();  
		
	}
}
