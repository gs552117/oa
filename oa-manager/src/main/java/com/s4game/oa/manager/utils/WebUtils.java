package com.s4game.oa.manager.utils;

public class WebUtils {

	public static boolean isAdd(Long id) {
		return id == null || id <= 0;
	}
	
	public static boolean isAdd(Integer id) {
		return id == null || id <= 0;
	}
}