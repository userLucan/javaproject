package com.etoak.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.etoak.bean.User;
import com.etoak.common.LoginException;
import com.etoak.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/to_login")
	public String toLogin(){
		return "login";
	}
	@RequestMapping("/login")
	public String login(
		@RequestParam String name, 
		@RequestParam String password,
		@RequestParam String code,
		HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String verifyCode = String.valueOf(session.getAttribute("verifyCode"));
		log.info("前端传入的code:{}",code);
		log.info("session中的code:{}",verifyCode);
		
		// 先判断验证码
		if(!code.equals(verifyCode)) {
			throw new LoginException("验证码错误");
		}
		
		password = DigestUtils.md5Hex(password);
		User user = userService.queryUser(name, password);
		
		if(user == null) {
			throw new LoginException("用户名或者密码错误");
		}
		user.setPassword("");
		session.setAttribute("user", user);
		return "redirect:/";
	}

}
