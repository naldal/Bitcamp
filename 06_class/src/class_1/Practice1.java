package class_1;

public class Practice1 {

	public static void main(String[] args) {
		BookShop bk = new BookShop();
		
		bk.setBookName("�ڹٿϼ�");
		bk.setAuthor("��ϼ�");
		bk.setPrice("25000��");
		
		System.out.println("å�̸�:"+bk.getBookName());
		System.out.println("��  ��:"+bk.getAuthor());
		System.out.println("��  ��:"+bk.getPrice());
		System.out.println();
		
		BookShop bk2 = new BookShop();
		bk2.setBookName("JSP���");
		bk2.setAuthor("��JP");
		bk2.setPrice("35000��");
		
		System.out.println("å�̸�:"+bk2.getBookName());
		System.out.println("��  ��:"+bk2.getAuthor());
		System.out.println("��  ��:"+bk2.getPrice());
	}
}
