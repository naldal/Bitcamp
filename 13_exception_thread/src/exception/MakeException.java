package exception;

//�����ڰ� ���� Exception Ŭ����
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
