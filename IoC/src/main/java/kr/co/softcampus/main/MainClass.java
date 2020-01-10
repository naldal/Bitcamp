package kr.co.softcampus.main;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import kr.co.softcampus.beans.TestBean;

public class MainClass {
	
	public static void main(String[] args) {
		//test1();
		//test2();
		//test3();
		test4();
	}
	
	//BeanFactory - 패키지 내부
	public static void test1() {
		ClassPathResource res = new ClassPathResource("kr/co/softcampus/config/beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);
		
		TestBean t1 = factory.getBean("test1", TestBean.class); //여기서 생성
		System.out.printf("t1 : %s\n", t1);
		
		TestBean t2 = factory.getBean("test1", TestBean.class); //이미 생성됐다면 생성된 객체변수에서 객체주소를 가져온다
		System.out.println(t2);
	}
	
	
	//BeanFactory - 패기키 외부
	public static void test2() {
		FileSystemResource res = new FileSystemResource("beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(res);
		
		TestBean t1 = factory.getBean("t2",TestBean.class); //여기서 생성한거
		System.out.println(t1);
		
		TestBean t2 = factory.getBean("t2", TestBean.class); //여기서도 이름(객체변수)만 바꿔서 재사용한다
		System.out.println(t2);
		//결과 주솟값은 똑같음
	}
	
	//ApplicationContext - 패키지 내부
	public static void test3() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("kr/co/softcampus/config/beans.xml"); //여기서 객체생성
		TestBean t1 = ctx.getBean("test1",TestBean.class); //여기서 위에서 만든 객체를 변수에다만 넣어줌
		TestBean t2 = ctx.getBean("test1", TestBean.class);
		System.out.println(t1);
		System.out.println(t2);
		ctx.close();
	}
	
	//ApplicationContext - 패키지 외부
	public static void test4() {
		FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("beans.xml");
		TestBean t1 = ctx.getBean("t2", TestBean.class);
		System.out.println(t1);
		
		TestBean t2 = ctx.getBean("t2", TestBean.class);
		System.out.println(t2);
		ctx.close();
	}
}
