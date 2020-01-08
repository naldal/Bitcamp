package exception;

//개발자가 만든 Exception 클래스
public class MakeException extends Exception{
	private String errorMsg;
	
	@SuppressWarnings("unused")
	private MakeException() {}
	
	public MakeException(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	@Override
	public String toString() {
		//return getClass()+":"+errorMsg;
		return errorMsg;
	}
}
