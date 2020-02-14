package friend.action;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import friend.bean.FriendDTO;
import friend.dao.FriendDAO;

public class FriendManager extends JFrame implements ActionListener, ListSelectionListener {
	private JLabel nameL, phoneL, sexL, hobbyL, input, d1, d2;
	private JTextField nameT, phone1, phone2;
	private JComboBox phoneC;
	private JRadioButton male, female;
	private JCheckBox read, movie, music, game, shopping;
	private JButton enroll, modify, delete, erase;
	private JLabel infoL, listL, areaL;
	private JTextArea area;
	private JList<FriendDTO> list; // list view
	private DefaultListModel<FriendDTO> model; // list model
	private ButtonGroup group;

//	private FriendDTO dto;
//	private FriendDAO dao;

	public FriendManager() {

//		dto = new FriendDTO();
//		dao = new FriendDAO();

		input = new JLabel("���������Է�");
		input.setHorizontalAlignment(JLabel.CENTER);
		input.setBackground(new Color(230, 190, 230));
		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1.setBackground(new Color(230, 190, 230));
		nameL = new JLabel("��        ��:");
		nameT = new JTextField(7);

		p1.add(nameL);
		p1.add(nameT);

		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p2.setBackground(new Color(230, 190, 230));
		phoneL = new JLabel("��ȭ��ȣ:");
		String num[] = { "010", "011", "016", "017", "018", "019" };
		phoneC = new JComboBox<String>(num);
		d1 = new JLabel("-");
		phone1 = new JTextField(4);
		d2 = new JLabel("-");
		phone2 = new JTextField(4);
		p2.add(phoneL);
		p2.add(phoneC);
		p2.add(d1);
		p2.add(phone1);
		p2.add(d2);
		p2.add(phone2);

		JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p3.setBackground(new Color(230, 190, 230));
		sexL = new JLabel("��         ��:");
		male = new JRadioButton("����", true);
		male.setBackground(new Color(230, 190, 230));
		female = new JRadioButton("����");
		female.setBackground(new Color(230, 190, 230));
		group = new ButtonGroup();
		group.add(male);
		group.add(female);
		p3.add(sexL);
		p3.add(male);
		p3.add(female);

		JPanel p4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p4.setBackground(new Color(230, 190, 230));
		hobbyL = new JLabel("��         ��:");
		hobbyL.setBackground(new Color(230, 190, 230));
		read = new JCheckBox("����");
		read.setBackground(new Color(230, 190, 230));
		movie = new JCheckBox("��ȭ");
		movie.setBackground(new Color(230, 190, 230));
		music = new JCheckBox("����");
		music.setBackground(new Color(230, 190, 230));
		game = new JCheckBox("����");
		game.setBackground(new Color(230, 190, 230));
		shopping = new JCheckBox("����");
		shopping.setBackground(new Color(230, 190, 230));
		p4.add(hobbyL);
		p4.add(read);
		p4.add(movie);
		p4.add(music);
		p4.add(game);
		p4.add(shopping);

		JPanel p5 = new JPanel();
		p5.setBackground(new Color(230, 190, 230));
		enroll = new JButton("���");
		modify = new JButton("����");
		modify.setEnabled(false);
		delete = new JButton("����");
		delete.setEnabled(false);
		erase = new JButton("�����");
		erase.setEnabled(false);
		p5.add(enroll);
		p5.add(modify);
		p5.add(delete);
		p5.add(erase);

		JPanel p = new JPanel(new GridLayout(6, 1, 4, 4));
		p.setBackground(new Color(230, 190, 230));
		p.add(input);
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
		p.add(p5);

		JPanel center = new JPanel(new BorderLayout());
		center.setBackground(new Color(230, 190, 230));
		center.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		listL = new JLabel("��ü���");
		listL.setHorizontalAlignment(JLabel.CENTER);

		list = new JList(new DefaultListModel<FriendDTO>());
		model = (DefaultListModel<FriendDTO>) list.getModel();
		JScrollPane scroll = new JScrollPane(list);

		center.add("North", listL);
		center.add("Center", scroll);

		JPanel down = new JPanel(new BorderLayout());
		down.setBackground(new Color(230, 190, 230));
		down.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		infoL = new JLabel("���������м�");
		infoL.setHorizontalAlignment(JLabel.CENTER);
		area = new JTextArea(7, 80);

		down.add("North", infoL);
		down.add("Center", area);

		Container con = this.getContentPane();
		con.setBackground(new Color(230, 230, 190));
		con.setLayout(new BorderLayout());

		con.add("West", p);
		con.add("Center", center);
		con.add("South", down);

		setBounds(300, 300, 550, 500);
		setVisible(true);
		setBackground(new Color(230, 190, 230));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// DB�� �ִ� ��� ���ڵ带 ������ JList�� �Ѹ���
		FriendDAO friendDAO = FriendDAO.getInstance();
		List<FriendDTO> list2 = friendDAO.getFriendList();

		for (FriendDTO friendDTO : list2) {
			model.addElement(friendDTO);
		}

	}

	public void event() {

		enroll.addActionListener(this);// ���
		modify.addActionListener(this);// ����
		delete.addActionListener(this);// ����
		erase.addActionListener(this);// �����

		list.addListSelectionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == enroll) {
			// ������
			String name = nameT.getText();
			String tel1 = phoneC.getSelectedItem().toString();
			String tel2 = phone1.getText();
			String tel3 = phone2.getText();

			int gender = 0;
			if (male.isSelected())
				gender = 0;
			else if (female.isSelected())
				gender = 1;

//			int read = 0;
//			if(book.isSelected()) read=1;
//			else read=0;
//			���� ���ǽ��� ���̸�

			int read = this.read.isSelected() ? 1 : 0;
			int movie = this.movie.isSelected() ? 1 : 0;
			int music = this.music.isSelected() ? 1 : 0;
			int game = this.game.isSelected() ? 1 : 0;
			int shopping = this.shopping.isSelected() ? 1 : 0;

			// FriendDTO - 1�κ�
			FriendDTO friendDTO = new FriendDTO();
			friendDTO.setName(name);
			friendDTO.setTel1(tel1);
			friendDTO.setTel2(tel2);
			friendDTO.setTel3(tel3);
			friendDTO.setGender(gender);
			friendDTO.setRead(read);
			friendDTO.setMovie(movie);
			friendDTO.setMusic(music);
			friendDTO.setGame(game);
			friendDTO.setShopping(shopping);

//			//DB - FriendDAO
			FriendDAO friendDAO = FriendDAO.getInstance(); // �̱���

			int seq = friendDAO.getSeq();
			friendDTO.setSeq(seq);

			friendDAO.insertArticle(friendDTO);

			// ���
			clear();

			area.setText("\n\t�����͸� ����Ͽ����ϴ�.");
			model.addElement(friendDTO);

		} else if (e.getSource() == modify) {
			
			//������ ������
			int seq = list.getSelectedValue().getSeq();
			
			String name = nameT.getText();
			String tel1 = phoneC.getSelectedItem().toString();
			String tel2 = phone1.getText();
			String tel3 = phone2.getText();

			int gender = 0;
			if (male.isSelected())
				gender = 0;
			else if (female.isSelected())
				gender = 1;

			int read = this.read.isSelected() ? 1 : 0;
			int movie = this.movie.isSelected() ? 1 : 0;
			int music = this.music.isSelected() ? 1 : 0;
			int game = this.game.isSelected() ? 1 : 0;
			int shopping = this.shopping.isSelected() ? 1 : 0;
			
			FriendDTO friendDTO = new FriendDTO();
			friendDTO.setSeq(seq);
			friendDTO.setName(name);
			friendDTO.setTel1(tel1);
			friendDTO.setTel2(tel2);
			friendDTO.setTel3(tel3);
			friendDTO.setGender(gender);
			friendDTO.setRead(read);
			friendDTO.setMovie(movie);
			friendDTO.setMusic(music);
			friendDTO.setGame(game);
			friendDTO.setShopping(shopping);
			
			//DB ������Ʈ
			FriendDAO friendDAO = FriendDAO.getInstance(); // �̱���

			friendDAO.updateArticle(friendDTO);
			
			
			
			//��� �Ѹ���
			clear();
			area.setText("\n\t�����͸� �����Ͽ����ϴ�.");
			
			model.set(list.getSelectedIndex(), friendDTO);
			
//			FriendDTO friendDTO = list.getSelectedValue();
//			
//			friendDTO.setName(nameT.getText());
//			friendDTO.setTel1(phoneC.getSelectedItem().toString());
//			friendDTO.setTel2(phone1.getText());
//			friendDTO.setTel3(phone2.getText());
//			if (male.isSelected())
//				friendDTO.setGender(0);
//			else
//				friendDTO.setGender(1);
//			friendDTO.setRead(read.isSelected() ? 1 : 0);
//			friendDTO.setMovie(movie.isSelected() ? 1 : 0);
//			friendDTO.setMusic(music.isSelected() ? 1 : 0);
//			friendDTO.setGame(game.isSelected() ? 1 : 0);
//			friendDTO.setShopping(shopping.isSelected() ? 1 : 0);

//			model.clear();
//			
//			List<FriendDTO> list2 = friendDAO.getFriendList();
//			for (FriendDTO dto : list2) {
//				model.addElement(dto);
//			}

		} else if (e.getSource() == delete) {
			
			int seq = list.getSelectedValue().getSeq();
			
			FriendDAO friendDAO = FriendDAO.getInstance();
			friendDAO.deleteArticle(seq);
			
			clear();
			area.setText("\n\t�����͸� �����߽��ϴ�.");
			model.remove(list.getSelectedIndex());
			
//			model.clear();
//
//			List<FriendDTO> list2 = friendDAO.getFriendList();
//			for (FriendDTO dto : list2) {
//				model.addElement(dto);
//			}
			
		} else if (e.getSource() == erase) {
			
			clear();
			
		}
	}

	private void clear() {
		nameT.setText("");
		phoneC.setSelectedItem("010");
		phone1.setText("");
		phone2.setText("");
		male.setSelected(true);
		read.setSelected(false);
		movie.setSelected(false);
		music.setSelected(false);
		game.setSelected(false);
		shopping.setSelected(false);
		area.setText("");
		
		enroll.setEnabled(true);
		modify.setEnabled(false);
		delete.setEnabled(false);
		erase.setEnabled(false);

	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {

		if (list.getSelectedIndex() == -1) return;

		FriendDTO friendDTO = list.getSelectedValue();
		nameT.setText(friendDTO.getName());
		phoneC.setSelectedItem(friendDTO.getTel1());
		phone1.setText(friendDTO.getTel2());
		phone2.setText(friendDTO.getTel3());
		if (friendDTO.getGender()==0)
			male.setSelected(true);
		else if (friendDTO.getGame()==1)
			female.setSelected(true);
		read.setSelected(friendDTO.getRead()==1); //�Ʒ��� ���� ��
//		read.setSelected(friendDTO.getRead() == 1 ? true : false); 
		movie.setSelected(friendDTO.getMovie() == 1 ? true : false);
		music.setSelected(friendDTO.getMusic() == 1 ? true : false);
		game.setSelected(friendDTO.getGame() == 1 ? true : false);
		shopping.setSelected(friendDTO.getShopping() == 1 ? true : false);
		
		area.setText("");

		enroll.setEnabled(false);
		modify.setEnabled(true);
		delete.setEnabled(true);
		erase.setEnabled(true);

	}

	public static void main(String[] args) {
		new FriendManager().event();
	}

}
