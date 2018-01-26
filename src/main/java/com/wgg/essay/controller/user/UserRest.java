package com.wgg.essay.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wgg.essay.dto.user.UserDto;
import com.wgg.essay.service.user.UserService;

@RestController
@RequestMapping("userRest")
public class UserRest{
	
	@Autowired UserService userService;
	
	@RequestMapping("login")
	public UserDto login(UserDto dto){
		userService.login(dto);
		
		return dto;
	}
}