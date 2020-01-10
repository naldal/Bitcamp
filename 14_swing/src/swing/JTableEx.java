package swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

class JTableModel extends AbstractTableModel {
	Object[][] data = { { "Nari", "����ġ", new Integer(1234), "����ģ��" }, { "One", "������", new Integer(1111), "������" },
			{ "two", "������", new Integer(2222), "�Ϳ�����" }, { "three", "�ƶ�ġ", new Integer(3333), "���Ƹ� ģ��" } };
	String[] name = { "���̵�", "�̸�", "��й�ȣ", "����" };

	@Override
	public int getColumnCount() {
		return name.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public Object getValueAt(int r, int c) {
		return data[r][c];
	}

	public boolean isCellEditable(int r, int c) {
		return (c != 0) ? true : false;
	}

	public String getColumnName(int c) { // ���̺��� Ÿ��Ʋ �� �ο�
		return name[c];
	}

	public void setValueAt(Object obj, int r, int c) { // �ʵ尪 ����
		data[r][c] = obj;
	}

}

public class JTableEx extends JFrame {
	JTable table;
	JTableModel model; // ����� �� ���� Ŭ����

	public JTableEx() {
		model = new JTableModel();
		table = new JTable(model);
		add(new JScrollPane(table)); // ��ũ�ѹ� ����

		setBounds(200, 200, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JTableEx();
	}
}