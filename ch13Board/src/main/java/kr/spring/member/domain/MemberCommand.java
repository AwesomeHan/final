package kr.spring.member.domain;

import java.sql.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class MemberCommand {
	@NotEmpty //not null check
	private String id;
	private int auth; //0 Ż��, 1 �Ϲ�, 2 ������
	@NotEmpty
	private String name;
	@Size(min=4,max=10) //�ּ� 4�ڿ��� �ִ� 10�ڱ���
	private String passwd;
	@NotEmpty
	private String phone;
	@Email
	@NotEmpty
	private String email;
	@NotEmpty
	private String zipcode;
	@NotEmpty
	private String address1;
	private String address2;
	private Date reg_date;
	
	//��� ��ġ���� üũ
	public boolean isCheckedPasswd(String userPasswd) {
		if(auth >0 && passwd.equals(userPasswd)) {
			return true;
		}
		return false;		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public Date getReg_date() {
		return reg_date;
	}
	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	@Override
	public String toString() {
		return "MemberCommand [id=" + id + ", auth=" + auth + ", name=" + name + ", passwd=" + passwd + ", phone="
				+ phone + ", email=" + email + ", zipcode=" + zipcode + ", address1=" + address1 + ", address2="
				+ address2 + ", reg_date=" + reg_date + "]";
	}
	
}
