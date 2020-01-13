package workout;

public class FruitMain {
	
	public static void main(String[] args) {
		Fruit[] ft = new Fruit[3];
		
		ft[0] = new Fruit("사과", 100, 80, 75);
		ft[1] = new Fruit("포도", 30, 25, 10);
		ft[2] = new Fruit("딸기", 25, 30, 90);
		
		System.out.println("------------------------------------");
		System.out.println("PUM\tJAN\tFEB\tMAR\tTOT");
		System.out.println("------------------------------------");
		
		for(int i=0; i<ft.length; i++) {
			ft[i].calcTot();
			ft[i].display();
		}
		
		Fruit.output();
	}
}
