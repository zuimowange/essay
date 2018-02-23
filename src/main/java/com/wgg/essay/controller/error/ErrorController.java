package com.wgg.essay.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	@RequestMapping("400")
	public String error400(){
		return "errorPage/400";
	}
	
	@RequestMapping("401")
	public String error401(){
		return "errorPage/401";
	}
	
	@RequestMapping("404")
	public String error404(){
		return "errorPage/404";
	}
	
	@RequestMapping("500")
	public String error500(){
		return "errorPage/500";
	}
}
