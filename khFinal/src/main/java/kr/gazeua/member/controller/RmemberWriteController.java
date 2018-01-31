package kr.gazeua.member.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.gazeua.member.domain.RmemberCommand;
import kr.gazeua.member.service.RmemberService;


@Controller
public class RmemberWriteController {
	
	@Resource
	private RmemberService rmemberService;
	
	@RequestMapping(value="/member/rwrite.do", method=RequestMethod.GET)
	public String form() {
		return "rmemberWrite";
	}
	@RequestMapping(value="/member/rwrite.do",method=RequestMethod.POST)
	public String submit(@ModelAttribute("command") @Valid RmemberCommand rmemberCommand,BindingResult result) {
		
		rmemberService.insert(rmemberCommand);
		
		return "redirect:/main/main.do";
	}

}
