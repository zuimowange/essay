package com.wgg.essay.utils;

import java.io.IOException;

import org.springframework.stereotype.Service;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

@Service
public class Base64Util {
	
	/** 
     * base64加密
     * */  
    public static String base64Encoder(String str)  
    {  
    	byte[] s = str.getBytes();
    	BASE64Encoder encoder = new BASE64Encoder();  
        String encode = encoder.encode(s);
        return encode;
    }
    
    /** 
     * base64解密
     * */
    public static String base64Decoder(String str) {
    	BASE64Decoder decoder = new BASE64Decoder();
    	byte[] s = null;
		try {
			s = decoder.decodeBuffer(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	String decode = new String(s);
    	return decode;
    }
}
