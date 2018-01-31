package kr.gazeua.member.dao;

import org.apache.ibatis.annotations.Insert;

import kr.gazeua.member.domain.RmemberCommand;

public interface RmemberMapper {
	
	@Insert("INSERT INTO dmember(id) VALUES(#{id})")
	public void insertDmember(RmemberCommand rmemberCommand);
	
	@Insert("INSERT INTO rider(id,pw,name,phone,licencenumber,preferloc,regdate) VALUES(#{id},#{pw},#{name},#{phone},#{licencenumber},#{preferloc},sysdate)")
	public void insert(RmemberCommand rmemberCommand);
	
	public void update(RmemberCommand rmemberCommand);
	
	public void delete(String id);

}
