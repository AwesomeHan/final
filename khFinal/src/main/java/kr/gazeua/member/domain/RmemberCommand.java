package kr.gazeua.member.domain;

import java.sql.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class RmemberCommand {

	@NotEmpty(message="아이디를 입력하세요")
	private String id;
	@NotEmpty(message="비밀번호를 입력하세요")
	private String pw;
	@NotEmpty(message="이름을 입력하세요")
	private String name;
	@NotEmpty(message="연락처를 입력하세요")
	private String phone;
	@Size(min=13,max=14)
	@NotEmpty(message="면허증을 입력하세요")
	private int licencenumber;
	@NotEmpty(message="선호 구역을 입력하세요")
	private String preferloc;
	@NotEmpty
	private Date regdate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getLicencenumber() {
		return licencenumber;
	}
	public void setLicencenumber(int licencenumber) {
		this.licencenumber = licencenumber;
	}
	public String getPreferloc() {
		return preferloc;
	}
	public void setPreferloc(String preferloc) {
		this.preferloc = preferloc;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "RmemberCommand [id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", licencenumber="
				+ licencenumber + ", preferloc=" + preferloc + ", regdate=" + regdate + "]";
	}
	
	
}
