package class_1;

/*
 object oriented programming
- ���ǽ����� �������� ���
- ���� �繰�� �Ӽ�(������)�� ���(�޼ҵ�)�� �����Ͽ� ���󼼰踦 ����
- ���ǽ����� ���� ���� �ð��� ����� ����
- ��ü�����̷��� ĸ��ȭ, ���, �߻�ȭ ����
- �ڵ��� ������ ����
- ���������� �����ϴ�
- ĸ��ȭ, ���, �������� Ư¡
*/

class Person {

	private String name; //�ʵ�, �ʱⰪ�� ����������
	private int age;
	
	
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setData(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public void setData() {
		
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
}

//----------------------------------------------

public class PersonMain {

	public static void main(String[] args) {
		Person aa = new Person();
		System.out.println("�ּڰ�="+aa.toString());
		aa.setName("ȫ�浿");
		aa.setAge(25);
		System.out.println("�̸�="+aa.getName()+"\t ����="+aa.getAge());
		
		Person bb = new Person();
		System.out.println("�ּڰ�="+bb.toString());
		bb.setAge(16);
		bb.setName("�ڳ�");
		System.out.println("�̸�="+bb.getName()+"\t ����="+bb.getAge());
		
		Person cc = new Person();
		System.out.println("�ּڰ�="+cc.toString());
		cc.setData("��ġ", 30);
		System.out.println("�̸�="+cc.getName()+"\t ����="+cc.getAge());
		
		Person dd = new Person();
		System.out.println("�ּڰ�="+dd.toString());
		cc.setData();
		System.out.println("�̸�="+dd.getName()+"\t ����="+dd.getAge());
		System.out.println();
	}
}

//int aa;		������ ����
//double aa;	�Ǽ��� ����
//char aa;	������ ����
//
//Person aa;	��ü(�ּڰ� �������)