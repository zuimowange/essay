package com.wgg.essay.po;

public class Token {
	private Integer userId;
	private String iat;//token生成时间
	private String exp;//token生命周期，到期时间
	private String loginModeId;//登录方式ID
	private String loginMode;//登录方式
	private String openId;//openId
	
	
	
	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Token(Integer userId, String iat, String exp, String loginModeId, String loginMode, String openId) {
		super();
		this.userId = userId;
		this.iat = iat;
		this.exp = exp;
		this.loginModeId = loginModeId;
		this.loginMode = loginMode;
		this.openId = openId;
	}

	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getIat() {
		return iat;
	}
	public void setIat(String iat) {
		this.iat = iat;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getLoginModeId() {
		return loginModeId;
	}
	public void setLoginModeId(String loginModeId) {
		this.loginModeId = loginModeId;
	}
	public String getLoginMode() {
		return loginMode;
	}
	public void setLoginMode(String loginMode) {
		this.loginMode = loginMode;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	
	

}
