package com.wgg.essay.controller.user;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wgg.essay.config.MsgCode;
import com.wgg.essay.dto.user.UserDto;
import com.wgg.essay.po.Token;
import com.wgg.essay.service.user.UserService;
import com.wgg.essay.utils.Base64Util;
import com.wgg.essay.utils.CookiesUtil;
import com.wgg.essay.utils.DateUtil;
import com.wgg.essay.utils.Md5Util;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("userRest")
public class UserRest{
	
	@Autowired UserService userService;
	@Autowired Md5Util md5Util;
	@Autowired DateUtil dateUtil;
	@Autowired Base64Util base64Util;
	@Autowired CookiesUtil cookiesUtil;
	
	
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
				dto.setMsg("注册失败，该账号已存在");
			}
		} catch (Exception e) {
			dto.setMsgCode(MsgCode.SERVER_ERROR);
			dto.setMsg("服务器错误");
		}
		dto.setPo(null);
		return dto;
	}
	
	@RequestMapping("login")
	public UserDto login(UserDto dto,HttpServletResponse response,HttpServletRequest request){
		try {
			Integer userId = userService.login(dto);
			if(userId != null) {
				
				//生成token
				Date iat = new Date();
				Date exp = dateUtil.changeDate(iat, Calendar.DATE, 10);				
				Token token = new Token(userId,dateUtil.dateToStamp(iat),dateUtil.dateToStamp(exp),"1","本平台登录",null);
				JSONObject map = JSONObject.fromObject(token);
				//token加密
				String tokens = base64Util.base64Encoder(map.toString());
				dto.setToken(tokens);
				
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