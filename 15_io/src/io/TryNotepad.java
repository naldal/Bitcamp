package io;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.zip.InflaterInputStream;

import javax.management.openmbean.OpenDataException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TryNotepad extends JFrame implements ActionListener {

	private JTextArea area;
	private JScrollPane scroll;
	private MenuPane menu;
	private File file = null;

	public TryNotepad() {
		area = new JTextArea();
		scroll = new JScrollPane(area);
		area.setFont(new Font("고딕체", Font.BOLD, 20));

		menu = new MenuPane();
		this.setJMenuBar(menu);

		Container c = this.getContentPane();
		c.add(scroll);

		setBounds(1100, 200, 600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("간단메모장");
		setVisible(true);
		setResizable(false);

	}

	public void event() {
		menu.getNewM().addActionListener(this);
		menu.getExitM().addActionListener(this);
		menu.getSaveM().addActionListener(this);
		menu.getCopyM().addActionListener(this);
		menu.getPasteM().addActionListener(this);
		menu.getCutM().addActionListener(this);
		menu.getOpenM().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == menu.getNewM()) {
			area.setText("");
		} else if (e.getSource() == menu.getExitM()) {
			// System.exit(0);
			int result = JOptionPane.showConfirmDialog(this, "저장하시겠습니까?", "메모장", JOptionPane.YES_NO_CANCEL_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				// 파일저장 후 종료

				System.exit(0);
			} else if (result == JOptionPane.NO_OPTION) {
				// 저장안하고 종료
				System.exit(0);
			}
		} else if (e.getSource() == menu.getOpenM()) {
			// 열기 다이얼로그 openDialog()
			// 파일 읽기 fileRead()
			openDialog();
			fileRead();

		} else if (e.getSource() == menu.getCutM()) {
			area.cut();
		} else if (e.getSource() == menu.getCopyM()) {
			area.copy();
		} else if (e.getSource() == menu.getSaveM()) {

		} else if (e.getSource() == menu.getPasteM()) {
			area.paste();
		}
	}

	public void openDialog() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			// 선택한 경로와 파일명 얻기
			file = chooser.getSelectedFile();
		} else if (result == JFileChooser.CANCEL_OPTION) {

		}
		JOptionPane.showMessageDialog(this, file);
	}

	public void fileRead() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				area.append(line+"\n");
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TryNotepad().event();
	}

}