package abstract_1;

public abstract class AbstractTest { //POJO(plain old java object) == �������Ե� ��ӹ��� �ʴ� �ܼ��� Ŭ���� + setter getter
	String name;
	
//	public void setName(String name){ //����
//		this.name = name;
//	}
	
	public abstract void setName(String name); //�߻�޼���
	//�߻�Ŭ������ �߻�޼ҵ尡 ������ �ϳ� �̻� ������ �Ϲݸ޼��尡 ���� ���� �ִ�.
	public String getName() {
		return name;
	}
	
	
}
