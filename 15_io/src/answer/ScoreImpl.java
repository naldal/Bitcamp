package answer;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ScoreImpl implements Score {
	private ArrayList<ScoreDTO> list;

	public ScoreImpl() {
		list = new ArrayList<ScoreDTO>();
	}

	public static void main(String[] args) {
		new ScoreForm_1();
		new ScoreImpl();

	}

	@Override
	public void input(ScoreDTO dto) {
		list.add(dto);
	}

	@Override
	public void print(JTextArea output) {
		output.setText("");
		for (ScoreDTO dto : list) {
			output.append(dto.toString() + "\n");
		}
	}

	@Override
	public void search(JTextArea output) {
		String hak = JOptionPane.showInputDialog(null, "학번을 입력하세요");
		if (hak == null || hak.equals(""))
			return;

		output.setText("");
		int sw = 0;
		for (ScoreDTO dto : list) {
			if (hak.equals(dto.getHak())) {
				if (sw == 0) {
					output.setText("");
				}
				output.append(dto.toString()+"\t");
				sw=1;
			}
		} // for
		if(sw==0)
			JOptionPane.showMessageDialog(null, "찾고자 하는 학번이 없습니다.");
	}

	@Override
	public void tot_desc() {
		Comparator<ScoreDTO> com = new Comparator<ScoreDTO>() {
			
			@Override
			public int compare(ScoreDTO dto1, ScoreDTO dto2) {
				return dto1.getTot() < dto2.getTot() ? 1: -1;
			}
		};
			
		Collections.sort(list, com);
	}


	@Override
	public void save() {
		// 저장 다이얼로그
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null);
		File file = null;

		if (result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}

		if (file == null)
			return;

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));

			for (ScoreDTO dto : list) {
				oos.writeObject(dto);
			}

			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void load() {
		// 열기 다이얼로그
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null);
		File file = null;

		if (result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}

		if (file == null)
			return;

		list.clear(); // 초기화
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

			while (true) {
				try {
					ScoreDTO dto = (ScoreDTO) ois.readObject();
					list.add(dto);
				} catch (EOFException e) {
					break;
				}
			}
			ois.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
