package kr.co.softcampus.main;

import ko.co.softcampus.beans.HelloWorld;
import ko.co.softcampus.beans.HelloWorldEn;
import ko.co.softcampus.beans.HelloWorldKo;

public class Main {

	public static void main(String[] args) {
		HelloWorld hello1 = new HelloWorldKo();// new HelloWorldEn();
		callMethod(hello1);
		
		HelloWorld hello2 = new HelloWorldKo();// new HelloWorldEn();
		callMethod(hello2);
	}
	
	public static void callMethod(HelloWorld hello) {
		hello.sayHello();
	}
}
