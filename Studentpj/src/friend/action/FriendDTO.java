package friend.action;

public class FriendDTO {

	private int seq;
	private String name;
	private String tel1;
	private String tel2;
	private String tel3;
	private int gender;
	private int read; 
	private int movie;
	private int music;
	private int shopping;
	
	
	public int getSeq() {
		return seq;
	}
	public String getName() {
		return name;
	}
	public String getTel1() {
		return tel1;
	}
	public String getTel2() {
		return tel2;
	}
	public String getTel3() {
		return tel3;
	}
	public int getGender() {
		return gender;
	}
	public int getRead() {
		return read;
	}
	public int getMovie() {
		return movie;
	}
	public int getMusic() {
		return music;
	}
	public int getShopping() {
		return shopping;
	}
	
	public FriendDTO() {
	
	}
	
	public FriendDTO(int seq, String name, String tel1, String tel2, String tel3, int gender, int read, int movie,
			int music, int shopping) {
		this.seq = seq;
		this.name = name;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
		this.gender = gender;
		this.read = read;
		this.movie = movie;
		this.music = music;
		this.shopping = shopping;
	}
	
	
	
	
}
