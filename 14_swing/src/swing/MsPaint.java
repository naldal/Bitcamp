package swing;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("all")
public class MsPaint{

	/*JRadioButton�� �⺻�� �簢�� üũ�� �ȴ�
	 ���� ���� �����ϸ� �ڵ����� �簢���� �����ȴ� 
	 ĵ������ �⺻���� ������ ������ �Ѵ�.
	 
	 �ձٻ簢���� �𼭸��� ���μ��� 50�� �ִ´�. �ձ� �簢�� ���ص� �� ����
	 
	 x1T, y1T, x2T, y2T �̰��� ��ǥ�� �Է��ϰ� �׸��� ��ư�� ������ ���ϴ� �������� ĵ������ �׷�����
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
