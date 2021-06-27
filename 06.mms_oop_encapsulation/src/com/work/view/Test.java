package com.work.view;

import com.work.model.dto.Member;

public class Test {
	
	public static void main(String[] args) {
		Member dto = new Member("qwer", "1234", "유준성", "010-4966-0339", "qwer@naver.com");
		System.out.println("변경전 : " + dto);
		// 아이디 변경 : 멤버변수 직접 접근불가
		//dto.memberId = "aaa"; // Member 접근권한 private 선언, 외부에서 직접접근 불가
		
		// 아이디 변경 : setter()
		// 올바른 아이디 검증 규칙 준수
		dto.setMemberId("happyday2021");
		System.out.println("변경후 : " + dto);
		
		dto.setMemberId("test");
		System.out.println("변경후 : " + dto);
		
		dto.setMemberPw("1234");
		System.out.println("변경후 : " + dto);
		
		dto.setMileage(159);
		System.out.println("변경후 : " + dto);
		
		dto.setGrade("G");
		System.out.println("변경후 : " + dto);
	}

	public static void main2(String[] args) {
		// 회원의 가입시 입력데이터 초기화생성자 이용해서 객체 생성
		// 가입 : 아이디, 비밀번호, 이름, 휴대폰, 이메일
		/**
		 * 회원의 가입시 입력데이터 초기화생성자 이용해서 객체 생성
		 * 가입 : 아이디, 비밀번호, 이름, 휴대폰, 이메일
		 */
		Member dto = new Member("qwer", "1234", "유준성", "010-4966-0339", "qwer@naver.com");
		
		// 생성한 회원객체의 정보를 출력
		// System.out.println(참조변수명); => 참조변수명.toString() 수행결과문자열을 콘솔창 출력
		// toString() 메서드 생략 가능
//		System.out.println(dto.toString());
		System.out.println(dto);
	}

}
