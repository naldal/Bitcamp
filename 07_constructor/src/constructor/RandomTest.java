package constructor;

import java.util.Random;

public class RandomTest {

	public RandomTest() {
		System.out.println(Math.random());
		System.out.println(new Random().nextDouble());
		System.out.println(new Random().nextInt());
		System.out.println(new Random().nextInt(100));
		System.out.println(new Random().nextInt(100)+1);
	}
	
	public static void main(String[] args) {
		//RandomTest rt = new RandomTest();
		new RandomTest(); //ÀÏÈ¸¿ë
	}
}
