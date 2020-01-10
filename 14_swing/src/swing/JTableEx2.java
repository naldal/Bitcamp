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
		list.add(new PersonDTO("hong", "ȫ�浿", "111", "010-123-1234"));
		list.add(new PersonDTO("conan", "�ڳ�", "333", "010-777-7777"));

		// ����
		vector = new Vector<String>();
		vector.addElement("���̵�");
		vector.addElement("�̸�");
		vector.add("��й�ȣ");
		vector.add("�ڵ���");

		model = new DefaultTableModel(vector, 0) {
			@Override
			public boolean isCellEditable(int row, int c) {
				return (c != 0) ? true : false;
			}
		};// �� ���� ���� �����

		// ������
		for (PersonDTO dto : list) {
			Vector<String> v = new Vector<>();
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getTel());

			model.addRow(v);
		}

		// String name = JOptionPane.showInputDialog(this, "�̸��� �Է����ּ���");

		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);

		addBtn = new JButton("�߰�");
		delBtn = new JButton("����");

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
		String id = JOptionPane.showInputDialog(this, "���̵� �Է��ϼ���");
		if(id==null) {
			return;
		}
		
		for (int i = 0; i < model.getRowCount(); i++) {
			if (id.equals(model.getValueAt(i, 0))) {
				JOptionPane.showMessageDialog(this, "������� ���̵��Դϴ�.");
				return;
			}
		}// for
		String name = JOptionPane.showInputDialog(this, "�̸��� �Է�");
		String pwd = JOptionPane.showInputDialog(this, "��й�ȣ�� �Է�");
		String tel = JOptionPane.showInputDialog(this, "�ڵ����� �Է�");
	
		Vector<String> vec = new Vector<String>();
		
		vec.add(id);
		vec.add(name);
		vec.add(pwd);
		vec.add(tel);
		
		JOptionPane.showMessageDialog(this, "��ϿϷ�");
		model.addRow(vec);
	}
	
	private void delete() {
		// TODO Auto-generated method stub
		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���");
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