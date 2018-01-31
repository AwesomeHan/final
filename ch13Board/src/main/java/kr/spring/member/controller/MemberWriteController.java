package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class MemberWriteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	//Command 객체 초기화
	@ModelAttribute("command")
	public MemberCommand initCommand() {
		return new MemberCommand();
	}
	
	@RequestMapping(value="/member/write.do", method=RequestMethod.GET)
	public String form() {
		
		//tiles를 사용하고 있으니깐 .jsp가 아니라 설정 값을 의미한다. xml에서 확인가능하다.
		return "memberWrite";
	}
	
	@RequestMapping(value="/member/write.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid MemberCommand memberCommand,BindingResult result) {
		/*@Valid 하면 유효성 체크 결과를 BindingResult의 instance에 넣어줌*/
		
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : "+memberCommand);
		}
		
		if(result.hasErrors()) {
			return form();
		}
		
		//회원 가입
		memberService.insert(memberCommand);
		
		return "redirect:/main/main.do";
	}
	
}
