package com.wgg.essay.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wgg.essay.config.MsgCode;
import com.wgg.essay.dto.user.UserDto;
import com.wgg.essay.service.user.UserService;

@RestController
@RequestMapping("userRest")
public class UserRest{
	
	@Autowired UserService userService;
	
	
	@RequestMapping("reg")
	public UserDto reg(UserDto dto){
		Integer id;
		try {
			id = userService.reg(dto);
			if(id>0) {
				dto.setMsgCode(MsgCode.REQUEST_SCCESS);
				dto.setMsg("注册成功");
			}
			else {
				dto.setMsgCode(MsgCode.REQUEST_FALSE);
				dto.setMsg("注册失败");
			}
		} catch (Exception e) {
			dto.setMsgCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		dto.setPo(null);
		return dto;
	}
	
	@RequestMapping("login")
	public UserDto login(UserDto dto){
		try {
			boolean flag = userService.login(dto);
			if(flag) {
				dto.setMsgCode(MsgCode.REQUEST_SCCESS);
				dto.setMsg("登录成功");
			}
			else {
				dto.setMsgCode(MsgCode.REQUEST_FALSE);
				dto.setMsg("登录失败");
			}
		} catch (Exception e) {
			dto.setMsgCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		return dto;
	}
}