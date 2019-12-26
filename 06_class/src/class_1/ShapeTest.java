package class_1;

public class ShapeTest {

	private double pi = 3.141592;
	
	public void setArae(int num) { //원의 넓이
		this.pi = num * num * pi;
	}
	
	public double getArae() {
		return pi;
	}
	
	public void setArae(int num, int num2) {  //사각형의 넓이
		this.pi = num*num2/2.0;
	}
	
	public void setArae(int num, int num2, int num3) {   //사다리꼴의 넓이
		this.pi = (num+num2)*num3/2.0;
	}
}
