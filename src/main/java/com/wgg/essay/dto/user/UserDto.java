package com.wgg.essay.dto.user;

import com.wgg.essay.dto.AbstractBaseDto;
import com.wgg.essay.po.User;

public class UserDto extends AbstractBaseDto<User>{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -7884291922588131869L;
	
	public String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}