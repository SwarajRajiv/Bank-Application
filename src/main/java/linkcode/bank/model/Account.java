package linkcode.bank.model;

public class Account {

	private int accno;
	private String cname;
	private String uname;
	private String pass;
	private int accBall;
	public Account() {
		super();
		this.accno = accno;
		this.cname = cname;
		this.uname = uname;
		this.pass = pass;
		this.accBall = accBall;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getAccBall() {
		return accBall;
	}
	public void setAccBall(int accBall) {
		this.accBall = accBall;
	}
	
}
