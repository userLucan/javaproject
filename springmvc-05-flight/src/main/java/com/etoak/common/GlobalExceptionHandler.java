package com.etoak.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//在所有被@Controller注解的类的方法加切面,如果异常抛出,则被其拦截
@ControllerAdvice 
public class GlobalExceptionHandler {
	
	@ExceptionHandler(LoginException.class) // 指定具体拦截的异常
	public  ModelAndView handlerLoginException(LoginException e) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("error", e.getMessage());
		mv.setViewName("login");
		return mv;
	}
}