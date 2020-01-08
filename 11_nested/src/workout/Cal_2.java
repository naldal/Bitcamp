package workout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Character.Subset;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Cal_2 extends JFrame implements ActionListener{

	boolean flag = false; // 연산자체크
	boolean isZero = false; //0만 있는가
	boolean isOperater = false; //계산자가 바로 옆에 없다면
	
	int isDot=0; //.이 있는가
	int num1;
	int num2;
	int result;
	int cnt=0;

	private String resultFin="";
	private String show=""; //디스플레이용 버퍼 to 스트링
	private String tmp="";
	private String tmp2="";
	private String operVal="";
	private String strResult;
	private String setNum;
	
	private JLabel dispL, inputL;
	private JButton[] button;
	
	StringBuffer buff = new StringBuffer();
	
	public Cal_2() {
		
		//레이아웃 설정
		setLayout(null);
		setTitle("계산기");
		setBounds(800,300,400,500);
		setBackground(Color.black);
		
		//라벨설정
		dispL = new JLabel("", JLabel.RIGHT);
		dispL.setBackground(Color.WHITE);
		dispL.setOpaque(true);
		dispL.setBounds(9,10,375,50);
		
		inputL = new JLabel("0", JLabel.RIGHT);
		inputL.setBackground(Color.WHITE);
		inputL.setOpaque(true);
		inputL.setBounds(9,70,375,50);
		
		//버튼 설정
		String[] title = {"←","C",
				"7","8","9","/",
				"4","5","6","*",
				"1","2","3","-",
				".","0","=","+"};
		
		button = new JButton[18];
		for(int i=0; i<button.length; i++) {
			button[i] = new JButton(title[i]);
		}
		
		//버튼 배치
		button[0].setBounds(199,160,185,50); //<-
		button[1].setBounds(9,160,185,50); //C
				
		button[5].setBounds(294,220,90,50); // /
		button[4].setBounds(199,220,90,50); // 9
		button[3].setBounds(104,220,90,50); // 8
		button[2].setBounds(9,220,90,50); // 7
		
		button[9].setBounds(294,280,90,50); // *
		button[8].setBounds(199,280,90,50); // 6
		button[7].setBounds(104,280,90,50); // 5
		button[6].setBounds(9,280,90,50); // 4
		
		button[13].setBounds(294,340,90,50); // -
		button[12].setBounds(199,340,90,50); // 3
		button[11].setBounds(104,340,90,50); // 2
		button[10].setBounds(9,340,90,50); // 1
		
		button[17].setBounds(294,400,90,50); // +
		button[16].setBounds(199,400,90,50); // =
		button[15].setBounds(104,400,90,50); // 0
		button[14].setBounds(9,400,90,50); //.
		
		add(dispL);
		add(inputL);
		for(int i=0; i<button.length; i++) {
			add(button[i]);
			button[i].addActionListener(this);
		}


		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Cal_2 cal2 = new Cal_2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button[1]) { // C
			clearAll();
		} else if(e.getSource()==button[15]) { //0
			setNum("0");
		} else if(e.getSource()==button[0]) {
			backspace();
		} else if(e.getSource()==button[10]) { //1
			setNum("1");
		} else if(e.getSource()==button[11]) { //2
			setNum("2");
		} else if(e.getSource()==button[12]) { //3
			setNum("3");;
		} else if(e.getSource()==button[6]) { //4
			setNum("4");
		} else if(e.getSource()==button[7]) { //5
			setNum("5");
		} else if(e.getSource()==button[8]) { //6
			setNum("6");
		} else if(e.getSource()==button[2]) { //7
			setNum("7");
		} else if(e.getSource()==button[3]) { //8
			setNum("8");
		} else if(e.getSource()==button[4]) { //9
			setNum("9");
		} else if(e.getSource()==button[17]) { //+
			Operator("+");
		} else if(e.getSource()==button[13]) { //-
			Operator("-");
		} else if(e.getSource()==button[9]) { //*
			Operator("*");
		} else if(e.getSource()==button[5]) { // /
			Operator("/");
		} else if(e.getSource()==button[16]) { // =
			
			if(!tmp.equals("")&&!tmp2.equals("")) {
				
				resultFin = Calc(tmp, tmp2, operVal);
				inputL.setText(resultFin);
			}
		} else if(e.getSource()==button[14]) { // .
			if(isDot==1) {
				buff.append(".");
				show = buff.toString();
				dispL.setText(show);
				isDot++;
				
			} else if(isDot>1) {
				dispL.setText(show);
			}
		}
	}
	
	public void backspace() {
		if(dispL.getText().length()>1) {	
			String tmp  = dispL.getText(); 		
			int tmplength = tmp.length()-1;		
			tmp = tmp.substring(0,tmplength);
			dispL.setText(tmp);
		} else {
			dispL.setText("0");
		}
	}
	
	public void setNum(String setNum) {
		if(dispL.getText().equals("0") && isZero) {
			dispL.setText("0");
		} else {
			isZero=true;
			buff.append(setNum);
			show = buff.toString();
			dispL.setText(show);
			isOperater=false;
			isDot++;
	
			if(cnt==0) {
				tmp += setNum+"";
			} else if(cnt>=1) {
				tmp2 += setNum+"";;
			}
		}
	}
	
	public void clearAll() {
		inputL.setText("0");
		dispL.setText("");
		buff.delete(0, buff.toString().length());
		cnt=0;
		result=0;
		resultFin="";
		tmp="";
		tmp2="";
		
		isOperater=false;
		isZero=false;
	}
	
	public void Operator(String oper) {
		if(dispL.getText().isEmpty()) {
			dispL.setText("");
		} else {
			if(isOperater==false) { //바로 앞에 연산자 없으면
				buff.append(oper);
				show = buff.toString();
				dispL.setText(show);
				isOperater = true;
				cnt++;
				operVal = oper;
			} else if(isOperater==true) { //바로 앞에 연산자 있으면
				dispL.setText(dispL.getText());
			}	
		}
	}
	
	public String Calc(String tmpnum, String tmpnum2, String operVal) {
		int num1int=0;
		int num2int=0;
		num1int = Integer.parseInt(tmpnum);
		num2int = Integer.parseInt(tmpnum2);
		
		System.out.println("num1int"+num1int);
		System.out.println("operVal : "+operVal);
		System.out.println("num2int"+num2int);
		
		switch(operVal) {
			case "+" : result = num1int+num2int; break;
			case "-" : result = num1int-num2int; break;
			case "*" : result = num1int*num2int; break;
			case "/" : result = num1int/num2int; break;
		}
		
		System.out.println("result"+result);
		return strResult = result+"";
	}
	
}
