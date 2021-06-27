package com.work.view;

import com.work.model.dto.GeneralMember;

public class Test {
	
	public static void main(String[] args) {
		// 일반회원 자식객체 생성 절차 : 부모 메모리할당 => 자식 메모리할당
		GeneralMember g1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com");
		
		System.out.println(g1.getMemberId());	// Member 부모로부터 상속받은 메서드
		System.out.println(g1.getName());
	}
}
