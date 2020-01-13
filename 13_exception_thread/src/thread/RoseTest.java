package thread;

public class RoseTest extends Thread{
	private String name;
	
	public RoseTest(String name) {
		this.name=name;
	}
	
	public void run() { //���� ȣ�� �� ������
		for(int i=1; i<=5; i++) {
			System.out.println(name+"\t"+Thread.currentThread()+"\t i="+i);
		}
		System.out.println(name+"  "+"����");
	}
	
	public static void main(String[] args) {
		RoseTest aa = new RoseTest("�ȶ�"); //������ ����
		RoseTest bb = new RoseTest("�ູ"); //������ ����
		RoseTest cc = new RoseTest("���"); //������ ����
		
		aa.setName("�ȶ�");
		bb.setName("�ູ");
		cc.setName("���");
		
		//�켱���� 1~10 (���廡�������� ������ 10) default=5
		aa.setPriority(MAX_PRIORITY);
		bb.setPriority(5);
		cc.setPriority(MIN_PRIORITY); //100%���������� �ʴ´�
		
		aa.start(); //������ ���� - ������ ����(�ü�� ��)
		try {
			aa.join(); //�ش� �����尡 ���⶧���� �ٸ� ������� ���
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		bb.start(); //������ ���� - ������ ����(�ü�� ��) 
		cc.start(); //������ ���� - ������ ����(�ü�� ��)
	}
}