package com.work.util;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**
 * <pre>
 * -- 공통으로 사용하는 메서드를 위한 유틸리티 클래스
 * -- 모든 메서드는 객체생성없이 사용가능 Class Method 선언(static method)
 * </pre>
 * 
 * @author 임경혜
 *
 */
public class Utility {
	public static void main(String[] args) {
//		System.out.println("현재날짜");
		
//		print("현재날짜");
//		System.out.println(Utility.getCurrentDate());
//		System.out.println(Utility.getCurrentDate("MM-dd-yyyy"));
//		System.out.println(Utility.getCurrentDate("MM/dd/yyyy [a] hh:mm"));
//		System.out.println(Utility.getCurrentDate("MM/dd/yyyy [a] hh:mm", Locale.US));
//		System.out.println(Utility.getCurrentDate("MM/dd/yyyy [a] hh:mm", Locale.CHINA));
//		System.out.println(Utility.getCurrentDate("HH:mm"));
//		System.out.println(Utility.getCurrentDate("[a]hh:mm"));
//		System.out.println(Utility.getCurrentDate("[a]hh:mm", Locale.US));
//		
//		print("숫자형식");
//		int mileage = 1234567;
//		NumberFormat numberFormat = NumberFormat.getInstance();
//		NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance();
//		NumberFormat numberFormat3 = NumberFormat.getCurrencyInstance(Locale.US);
//		
//		System.out.println(numberFormat.format(mileage));
//		System.out.println(numberFormat2.format(mileage));
//		System.out.println(numberFormat3.format(mileage));
		
		print("임시발급숫자");
		System.out.println(Utility.getSecureNumberString());
		System.out.println(Utility.getSecureNumberString(6));
		System.out.println(Utility.getSecureNumberString(10));
		
		System.out.println(Utility.getSecureAlphabetString());
		System.out.println(Utility.getSecureAlphabetString(6));
		System.out.println(Utility.getSecureAlphabetString(10));
	}
	
	/** 
	 * 테스트시에 테스트 항목을 출력하기 위한 메서드
	 * @param message 테스트 문자열
	 */
	public static void print(String message) {
		System.out.println("\n### " + message);
	}
	
	/**
	 * 현재 날짜를 기본날짜형식 년도 4자리.월2자리.일2자리 형식의 문자열 변환 반환 메서드
	 * @return 기본 형식의 현자낼짜 문자열
	 */
	public static String getCurrentDate() {
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
//		String currentDate = simpleDateFormat.format(new Date());
//		return currentDate;
		
		//return new SimpleDateFormat("yyyy.MM.dd").format(new Date());
		return getCurrentDate("yyyy-MM-dd");
	};
	
	
	/**
	 * 아규먼트로 전달받은 날짜 형식의 현재날짜 변환 반환 메서드 
	 * @param pattern 날짜형식
	 * @return 날짜형식의 현재날짜 문자열
	 */
	public static String getCurrentDate(String pattern) {
		//return new SimpleDateFormat(pattern).format(new Date());
		return getCurrentDate(pattern, Locale.KOREA);
	}
	
	/**
	 * <pre>
	 * 아규먼트로 전달받은 날짜 형식, 로케일 형식의 현재날짜 변환 반환 메서드
	 * 로케일 : java.util.Locale => FIELD 참고
	 * java.util.SimpleDateFormat 생성자 중복정의 => public SimpleDateFormat(String, Locale)
	 * 
	 * </pre>
	 * @see java.util.Locale
	 * @see java.util.SimpleDateFormat
	 * @param pattern  날짜형식  및 시간 형식
	 * @param locale 로케일형식
	 * @return  날짜 형식, 로케일 형식의 현재날짜 문자열
	 */
	public static String getCurrentDate(String pattern, Locale locale) {
		return new SimpleDateFormat(pattern, locale).format(new Date());
	}
	

	// TODO 1 : 아규먼트로 받은 정수형 숫자를 천단위마다 컴마표기 문자열 반환 메서드
	
	// TODO 2 : 아규먼트로 받은 정수형 숫자, 로케일을 받아서  화폐기호 및 천단위마다 컴마표기 문자열 반환 메서드
	
	// TODO 3 : 아규먼트로 받은 문자열 데이터를 앞에 2자리만 보여주고 나머지는 * 기호로 대체 변환한 문자열 반환 메서드
	// 예시) 암호 bluesky2020 => bl*********
	
	// TODO 4 : TODO 3 중복정의 
	// 아규먼트로 받은 문자열, 길이를 받아서 해당 자리수만 보여주고 나머지는 * 기호로 대체 변환한 문자열 반환 메서드
	
	// TODO 5 : 보안문자 발급 메서드 : 기본으로 4자리 숫자형식의 문자열 반환 메서드
	// 예시) 암호찾기 => 임시발급암호로 사용
	// 배열 사용하지 마세요 => StringBuilder를 사용하는것이 편합니다.
	// 참고 : java.util.Random#nextInt(10) 
	// 참고 : java.lang.StringBuilder#append()
	public static String getSecureNumberString() {
//		Random random = new Random((long)(Math.random() * System.nanoTime()));
//		StringBuilder secureString = new StringBuilder();
//		
//		for (int index = 0; index < 4; index++) {
//			secureString.append(random.nextInt(10));
//		}
//		return secureString.toString();
		
		return getSecureNumberString(4);
	}
	
	public static String getSecureNumberString(int length) {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		StringBuilder secureString = new StringBuilder();
		
		for (int index = 0; index < length; index++) {
			secureString.append(random.nextInt(10));
		}
		return secureString.toString();
	}

	/** 보안 영문 대문자 */
	public static String getSecureAlphabetString() {
		return getSecureAlphabetString(4);
	}
	
	public static String getSecureAlphabetString(int length) {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		StringBuilder secureString = new StringBuilder();
		
		for (int index = 0; index < length; index++) {
			secureString.append((char)(random.nextInt(26) + 97));
		}
		return secureString.toString();
	}
	
	public static int getLottoNo() {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		return random.nextInt(45) + 1; // 0 ~ 44 , 46:0~45, 45:0~44+1 => 1~45
	}
	
	// TODO 6 : TODO 5 중복정의
	// 길이를 아규먼트로 전달받아서 전달받은 길이의 숫자형식의 문자열 반환 메서드
	
	
	// TODO 7: TODO 6 중복정의
	// 길이, 영문대소문자 여부를 아규먼트로 전달받아서 해당된 길이의 숫자 및 영문 대소문자를 랜덤하게 조합하여 변환한 문자열 반환 메서드
	// 참고 : 영문 26자리, 영문대문자 ASCII CODE : 65, 영문소문자 ASCII CODE : 97
	

	// 도전 TODO : 
	// 보안문자 반환 : 비밀번호, 이름, 휴대폰
	// 비밀번호 : bl****, blu****, blue***
	// 이름 : 홍*동, 문*, 남**재
	// 전화번호 : 02-1234-1234 => ********1234, 010-1234-2773 => ********2773
	// 메서드명(length, align) : String
	// 참고 : String#	lastIndexOf(String str)
	
}









