package workout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class CalculatorMain1 extends JFrame implements ActionListener {
	private JLabel dispL, inputL;   
	private JButton[] button;   
	private StringBuffer dispBuf, inputBuf;
	private double result;
	private String op = "0";
	private double resultTmp;
	//result -- 처음에 들어온 값 또는 중간 결과
	/*
	 1.op에 연산자가 0이면 result에 값을 넣는다 					
	 2.연산자를 op에 넣는다
	 3.op에 0이 아니면 덧셈연산을 하여 결과를 result에 넣는다.
	 4.연산자를 op에 넣는다
	 
	 3번과 4번을 반복.
	  */
	  public CalculatorMain1() {
      setLayout(null);
      
      dispL = new JLabel("", JLabel.RIGHT);
      dispL.setBackground(Color.WHITE);
      dispL.setOpaque(true);
      dispL.setBounds(9,10,375,50);
      
      inputL = new JLabel("0", JLabel.RIGHT);
      inputL.setBackground(Color.WHITE);
      inputL.setOpaque(true);
      inputL.setBounds(9,70,375,50);
      
      String[] title = {"←","C",
    		            "7","8","9","/",
    		            "4","5","6","*",
    		            "1","2","3","-",
    		            ".","0","=","+"};
      
      button = new JButton[18];
      for(int i=0; i<button.length; i++) {
    	  button[i] = new JButton(title[i]);
      }
      dispBuf = new StringBuffer();
      inputBuf = new StringBuffer("0");
      
      button[0].setBounds(9,130,185,50);
      button[1].setBounds(199,130,185,50);
      
      button[2].setBounds(9,190,90,50);
      button[3].setBounds(104,190,90,50);
      button[4].setBounds(199,190,90,50);
      button[5].setBounds(294,190,90,50);
      
      button[6].setBounds(9,250,90,50);
      button[7].setBounds(104,250,90,50);
      button[8].setBounds(199,250,90,50);
      button[9].setBounds(294,250,90,50);
      
      button[10].setBounds(9,310,90,50);
      button[11].setBounds(104,310,90,50);
      button[12].setBounds(199,310,90,50);
      button[13].setBounds(294,310,90,50);
      
      button[14].setBounds(9,370,90,50);
      button[15].setBounds(104,370,90,50);
      button[16].setBounds(199,370,90,50);
      button[17].setBounds(294,370,90,50);
      
      add(dispL);
      add(inputL);
      for(int i=0; i<button.length; i++) {
    	  add(button[i]);
    	  button[i].addActionListener(this);
      }
      
      setTitle("계산기");
      setBounds(800,300,400,460);
      setResizable(false);
      setVisible(true);
   }
   
   @Override
   public void actionPerformed(ActionEvent e) {
	   String pushB = e.getActionCommand();
	   if(pushB=="1"||
		  pushB=="2"||
		  pushB=="3"||
		  pushB=="4"||
		  pushB=="5"||
		  pushB=="6"||
		  pushB=="7"||
		  pushB=="8"||
		  pushB=="9"||
		  pushB=="0") {
		   if(inputBuf.toString().equals("0")) {
			   inputBuf.delete(0,1);
		   }
		   inputBuf.append(pushB);
		   inputL.setText(inputBuf+"");
		   
		   System.out.println("inputBuf : "+inputBuf+"");
	   } else if (pushB=="←") {
		   inputBuf.delete(inputBuf.length()-1, inputBuf.length());
		   if(inputBuf.length()==0) {
			   inputBuf.append("0");
		   }
		   inputL.setText(inputBuf+"");
	   } else if(pushB=="C") {
		   dispBuf.delete(0, dispBuf.length());
		   inputBuf.delete(0, inputBuf.length());
		   inputBuf.append("0");
		   
		   dispL.setText("");
		   inputL.setText("0");
	   } else if(pushB==".") {
		   if(inputBuf.indexOf(".")==-1) {
			   inputBuf.append(".");
		   }
		   inputL.setText(inputBuf+"");
	   } else if(pushB=="+") {		
		   if(op.equals("0")) {								
			   result += Double.parseDouble(inputBuf+""); //5	
			   dispBuf.append(inputBuf.toString()+"+");
			   op = "+";
			   dispL.setText(dispBuf.toString());
			   inputL.setText(inputBuf.toString());
			   inputBuf.delete(0, inputBuf.length());
			   inputBuf.append(0);
		   } else {
			   result += Double.parseDouble(inputBuf+""); //4
			   dispBuf.append(inputBuf.toString()+"+");
			   dispL.setText(dispBuf.toString());
			   inputL.setText(result+"");
			   inputBuf.delete(0, inputBuf.length());
			   inputBuf.append(0);
			   op = "+";
		   }
	   } else if(pushB=="-") {		
		   if(op.equals("0")) {								
			   result -= Double.parseDouble(inputBuf+""); //5	
			   dispBuf.append(inputBuf.toString()+"-");
			   op = "-";
			   dispL.setText(dispBuf.toString());
			   inputL.setText(inputBuf.toString());
			   inputBuf.delete(0, inputBuf.length());
			   inputBuf.append(0);
		   } else {
			   result -= Double.parseDouble(inputBuf+""); //4
			   dispBuf.append(inputBuf.toString()+"-");
			   dispL.setText(dispBuf.toString());
			   inputL.setText(result+"");
			   inputBuf.delete(0, inputBuf.length());
			   inputBuf.append(0);
			   op = "-";
		   }
	   } else if(pushB=="*") {		
		   if(op.equals("0")) {								
			   result *= Double.parseDouble(inputBuf+""); //5	
			   dispBuf.append(inputBuf.toString()+"*");
			   op = "*";
			   dispL.setText(dispBuf.toString());
			   inputL.setText(inputBuf.toString());
			   inputBuf.delete(0, inputBuf.length());
			   inputBuf.append(0);
		   } else {
			   result *= Double.parseDouble(inputBuf+""); //4
			   dispBuf.append(inputBuf.toString()+"*");
			   dispL.setText(dispBuf.toString());
			   inputL.setText(result+"");
			   inputBuf.delete(0, inputBuf.length());
			   inputBuf.append(0);
			   op = "*";
		   }
	   } else if(pushB=="/") {		
		   if(op.equals("0")) {								
			   result /= Double.parseDouble(inputBuf+""); //5	
			   dispBuf.append(inputBuf.toString()+"/");
			   op = "/";
			   dispL.setText(dispBuf.toString());
			   inputL.setText(inputBuf.toString());
			   inputBuf.delete(0, inputBuf.length());
			   inputBuf.append(0);
		   } else {
			   result /= Double.parseDouble(inputBuf+""); //4
			   dispBuf.append(inputBuf.toString()+"/");
			   dispL.setText(dispBuf.toString());
			   inputL.setText(result+"");
			   inputBuf.delete(0, inputBuf.length());
			   inputBuf.append(0);
			   op = "/";
		   }
	   }
   }

   public static void main(String[] args) {
      new CalculatorMain1();
   }
}