package com.wgg.essay.po;

public class Token {
	private Integer userId;//userID
	private String iat;//token生成时间
	private String exp;//token生命周期，到期时间
	private String loginModelId;//登录方式ID
	private String loginMode;//登录方式
	private String openId;//oId
	public Token() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Token(Integer userId, String iat, String exp, String loginModelId, String loginMode, String openId) {
		super();
		this.userId = userId;
		this.iat = iat;
		this.exp = exp;
		this.loginModelId = loginModelId;
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
	public String getLoginModelId() {
		return loginModelId;
	}
	public void setLoginModelId(String loginModelId) {
		this.loginModelId = loginModelId;
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
