package kr.spring.member.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.spring.member.domain.MemberCommand;
import kr.spring.member.service.MemberService;

@Controller
public class MemberDeleteController {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private MemberService memberService;
	
	@RequestMapping(value="/member/delete.do", method=RequestMethod.GET)
	public String form(HttpSession session,Model model) {
		String id = (String)session.getAttribute("user_id");
		MemberCommand member = memberService.selectMember(id);
		
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : "+member);
		}
		
		model.addAttribute("command",member);

		return "memberDelete";
	}
	
	@RequestMapping(value="/member/delete.do", method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid MemberCommand memberCommand,
			BindingResult result, HttpSession session) {
		
		if(log.isDebugEnabled()) {
			log.debug("<<memberCommand>> : "+memberCommand);
		}
		
		if(result.hasFieldErrors("passwd")) {
			return "memberDelete";
		}
		
		try {
			MemberCommand member = memberService.selectMember(memberCommand.getId());
			boolean check = false;
			if(member!=null) {
				check = member.isCheckedPasswd(memberCommand.getPasswd());
			}
			if(check) {
				memberService.delete(memberCommand.getId());
				session.invalidate();
				return "redirect:/main/main.do";
						
			}else {
				throw new Exception();
			}
			
		}catch(Exception e) {
			result.rejectValue("passwd", "invalidPassword");
			return "memberDelete";
		}
		
		
		
	}
}
