package abstract_1;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class WindowTest extends Frame{
	
	public WindowTest() {
		setTitle("이미지 넣기");
		
		setBackground(new Color(140,140,140));
		setForeground(Color.GREEN);
		
		this.setBounds(900, 200, 300, 400);
		setVisible(true);	
	}
	
	@Override
	public void paint(Graphics g) {
		Toolkit t = Toolkit.getDefaultToolkit(); //생성
		Image img = t.getImage("D:/java_se/workspace/09_abstract/img.jpg");//이미지 불러오기
		g.drawImage(img, 20, 100, this);//이미지 그리기
	}
	
	public static void main(String[] args) {
		new WindowTest();
	}
}


