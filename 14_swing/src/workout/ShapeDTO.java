package workout;

enum Figure {
	LINE, CRLCLE, RCT, ROUNDRECT, PEN
}

public class ShapeDTO {

//	public static final int LINE=0;
//	public static final int CIRCLE=1;
//	public static final int RECT=2;
//	public static final int ROUNDRECT=3;
//	public static final int PEN=4;

	private int x1, y1, x2, y2, z1, z2;
	private boolean fill;
	private Figure shape;
	private int color;

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}

	public int getZ1() {
		return z1;
	}

	public void setZ1(int z1) {
		this.z1 = z1;
	}

	public int getZ2() {
		return z2;
	}

	public void setZ2(int z2) {
		this.z2 = z2;
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public Figure getShape() {
		return shape;
	}

	public void setShape(Figure shape) {
		this.shape = shape;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

}
