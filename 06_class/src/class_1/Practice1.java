package class_1;

public class Practice1 {

	public static void main(String[] args) {
		BookShop bk = new BookShop();
		
		bk.setBookName("자바완성");
		bk.setAuthor("김완성");
		bk.setPrice("25000원");
		
		System.out.println("책이름:"+bk.getBookName());
		System.out.println("저  자:"+bk.getAuthor());
		System.out.println("가  격:"+bk.getPrice());
		System.out.println();
		
		BookShop bk2 = new BookShop();
		bk2.setBookName("JSP잡기");
		bk2.setAuthor("송JP");
		bk2.setPrice("35000원");
		
		System.out.println("책이름:"+bk2.getBookName());
		System.out.println("저  자:"+bk2.getAuthor());
		System.out.println("가  격:"+bk2.getPrice());
	}
}
