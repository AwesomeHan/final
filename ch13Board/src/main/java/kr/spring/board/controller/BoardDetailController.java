package kr.spring.board.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.spring.board.domain.BoardCommand;
import kr.spring.board.service.BoardService;

@Controller
public class BoardDetailController {
private Logger log = Logger.getLogger(this.getClass());
	
	@Resource
	private BoardService boardService;
	
	@RequestMapping("/board/detail.do")
	public ModelAndView process(@RequestParam("num") int num) {
		if(log.isDebugEnabled()) {
			log.debug("<<num>> : "+num);
		}
		
		boardService.updateHit(num);
		
		BoardCommand board= boardService.selectBoard(num);
		return new ModelAndView("boardView","board",board);
	}
	//파일 다운로드
	@RequestMapping("/board/file.do")
	public ModelAndView download(@RequestParam("num") int num) {
		BoardCommand board = boardService.selectBoard(num);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("downloadView");
		mav.addObject("downloadFile",board.getUploadfile());
		mav.addObject("filename",board.getFilename());
		
		return mav;
	}
	
	//이미지 출력
	@RequestMapping("/board/imageView.do")
	public ModelAndView viewImg(@RequestParam("num") int num) {
		BoardCommand board = boardService.selectBoard(num);
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("imageView");
		mav.addObject("imageFile",board.getUploadfile());
		mav.addObject("filename",board.getFilename());
		
		return mav;
	}
	
	
}
