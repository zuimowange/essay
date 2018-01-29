package com.wgg.essay.config;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesUtil{

	/**
	 * 
	* @Title: gitCookieByName 
	* @Description: 获取cookie
	* @param    
	* @return Cookie    
	* @throws
	 */
	public static Cookie gitCookieByName(HttpServletRequest request,String name) {
		Map<String, Cookie> cookieMap = readCookieMap(request);
        if (cookieMap.containsKey(name)) {
            Cookie cookie = (Cookie) cookieMap.get(name);
            return cookie;
        } else {
            return null;
        }
	}
	
	/**
	 * 
	* @Title: readCookieMap 
	* @Description: 获取cookie Map 
	* @param    
	* @return Map<String,Cookie>    
	* @throws
	 */
	private static Map<String,Cookie> readCookieMap(HttpServletRequest request){
		Map<String, Cookie> cookieMap = new HashMap<String, Cookie>();
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                cookieMap.put(cookie.getName(), cookie);
            }
        }
        return cookieMap;
	}
	
	/**
	 * 
	* @Title: setCookie 
	* @Description: 保存cookie
	* @param    
	* @return HttpServletResponse    
	* @throws
	 */
	public static HttpServletResponse setCookie(HttpServletResponse response, String name, String value,int time) {
		Cookie cookie = new Cookie(name,value);
		cookie.setPath("/");
		try {
			URLEncoder.encode(value, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		cookie.setMaxAge(time);
		response.addCookie(cookie);
		return response;
	}
}
