package kr.gazeua.member.service;

import org.springframework.transaction.annotation.Transactional;

import kr.gazeua.member.domain.RmemberCommand;

@Transactional
public interface RmemberService {

	public void insert(RmemberCommand rmember);
	public void update(RmemberCommand rmember);
	public void delete(String id);
}
