package com.wgg.essay.dto;

import java.io.Serializable;

public abstract class AbstractBaseDto<T extends Object> implements Serializable{
	
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 5221466235070551292L;

	protected Integer msgCode;
	protected String msg;
	protected T po;
	public Integer getMsgCode() {
		return msgCode;
	}
	public void setMsgCode(Integer msgCode) {
		this.msgCode = msgCode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getPo() {
		return po;
	}
	public void setPo(T po) {
		this.po = po;
	}
	
	
}
