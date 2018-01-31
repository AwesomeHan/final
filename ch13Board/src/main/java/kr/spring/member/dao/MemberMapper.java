package kr.spring.member.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kr.spring.member.domain.MemberCommand;

public interface MemberMapper {
	@Insert("INSERT INTO spmember(id) VALUES(#{id})")
	public void insert(MemberCommand member);
	@Insert("INSERT INTO spmember_detail (id,name,passwd,phone,email,zipcode, address1, address2,reg_date) VALUES(#{id},#{name},#{passwd},#{phone},#{email},#{zipcode},#{address1},#{address2},sysdate)")
	public void insertDetail(MemberCommand member);
	//A left outer join B : 조인할 경우 A의 누락된 것을 표시 B부분은 null로 처리
	@Select("SELECT * FROM spmember m left outer join spmember_detail d on m.id = d.id WHERE m.id=#{id}")
	public MemberCommand selectMember(String id);
	@Update("UPDATE spmember_detail SET name=#{name}, passwd=#{passwd}, phone=#{phone}, email=#{email}, zipcode=#{zipcode}, address1=#{address1}, address2=#{address2} WHERE id=#{id}")
	public void update(MemberCommand member);
	@Update("UPDATE spmember SET auth=0 WHERE id=#{id}")
	public void delete(String id);
	//상세 내역 삭제
	@Delete("DELETE FROM spmember_detail WHERE id=#{id}")
	public void	deleteDetail(String id);
}
