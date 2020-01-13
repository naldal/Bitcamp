package swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

class JTableModel extends AbstractTableModel {
	Object[][] data = { { "Nari", "마루치", new Integer(1234), "옆집친구" }, { "One", "오윤아", new Integer(1111), "예쁜이" },
			{ "two", "오윤서", new Integer(2222), "귀염둥이" }, { "three", "아라치", new Integer(3333), "동아리 친구" } };
	String[] name = { "아이디", "이름", "비밀번호", "구분" };

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

	public String getColumnName(int c) { // 테이블의 타이틀 명 부여
		return name[c];
	}

	public void setValueAt(Object obj, int r, int c) { // 필드값 변경
		data[r][c] = obj;
	}

}

public class JTableEx extends JFrame {
	JTable table;
	JTableModel model; // 사용자 모델 정의 클래스

	public JTableEx() {
		model = new JTableModel();
		table = new JTable(model);
		add(new JScrollPane(table)); // 스크롤바 생성

		setBounds(200, 200, 300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new JTableEx();
	}
}
