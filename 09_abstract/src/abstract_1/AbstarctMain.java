package abstract_1;

public class AbstarctMain extends AbstractTest{


	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
		//AbstractTest at = new AbstractTest(); error: �߻�Ŭ������ new���� ���Ѵ�(�޸𸮿� �������� ���Ѵ�).
		AbstractTest at = new AbstarctMain();
		at.setName("ȫ�浿"); //ȣ��
		System.out.println("�̸�="+at.getName());
	}
}
