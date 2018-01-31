package kr.spring.board.domain;

import java.io.IOException;
import java.sql.Date;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class BoardCommand {
	private int num;
	@NotEmpty
	private String title;
	@NotEmpty
	private String content;
	private int hit;
	private Date regdate;
	private MultipartFile upload;
	//mybatis는 MultipartFile을 blob 파일로 바로 못바꿔서
	//MultipartFile을 byte 배열로 변환시킨후 작업
	private byte[] uploadfile;
	private String filename;
	private String ip;
	@NotEmpty
	private String id;
	
	
	public void setUpload(MultipartFile upload) throws IOException{
		this.upload = upload;
		
		//mybatis가 byte[] 만 인정함.
		//MultipartFile -> byte[]
		setUploadfile(upload.getBytes());
		//파일명 세팅
		setFilename(upload.getOriginalFilename());
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	
	public byte[] getUploadfile() {
		return uploadfile;
	}
	public void setUploadfile(byte[] uploadfile) {
		this.uploadfile = uploadfile;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	//byte 배열 타입 변수인 uploadfile은 데이터 양이 많아 출력시 느려지는 문제가 생긴다.그래서 toString에서 배제함.
	@Override
	public String toString() {
		return "BoardCommand [num=" + num + ", title=" + title + ", content=" + content + ", hit=" + hit + ", regdate="
				+ regdate + ", upload=" + upload + ", filename=" + filename + ", id=" + id + ", ip=" + ip + "]";
	}
	
	
}
