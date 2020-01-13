package workout;

public class FruitMain2 {

	public static void main(String[] args) {
		Fruit[] ft = {new Fruit("사과", 100, 80, 75),
					 new Fruit("포도", 30, 25, 10),
					 new Fruit("딸기", 25, 30, 90)};
	
		System.out.println("------------------------------------");
		System.out.println("PUM\tJAN\tFEB\tMAR\tTOT");
		System.out.println("------------------------------------");
		
		for(Fruit f: ft) {
			f.calcTot();
		}
		
		System.out.println("-------------------------------------");
		Fruit.output();
	}
}
