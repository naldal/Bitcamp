package workout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//JFrame 창

public class ScoreForm extends JFrame implements ActionListener{
	ScoreImpl impl = new ScoreImpl();
	ScoreDTO dto = new ScoreDTO();
	ArrayList<ScoreDTO> ar = new ArrayList<ScoreDTO>();
	
	private JLabel hakL, nameL, korL, engL, mathL;
	
	private JTextField hakF, nameF, korF, engF, mathF;
	
	private JButton inputB, printB, searchB, tot_descB, saveB, loadB;
	
	private JTextArea area;
	
	private JPanel buttonP, areaP, textP1, textP2, textP3, textP4, textP5, field1, field2, field3, field4, field5;
	
	public String result;
	
	File file;
	
	public ScoreForm() {
		setLayout(null);
	//----------------------------------------------------------------------------------------------------
		buttonP = new JPanel();		areaP = new JPanel();	textP1 = new JPanel();
	//----------------------------------------------------------------------------------------------------
		inputB = new JButton("입력");		printB = new JButton("출력");		searchB = new JButton("검색");
		tot_descB = new JButton("정렬");		saveB = new JButton("저장");		loadB = new JButton("불러오기");
	//----------------------------------------------------------------------------------------------------	
		hakF = new JTextField(15);		nameF = new JTextField(15);		korF = new JTextField(15);
		engF = new JTextField(15);		mathF = new JTextField(15);	
	//----------------------------------------------------------------------------------------------------
		hakL = new JLabel("학번");		nameL = new JLabel("이름");		korL = new JLabel("국어");
		engL = new JLabel("영어");		mathL = new JLabel("수학");		
	//----------------------------------------------------------------------------------------------------	
		area = new JTextArea("", 30,20);
	//----------------------------------------------------------------------------------------------------	
		buttonP = new JPanel();
		buttonP.setLayout(new GridLayout());
		buttonP.add(inputB);	buttonP.add(printB);	buttonP.add(searchB);
		buttonP.add(tot_descB);	buttonP.add(saveB);		buttonP.add(loadB);
		
		buttonP.setBounds(0,230,500,30);
	//-----------------------------------------------------------------------------------------------------	
		areaP = new JPanel();
		//area.setBackground(new Color(200,200,200));
		areaP.add(area);
		areaP.setBounds(220,10,430,200);
	//-----------------------------------------------------------------------------------------------------	
		textP1 = new JPanel();		textP2 = new JPanel();		textP3 = new JPanel();
		textP4 = new JPanel();		textP5 = new JPanel();		// 수평 정렬: BoxLayout.X_AXIS
		
		textP1.setBounds(10,10,30,30);		textP1.add(hakL);
		
		textP2.setBounds(10,50,30,30);		textP2.add(nameL);
		
		textP3.setBounds(10,90,30,30);		textP3.add(korL);
		
		textP4.setBounds(10,130,30,30);		textP4.add(engL);
		
		textP5.setBounds(10,170,30,30);		textP5.add(mathL);
		
	//-----------------------------------------------------------------------------------------------------	
		field1 = new JPanel();		field2 = new JPanel();		field3 = new JPanel();
		field4 = new JPanel();		field5 = new JPanel();
		
		field1.setBounds(50, 10, 200, 30);		field1.add(hakF);
		field2.setBounds(50, 50, 200, 30);		field2.add(nameF);
		field3.setBounds(50, 90, 200, 30);		field3.add(korF);
		field4.setBounds(50, 130, 200, 30);		field4.add(engF);
		
		field5.setBounds(50, 170, 200, 30);
		field5.add(mathF);
		
	//-----------------------------------------------------------------------------------------------------	
		Container c = this.getContentPane();
	
		c.add(buttonP);		c.add(areaP);		c.add(textP1);		c.add(textP2);
		c.add(textP3);		c.add(textP4);		c.add(textP5);		c.add(field1);
		c.add(field2);		c.add(field3);		c.add(field4);		c.add(field5);
		
		setBounds(1100,200,600,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		event();
	}
	//--------------------------------------------------------------------------------------------------------
	
	public void event() {
		inputB.addActionListener(this);
		printB.addActionListener(this);
		searchB.addActionListener(this);
		tot_descB.addActionListener(this);
		saveB.addActionListener(this);
		loadB.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==inputB) {
			dto = new ScoreDTO(hakF.getText().toString(), nameF.getText().toString(),
					Integer.parseInt(korF.getText()), Integer.parseInt(engF.getText()), Integer.parseInt(mathF.getText()));

			impl.input(dto);
			JOptionPane.showMessageDialog(this, "등록완료.");
		} else if(e.getSource()==printB) {
			impl.print(area);
		} else if(e.getSource()==searchB) {
			result = (String)JOptionPane.showInputDialog(this, "학번을 입력하세요", "input dialog", JOptionPane.PLAIN_MESSAGE, null, null, null);
			impl.search(area, result);
		} else if(e.getSource()==tot_descB) {
			impl.tot_desc();
			JOptionPane.showMessageDialog(this, "정렬되었습니다.");
		} else if(e.getSource()==saveB) {
			impl.save(area); 
			JOptionPane.showMessageDialog(this, "저장되었습니다.");
		} else if(e.getSource()==loadB) {
			impl.load(area);
			JOptionPane.showMessageDialog(this, "로드되었습니다.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	private OutputStream FileOutputStream(File file2) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		new ScoreForm();
	}
	

}
