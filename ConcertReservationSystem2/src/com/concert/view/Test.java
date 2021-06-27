package com.concert.view;

import java.util.ArrayList;

import com.concert.exception.CommonException;
import com.concert.exception.DuplicateException;
import com.concert.exception.RecordNotFoundException;
import com.concert.model.Member;
import com.concert.service.MemberService;

public class Test {
	
	/**
	 * 회원관리시스템 테스트 메서드
	 * -- 회원등록(아이디, 비밀번호, 이름, 휴대폰, 이메일) : 사용자 입력
	 * -- service(model) : 사용자입력정보 + 시스템(가입일 현재날짜, 등급 일반회원, [+ 마일리지정책 가입시 1000])
	 * @param args
	 * @throws DuplicateException 
	 * @throws RecordNotFoundException 
	 * @throws CommonException 
	 */
	public static void main(String[] args) throws DuplicateException, RecordNotFoundException, CommonException {
		print("회원관리 서비스 이용위한 객체생성");
		MemberService service = new MemberService();
		
		service.initMember();
		
		print("초기화 회원 카운트 : " + service.getCount());
		

	}	
	
	/** 테스트시에 출력위한 메서드
	 * @param message 아규먼트 메세지 테스트용
	 *  
	 */
	public static void print(String message) {
		System.out.println("\n### " + message);
	}
}
