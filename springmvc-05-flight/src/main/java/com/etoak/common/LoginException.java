package com.etoak.common;

// 自定义登录异常
public class LoginException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public LoginException() {
		this("登录异常");
	}
	
	public LoginException(String message) {
		super(message);
	}
}
