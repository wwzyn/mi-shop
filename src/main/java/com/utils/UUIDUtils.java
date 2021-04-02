package com.utils;

import java.util.UUID;

public class UUIDUtils {
	/**
	 * 随机生成id
	 * @return
	 */
	public static String getId(){
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	
	/**
	 * 生成随机码
	 * @return
	 */
	public static String getCode(){
		return getId();
	}
	
	public static void main(String[] args) {
		String id = UUIDUtils.getId() ;
		System.out.println(id);

		System.out.println("------------------------");
		String code = UUIDUtils.getCode();
		System.out.println(code);
	}
	
	
}
