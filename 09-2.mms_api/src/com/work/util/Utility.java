package com.work.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * <pre>
 * -- 공통으로 사용하는 메서드를 위한 유틸리티 클래스
 * -- 모든 메서드는 객체생성없이 사용가능 Class Method 선언(static method)
 * </pre>
 * @author 준성
 *
 */
public class Utility {

	/**
	 * <pre>
	 * 현재날짜 기본형식의 문자열로 변환하는 메서드
	 * -- 기본형식 : 년도 4자리-월2자리 -일 2자리
	 * </pre>
	 * @return
	 */
	public static String getCurrentDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date todate = new Date();
		return dateFormat.format(todate);
	}
	public static String getCurrentDate(String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		Date todate = new Date();
		return dateFormat.format(todate);
	}
	public static String getCurrentDate(String pattern, Locale locale) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern, locale);
		Date todate = new Date();
		return dateFormat.format(todate);
	}
	
	
	/**
	 * 유틸리티 테스트 메서드
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(getCurrentDate()); // same class 호출
		System.out.println(Utility.getCurrentDate()); // other class 호출
		System.out.println(Utility.getCurrentDate("yyyy/MM/dd [a] hh:mm", Locale.JAPAN));
	}
	
}
