package workout;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JPanel;

//JFrame - BorderLayout
@SuppressWarnings("all")
public class MsPaint extends JFrame {
	private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
	private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
	private List<ShapeDTO> list;

	public JTextField getY1T() {
		return y1T;
	}

	public void setY1T(JTextField y1t) {
		y1T = y1t;
	}

	public JTextField getX2T() {
		return x2T;
	}

	public void setX2T(JTextField x2t) {
		x2T = x2t;
	}

	public JTextField getY2T() {
		return y2T;
	}

	public void setY2T(JTextField y2t) {
		y2T = y2t;
	}

	public JTextField getZ1T() {
		return z1T;
	}

	public void setZ1T(JTextField z1t) {
		z1T = z1t;
	}

	public JTextField getZ2T() {
		return z2T;
	}

	public void setZ2T(JTextField z2t) {
		z2T = z2t;
	}

	public JLabel getY2L() {
		return y2L;
	}

	public JLabel getZ1L() {
		return z1L;
	}

	public JLabel getZ2L() {
		return z2L;
	}

	public JCheckBox getFill() {
		return fill;
	}

	public JRadioButton getLine() {
		return line;
	}

	public JRadioButton getCircle() {
		return circle;
	}

	public JRadioButton getRect() {
		return rect;
	}

	public JRadioButton getRoundRect() {
		return roundRect;
	}

	public JComboBox<String> getCombo() {
		return combo;
	}

	public void setX1T(JTextField x1t) {
		x1T = x1t;
	}

	public JRadioButton getPen() {
		return pen;
	}

	private JCheckBox fill;
	private JRadioButton line, circle, rect, roundRect, pen;
	private JComboBox combo;
	private JButton draw;
	private DrCanvas can;

	public MsPaint(String title) {
		x1L = new JLabel("x1");
		y1L = new JLabel("y1");
		x2L = new JLabel("x2");
		y2L = new JLabel("y2");
		z1L = new JLabel("z1");
		z2L = new JLabel("z2");

		x1T = new JTextField("0", 4);
		y1T = new JTextField("0", 4);
		x2T = new JTextField("0", 4);
		y2T = new JTextField("0", 4);
		z1T = new JTextField("50", 4);
		z2T = new JTextField("50", 4);

		fill = new JCheckBox("채우기");

		line = new JRadioButton("선");
		circle = new JRadioButton("원");
		rect = new JRadioButton("사각형", true);
		roundRect = new JRadioButton("둥근사각형");
		pen = new JRadioButton("펜");

		ButtonGroup group = new ButtonGroup();
		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		group.add(pen);

		String rainbow[] = { "빨강색", "주황색", "노랑색", "초록색", "파랑색", "남색", "보라색" };
		combo = new JComboBox<String>(rainbow);
		draw = new JButton("그리기");
		can = new DrCanvas(this);
		list = new ArrayList<ShapeDTO>();

		JPanel northP = new JPanel();// FlowLayout(순서배치-중앙)
		northP.add(x1L);
		northP.add(x1T);
		northP.add(y1L);
		northP.add(y1T);
		northP.add(x2L);
		northP.add(x2T);
		northP.add(y2L);
		northP.add(y2T);
		northP.add(z1L);
		northP.add(z1T);
		northP.add(z2L);
		northP.add(z2T);
		northP.add(fill);

		JPanel southP = new JPanel();
		southP.add(line);
		southP.add(circle);
		southP.add(rect);
		southP.add(roundRect);
		southP.add(pen);
		southP.add(combo);
		southP.add(draw);

		Container c = this.getContentPane();
		c.add("North", northP);
		c.add("South", southP);
		c.add("Center", can);

		setTitle(title);
		setBounds(900, 100, 700, 500);
		setVisible(true); // paint 찾음
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// add
		draw.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				can.repaint();
			}
		});

		can.addMouseListener(new MouseAdapter() {

			@Override
			public void mousePressed(MouseEvent e) {
				x1T.setText(e.getX() + "");
				y1T.setText(e.getY() + "");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				x2T.setText(e.getX() + "");
				y2T.setText(e.getY() + "");
				if (x1T.getText().equals(x2T.getText()) && y1T.getText().equals(y2T.getText())) {
					return;
				}

				ShapeDTO dto = new ShapeDTO();
				dto.setX1(Integer.parseInt(x1T.getText().trim()));
				dto.setY1(Integer.parseInt(y1T.getText().trim()));
				dto.setX2(Integer.parseInt(x2T.getText().trim()));
				dto.setY2(Integer.parseInt(y2T.getText().trim()));
				dto.setZ1(Integer.parseInt(z1T.getText().trim()));
				dto.setZ2(Integer.parseInt(z2T.getText().trim()));

				// 채우기
				dto.setFill(fill.isSelected());

				// 도형
				if (line.isSelected()) {
					dto.setShape(Figure.LINE);
				} else if(circle.isSelected()) {
					dto.setShape(Figure.CRLCLE);
				} else if(rect.isSelected()) {
					dto.setShape(Figure.RCT);
				} else if(roundRect.isSelected()) {
					dto.setShape(Figure.ROUNDRECT);
				} else if(pen.isSelected()) {
					dto.setShape(Figure.PEN);
				}
				
				//색
				dto.setColor(combo.getSelectedIndex());

				getList().add(dto);
				// System.out.println("list 크기"+list.size());
			}
		});

		can.addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				x2T.setText(e.getX() + "");
				y2T.setText(e.getY() + "");

				can.repaint();

				// 연필
				if (pen.isSelected()) {
					ShapeDTO dto = new ShapeDTO();
					
					//좌표
					dto.setX1(Integer.parseInt(x1T.getText().trim()));
					dto.setY1(Integer.parseInt(y1T.getText().trim()));
					dto.setX2(Integer.parseInt(x2T.getText().trim()));
					dto.setY2(Integer.parseInt(y2T.getText().trim()));
					dto.setZ1(Integer.parseInt(z1T.getText().trim()));
					dto.setZ2(Integer.parseInt(z2T.getText().trim()));
					
					// 채우기
					dto.setFill(fill.isSelected());
					
					dto.setShape(Figure.PEN);
					
					//색
					dto.setColor(combo.getSelectedIndex());
					
					list.add(dto);
					
					x1T.setText(x2T.getText());
					y1T.setText(y2T.getText());
				}
			}
		});
	}

	public JTextField getX1T() {
		return x1T;
	}

	public List <ShapeDTO> getList() {
		return list;
	}
	
	public static void main(String[] args) {
		new MsPaint("간단 그림판");
	}

	

}