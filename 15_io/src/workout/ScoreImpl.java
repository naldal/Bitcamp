package workout;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class ScoreImpl implements Score {
	ScoreDTO dto = new ScoreDTO();
	File file;
	ArrayList<ScoreDTO> arr = new ArrayList<ScoreDTO>();

	@Override
	public void input(ScoreDTO dto) {
		System.out.println("등록완료");
		arr.add(dto);
	}

	@Override
	public void print(JTextArea output) {
		for (int i = 0; i < arr.size(); i++) {
			output.append(arr.get(i).getHak() + "      " + arr.get(i).getName() + "      " + arr.get(i).getKor()
					+ "      " + arr.get(i).getEng() + "      " + arr.get(i).getMath() + "\n");

		}
	}

	@Override
	public void search(JTextArea output, String result) {
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getHak() == result) {
				output.setText("");
				output.append(arr.get(i).getHak() + "      " + arr.get(i).getName() + "      " + arr.get(i).getKor()
						+ "      " + arr.get(i).getEng() + "      " + arr.get(i).getMath());
			}
		}
	}

	@Override
	public void tot_desc() {
		Collections.sort(arr);
		System.out.println("정렬되었습니다.");
	}

	@Override
	public void save(JTextArea area) {
		int cnt = 0;
		file = new File(cnt + "번째 파일.txt");
		cnt++;
		DataOutputStream dos;

		try {
			dos = new DataOutputStream(new FileOutputStream(file));
			dos.writeUTF(area.getText());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void load(JTextArea area) {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(new JFrame());

		if (result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
		}
		JOptionPane.showMessageDialog(new JFrame(), file);

		area.setText("");
		if (file == null)
			return;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String line;
			while ((line = br.readLine()) != null) {
				area.append(line + "\n");
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
