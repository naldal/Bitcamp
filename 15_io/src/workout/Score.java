package workout;

import javax.swing.JTextArea;

public interface Score {

	public void input(ScoreDTO dto);
	public void print (JTextArea output);
	public void search(JTextArea output, String result);
	public void tot_desc();
	public void save(JTextArea area);
	public void load(JTextArea area);
}
