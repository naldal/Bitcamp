package swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("all")
public class JTableEx2 extends JFrame implements ActionListener {
	private ArrayList<PersonDTO> list;
	private Vector<String> vector;
	private DefaultTableModel model;
	private Container c;
	private JTable table;
	private JButton addBtn, delBtn;

	public JTableEx2() {

		list = new ArrayList<PersonDTO>();
		list.add(new PersonDTO("hong", "홍길동", "111", "010-123-1234"));
		list.add(new PersonDTO("conan", "코난", "333", "010-777-7777"));

		// 제목
		vector = new Vector<String>();
		vector.addElement("아이디");
		vector.addElement("이름");
		vector.add("비밀번호");
		vector.add("핸드폰");

		model = new DefaultTableModel(vector, 0) {
			@Override
			public boolean isCellEditable(int row, int c) {
				return (c != 0) ? true : false;
			}
		};// 빈 행의 수를 만든다

		// 데이터
		for (PersonDTO dto : list) {
			Vector<String> v = new Vector<>();
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getTel());

			model.addRow(v);
		}

		// String name = JOptionPane.showInputDialog(this, "이름을 입력해주세요");

		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);

		addBtn = new JButton("추가");
		delBtn = new JButton("삭제");

		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p.add(addBtn);
		p.add(delBtn);

		Container con = this.getContentPane();
		add("Center", scroll);
		con.add("South", p);

		setBounds(200, 200, 500, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// events
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == addBtn)
			insert();
		else if (e.getSource() == delBtn)
			delete();
	}

	private void insert() {
		// TODO Auto-generated method stub
		String id = JOptionPane.showInputDialog(this, "아이디를 입력하세요");
		if(id==null) {
			return;
		}
		
		for (int i = 0; i < model.getRowCount(); i++) {
			if (id.equals(model.getValueAt(i, 0))) {
				JOptionPane.showMessageDialog(this, "사용중인 아이디입니다.");
				return;
			}
		}// for
		String name = JOptionPane.showInputDialog(this, "이름을 입력");
		String pwd = JOptionPane.showInputDialog(this, "비밀번호를 입력");
		String tel = JOptionPane.showInputDialog(this, "핸드폰을 입력");
	
		Vector<String> vec = new Vector<String>();
		
		vec.add(id);
		vec.add(name);
		vec.add(pwd);
		vec.add(tel);
		
		JOptionPane.showMessageDialog(this, "등록완료");
		model.addRow(vec);
	}
	
	private void delete() {
		// TODO Auto-generated method stub
		String name = JOptionPane.showInputDialog(this, "이름을 입력하세요");
		int sw = 0;
		
		for(int i=0; i<model.getRowCount(); i++) {
			if(name.equals(model.getValueAt(i, 1))) {
				model.removeRow(i);
				i--;
				sw=1;
			}
		}
	}

	public static void main(String[] args) {
		new JTableEx2();
	}

}