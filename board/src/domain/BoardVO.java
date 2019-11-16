package domain;

import java.util.Date;

public class BoardVO {
	private int bno;
    private String name;
    private String password;       
    private String title;
    private String content;
    private String attach;
    private int re_ref;
    private int re_lev;
    private int re_seq;
    private int readcount;
    private Date regdate;
	
    public BoardVO() {
		super();
	}

	public BoardVO(int bno, String name, String password, String title, String content, String attach, int re_ref,
			int re_lev, int re_seq, int readcount, Date regdate) {
		super();
		this.bno = bno;
		this.name = name;
		this.password = password;
		this.title = title;
		this.content = content;
		this.attach = attach;
		this.re_ref = re_ref;
		this.re_lev = re_lev;
		this.re_seq = re_seq;
		this.readcount = readcount;
		this.regdate = regdate;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public int getRe_ref() {
		return re_ref;
	}

	public void setRe_ref(int re_ref) {
		this.re_ref = re_ref;
	}

	public int getRe_lev() {
		return re_lev;
	}

	public void setRe_lev(int re_lev) {
		this.re_lev = re_lev;
	}

	public int getRe_seq() {
		return re_seq;
	}

	public void setRe_seq(int re_seq) {
		this.re_seq = re_seq;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", name=" + name + ", password=" + password + ", title=" + title + ", content="
				+ content + ", attach=" + attach + ", re_ref=" + re_ref + ", re_lev=" + re_lev + ", re_seq=" + re_seq
				+ ", readcount=" + readcount + ", regdate=" + regdate + "]";
	}
    
    
    
}
