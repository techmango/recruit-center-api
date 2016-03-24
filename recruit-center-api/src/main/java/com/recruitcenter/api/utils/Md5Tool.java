package com.recruitcenter.api.utils;

import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Encoder;

public class Md5Tool {
	static Log log = LogFactory.getLog(Md5Tool.class);
	public static String getMd5(String password){
		String str = "";
		if(password !=null && !"".equals(password)){
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				BASE64Encoder base = new BASE64Encoder();
				//加密后的字符串
				str = base.encode(md.digest(password.getBytes("utf-8")));
			} catch (Exception e) {
				log.error(e.toString());
			}
		}
		return str;
	}
	public static void main(String[] args) {
		System.err.println(getMd5("root"));
	}
}
