package com.wgg.essay.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wgg.essay.config.PropertiesUtil;

@Controller
@RequestMapping("user")
public class UserController{
	
	@Autowired PropertiesUtil propertiesUtil;
	
	@RequestMapping("login")
	public String login(Model model){
		model.addAttribute("baseHref", propertiesUtil.getBaseHref());
		return "user/login";
	}
}