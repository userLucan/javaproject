package com.etoak.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.etoak.bean.User;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user==null){
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath+"/user/to_login");
			return false;
		}
		return true;
	}
}
