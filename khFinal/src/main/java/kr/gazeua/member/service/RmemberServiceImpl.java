package kr.gazeua.member.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.gazeua.member.dao.RmemberMapper;
import kr.gazeua.member.domain.RmemberCommand;

@Service("rmemberService")
public class RmemberServiceImpl implements RmemberService{

	@Resource
	private RmemberMapper rmemberMapper;
	
	@Override
	public void insert(RmemberCommand rmemberCommand) {
		
		rmemberMapper.insert(rmemberCommand);
		rmemberMapper.insertDmember(rmemberCommand);

	}

	@Override
	public void update(RmemberCommand rmemberCommand) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

}
