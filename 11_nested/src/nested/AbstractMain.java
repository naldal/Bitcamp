package nested;

public class AbstractMain {

	public static void main(String[] args) {
		AbstractTest at = new AbstractTest() { //�͸� �̳� Ŭ����. ��� �������̵� ���ش�
			
			public void setName(String name) {this.name = name;}

		}; 
		
		InterA aa = new InterA() {	//���� extends implements�� �ʿ� ���� �ڸ����� �ٷ� ������ �����ϴ�
		//���⿡�� new�� InterA�� �����ϴ� ���� �ƴ϶� �͸�Ŭ���� {}�� �����ϴ� ��
			public void aa() {} 
			public void bb() {}
		};
		
		AbstractExam ae = new AbstractExam() {}; //�߻�޼��尡 ���� ������ ���������� �������̵� ����. �ƿ� ���ص� ��
	}
}
