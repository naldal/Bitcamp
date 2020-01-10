package swing;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("all")
public class MsPaint{

	/*JRadioButton의 기본은 사각형 체크가 된다
	 만약 원을 선택하면 자동으로 사각형은 해제된다 
	 캔버스의 기본색은 연보라 색으로 한다.
	 
	 둥근사각형의 모서리는 가로세로 50씩 넣는다. 둥근 사각형 안해도 됨 ㅅㄱ
	 
	 x1T, y1T, x2T, y2T 이곳에 좌표를 입력하고 그리기 버튼을 누르면 원하는 도형으로 캔버스에 그려진다
	 */
	
	private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
	private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
	private JCheckBox fill;
	private JRadioButton line, circle, rect, roundRect;
	private JComboBox combo;
	private JButton draw;
	private DrCanvas can;
	
	public MsPaint() {
		
	}
	
	public static void main(String[] args) {
		
	}
}
