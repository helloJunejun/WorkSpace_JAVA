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
		
		print("초기화 회원 등록 : " + service.initMember());
		
//		print("회원등록");
//		Member dto = new GeneralMember("qwer", "password1004", "유준성", "01049660339", "qwer@naver.com");
//		service.addMember("qwer", "password1004", "유준성", "01049660339", "qwer@naver.com");
//		service.addMember("qwer2", "password10042", "유준성2", "01049660338", "qwer2@naver.com");
//		service.addMember("qwer2", "password10042", "유준성2", "01049660338", "qwer2@naver.com");
	
		
		print("로그인");
		if(service.login1("user01", "password01")) {
			System.out.println("로그인에 성공하였습니다.");
		} else {
			System.out.println("로그인에 실패하였습니다.");
		}
		
		
		print("현재 등록회원수 : " + service.getCount());
		
		print("전체회원 조회");
		ArrayList list = service.getMember();
		for(int index = 0; index < list.size(); index++) {
			System.out.println(list.get(index));
		}
		print("회원 상세조회 : usero01");
		Member dto = service.getMember("user01");
		if(dto != null) {
			System.out.println(dto);
		}
		print("회원 상세조회 : 신규등록 회원 test01");
		dto = service.getMember("qwer");
		if(dto !=null) {
		System.out.println(dto);	
		}
		
		print("user01 전체정보 변경");
		//dto = new GeneralMember("user01",);
		dto = service.getMember("user01");
		
		print("변경전 user01 정보 " + dto);
		
		// 변경하고자하는 속성 setter 이용해서 변경
		dto.setName("김은경");
		dto.setMemberPw("happy1004");
		dto.setMobile("010-8231-1111");
		// 변경수행
		service.setMember(dto);
		
		dto = service.getMember("user01");
		print("변경후 user01 정보 " + dto);
		
		
		boolean result = service.setMember(dto);
		if(result) {
			System.out.println(service.getMember("xxxx"));
		} else {
			System.out.println("xxxx 아이디 회원정보가 존재하지 않습니다.");
		}
		
		// 비밀번호 변경
		print("비밀번호 변경전 조회 : ");
		dto = service.getMember("user02"); // user02, password02
		System.out.println(dto);
		
		// 비밀번호 변경
		service.setMemberPw("user02", "password02", "goodluck");
		if(result) {
			System.out.println("비밀번호 정상 변경처리되었습니다.");  // 물어보기
		} else {
			System.out.println("[오류] 회원의 정보를 다시 확인하시기 바랍니다.");
		}
	
		dto = service.getMember("user02");
		System.out.println(dto);
		
		print("user01");
		System.out.println(service.getMember("user01"));
		
		dto = service.removeMember("user01", "happy1004");
		if(dto != null) {
			System.out.println("[탈퇴성공]" + dto.getName() + "님 그동안 서비스를 이용해주셔서 감사합니다.");
		} else {
			System.out.println("[탈퇴실패] 회원의 정보를 다시 확인하시기 바랍니다.");
		}
	}	
	
	/** 테스트시에 출력위한 메서드
	 * @param message 아규먼트 메세지 테스트용
	 *  
	 */
	public static void print(String message) {
		System.out.println("\n### " + message);
	}
}
