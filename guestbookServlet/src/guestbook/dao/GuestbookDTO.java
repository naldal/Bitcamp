package guestbook.dao;


public class GuestbookDTO {

	private int seq;
	private String name;
	private String eamil;
	private String homepage;
	private String subject;
	private String content;
	private String logtime;
	
	public GuestbookDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public GuestbookDTO(int seq, String name, String eamil, String homepage, String subject, String content, String date) {
		this.seq = seq;
		this.name = name;
		this.eamil = eamil;
		this.homepage = homepage;
		this.subject = subject;
		this.content = content;
		this.logtime = date;
	}
	
	public GuestbookDTO(String name, String email, String homepage, String subject, String content) {
		this.name = name;
		this.eamil = email;
		this.homepage = homepage;
		this.subject = subject;
		this.content = content;
	}

	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEamil() {
		return eamil;
	}
	public void setEamil(String eamil) {
		this.eamil = eamil;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLogtime() {
		return logtime;
	}
	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}
	
}
