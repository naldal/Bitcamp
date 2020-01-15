package answer;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
 
import answer.ScoreDTO;


public class ScoreForm_1 extends JFrame implements ActionListener {

	private JLabel hakL, nameL, korL, engL, mathL;
	private JTextField hakT, nameT, korT, engT, mathT;
	private JButton inputB, printB, searchB, rankB, saveB, loadB;
	private JTextArea area;
	private Score score;
	private ScoreDTO dto;

	public ScoreForm_1() {
		// 기본 틀 생성
		setBounds(200, 200, 800, 400);

		score = new ScoreImpl();
		// 라벨 생성
		hakL = new JLabel("학번");
		nameL = new JLabel("이름");
		korL = new JLabel("국어");
		engL = new JLabel("영어");
		mathL = new JLabel("수학");

		// 텍스트필드 생성
		hakT = new JTextField(20);
		nameT = new JTextField(20);
		korT = new JTextField(20);
		engT = new JTextField(20);
		mathT = new JTextField(20);

		// 버튼 생성
		inputB = new JButton("입력");
		printB = new JButton("출력");
		searchB = new JButton("학번검색");
		rankB = new JButton("순위");
		saveB = new JButton("파일저장");
		loadB = new JButton("파일읽기");

		// 버튼 패널 생성
		JPanel buttonP = new JPanel(new GridLayout(1, 6, 5, 3));
		buttonP.add(inputB);
		buttonP.add(printB);
		buttonP.add(searchB);
		buttonP.add(rankB);
		buttonP.add(saveB);
		buttonP.add(loadB);

		JPanel p1 = new JPanel();
		p1.add(hakL); p1.add(hakT);
		JPanel p2 = new JPanel();
		p2.add(nameL); p2.add(nameT);
		JPanel p3 = new JPanel();
		p3.add(korL); p3.add(korT);
		JPanel p4 = new JPanel();
		p4.add(engL); p4.add(engT);
		JPanel p5 = new JPanel();
		p5.add(mathL); p5.add(mathT);

		// 왼쪽 라벨 패널
		JPanel inputP = new JPanel(new GridLayout(5, 1, 3, 1));
	
		inputP.add(p1);
		inputP.add(p2);
		inputP.add(p3);
		inputP.add(p4);
		inputP.add(p5);

		// 왼쪽 텍스트 패널
		JPanel tP = new JPanel(new GridLayout(5, 1, 1, 3));
		p1.add(hakT);
		p2.add(nameT);
		p3.add(korT);
		p4.add(engT);
		p5.add(mathT);

		tP.add(p1);
		tP.add(p2);
		tP.add(p3);
		tP.add(p4);
		tP.add(p5);

		// 우측 텍스트 에어리어생성
		JPanel taP = new JPanel();

		area = new JTextArea(25, 35);
		JScrollPane scroll = new JScrollPane(area);
		taP.add(scroll);

		// 컨테이너 생성
		Container con = this.getContentPane();
		con.add("South", buttonP);
		con.add("West", inputP);
		con.add("Center", tP);
		con.add("East", taP);

		setVisible(true);
		event();
	}

	// 이벤트 처리
	public void event() {
		inputB.addActionListener(this);
		printB.addActionListener(this);
		searchB.addActionListener(this);
		rankB.addActionListener(this);
		saveB.addActionListener(this);
		loadB.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == inputB) {
			dto = new ScoreDTO(hakT.getText(), nameT.getText(), Integer.parseInt(korT.getText()),
					Integer.parseInt(engT.getText()), Integer.parseInt(mathT.getText()));
			dto.calc();
			score.input(dto);
			JOptionPane.showMessageDialog(this, "등록완료!");
			
			hakT.setText("");
			nameT.setText("");
			korT.setText("");
			engT.setText("");
			mathT.setText("");
		} else if (e.getSource() == printB) {
			score.print(area);
		} else if (e.getSource() == searchB) {
			score.search(area);
		} else if (e.getSource() == rankB) {
			score.tot_desc();
			score.print(area);
		} else if (e.getSource() == saveB) {
			score.save();
		} else if (e.getSource() == loadB) {
			score.load();
			score.print(area);
		}
	}
}
