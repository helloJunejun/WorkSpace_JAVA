package com.work.test;

import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;

public class ObjectClassTest {

	// Member 클래스 : equals() 재정의 테스트
	// 회원의 아이디가 같으면 같은 객체
	// 같은객체여부를 비교할때는 반드시 equals() 메서드로 비교해야함 : **********
	public static void main(String[] args) {
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 5000);
		Member dto2 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 5000);
		Member dto3 = new GeneralMember("user02", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 5000);

		// 생성한 객체의 hashCode() 참조값 출력
		System.out.println("dto 1 : " + dto1.hashCode()); // 참조값a
		System.out.println("dto 2 : " + dto2.hashCode()); // 참조값a
		System.out.println("dto 3 : " + dto3.hashCode()); // 참조값x
		
		System.out.println();
		System.out.println(dto1 == dto2); // false
		System.out.println(dto1 == dto3); // false
		
		System.out.println();
		System.out.println(dto1.equals(dto2)); // true
		System.out.println(dto1.equals(dto3)); // false
		
	}
	
	// Member 클래스 : equals() 재정의 하지 않고 테스트
	// Object 비교 : 같은 객체는 같은 참조값 따라서 ==, equals() 동일한 결과
	public static void main2(String[] args) {
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 5000);
		Member dto2 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 5000);
		Member dto3 = new GeneralMember("user02", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 5000);

		// 생성한 객체의 hashCode() 참조값 출력
		System.out.println("dto 1 : " + dto1.hashCode());
		System.out.println("dto 2 : " + dto2.hashCode());
		System.out.println("dto 3 : " + dto3.hashCode());
		
		System.out.println();
		System.out.println(dto1 == dto2); // false
		System.out.println(dto1 == dto3); // true
		
		System.out.println();
		System.out.println(dto1.equals(dto2)); // false2
		System.out.println(dto1.equals(dto3)); // true
	}

	// Object 비교 : 같은 객체는 같은 참조값 따라서 ==, equals() 동일한 결과
	public static void main1(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		Object obj3 = obj1;
		
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		System.out.println(obj3.hashCode());
		
		System.out.println();
		System.out.println(obj1 == obj2); // false
		System.out.println(obj1 == obj3); // true
		
		System.out.println();
		System.out.println(obj1.equals(obj2)); // false
		System.out.println(obj1.equals(obj3)); // true
	}

}
