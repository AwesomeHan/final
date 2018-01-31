package kr.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter{
	private Logger log = Logger.getLogger(this.getClass());

	//postHandle() : 요청을 낚아채서 Controller의 메서드 동작 이후에 작동함.
	
	//preHandle() : 요청을 낚아채서 Controller의 메서드 동작 이전에 작동함.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(log.isDebugEnabled()) {
			log.debug("<<LoginCheck>> : LoginCheckInterceptor 진입");
		}
		
		HttpSession session = request.getSession();
		if(session.getAttribute("user_id")==null) {
			if(log.isDebugEnabled()) {
				log.debug("<<LoginCheck>> : 로그인 되지 않음.");
			}

			response.sendRedirect(request.getContextPath()+"/member/login.do");
			return false;
		}
		
		if(log.isDebugEnabled()) {
			log.debug("<<LoginCheck>> : 로그인 됨.");
		}

		
		return true;
	}
	
	
}
