package nested;

public class Outer { //���� Ŭ������ �ܺ�Ŭ������ ������ �� ������(������ ���� Ŭ���� �ȿ�����), �ܺ�Ŭ������ ����Ŭ������ ������ �� ����. (��Ӱ���� �ٸ���) / �ٸ� ��ü�����ϸ� ������ �����ϴ�.

	private String name;
	
	public void output() {
		// System.out.println("�̸�="+name+"\t ����="+age); �ܺ�Ŭ������ ����Ŭ������ �������� ����
		System.out.println("�̸�="+name+"\t ����="+new Inner().age); //��ü������ ����
	}
	
	class Inner {	//��ø�� ���� : �������� Ŭ���������� setter/getter�� �̿��� �ʵ��� ������ �������� ���̱� ����
		private int age;
		
		public void disp() {
			System.out.println("�̸�="+Outer.this.name+"\t ����="+age); //�ܺ�Ŭ������ ��� ����ϴ� ��
		}
	}
	
	public static void main(String[] args) {
		Outer outer = new Outer(); //Inner Ŭ�������� ������ ���� �ڱⲯ�� ����
		outer.name = "ȫ�浿";
		
		System.out.println("�̸�="+outer.name);
		
		Outer.Inner inner = outer.new Inner();
		inner.age=25;
		inner.disp();
		
		Outer.Inner inner2 = outer.new Inner();
		inner2.age = 30;
		inner2.disp();
		
		Outer.Inner inner3 = new Outer().new Inner();
		inner3.age =35;
		inner3.disp();
		
	}
}
