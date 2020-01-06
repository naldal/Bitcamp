package interface_1;

public interface InterA {

	public static final String NAME= "홍길동";
	int AGE=25; //인터페이스에서만 public static final 생략가능
	
	public abstract void aa();
	public void bb(); //인터페이스에서는 abstract 생략가능 
}
