package com.work.model.service;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

/**
 * 회원을 관리하기 위한 서비스 클래스 (추상클래스 설계 변경)
 * -- 추상클래스 구성요소
 * 	>> 클래스 구성요소 + [추상메서드]
 * 
 * -- 회원들을 관리하기 위한 자료저장구조 : 배열 다형성 반영(부모타입)
 * -- 메서드 아규먼트 다형성(부모타입), 반환타입??
 * 
 * -- 메서드명(매개변수): 반환타입
 * 
 * -- C(등록) 
 * 
 * -- R(조회)
 * 	=> 단일조회(상세조회) => 아이디
 * 	=> 다중조회(전체조회, 그룹조회) => 전체조회(), 등급별회원전체조회(등급)
 * -- U(변경)
 * 	=> 전체변경()
 * 	=> 부분변경(비밀번호변경)
 * -- D(삭제)
 * 	=> 전체삭제
 * 	=> 특정삭제 : 아이디
 */
public abstract class MemberServiceAbstract {
	
	/** 
	 * 회원등록 
	 * -- 메서드명
	 * -- 매개변수 : ????? 다형성반영 모든회원을 등록하기위한 메서드
	 * -- 반환타입
	 */
	public abstract void addMember(Member dto); // This method requires a body instead of a semicolon
	
	/**
	 * CRUD 메서드에서 사용하기 위한 회원 존재유무 및 저장 위치 조회 메서드
	 * @param memberId 아이디
	 * @return 존재시에 저장위치번호, 미존재시 -1
	 */
	public abstract int exist(String memberId);
	
	/** 
	 * 상세조회 
	 * -- 메서드명 : getMember()
	 * -- 매개변수 : memberId
	 * -- 반환타입 : Member (반환타입다형성 : 부모타입)
	 */
	public abstract Member getMember(String memberId);

	/** 
	 * 전체조회 
	 * -- 메서드명 : getMember()
	 * -- 매개변수 : no argument
	 * -- 반환타입 : 현재 등록된 모든 회원들의 정보만을 저장한 배열, 다형성 Member[]
	 */
	
	
	
	/** 
	 * 회원정보 전체변경 
	 * -- 메서드명 : setMember()
	 * -- 매개변수 : Member
	 * -- 반환타입 : void / 오류발생시 메세지 처리 
	 */
	
	
	/** 
	 * 회원 비밀번호 변경 
	 * -- 메서드명 : setMemberPw()
	 * -- 매개변수 : 아이디, 비밀번호, 변경비밀번호
	 * -- 반환타입 : boolean 암호변경성공 true, 실패하면 false
	 */
	
	
	/** 
	 * 회원탈퇴 
	 * -- 메서드명 : removeMember()
	 * -- 매개변수 : 아이디, 비밀번호
	 * -- 반환타입 : void
	 */
	
	
	/** 
	 * 회원전체탈퇴 
	 * -- 메서드명 : removeMember()
	 * -- 매개변수 : no argument
	 * -- 반환타입 : void
	 */
	
	
	/**
	 * 초기회원 등록 메서드
	 */
	public void initMember() {
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 50000);
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2021-01-05", "G", 950000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-11-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2021-01-05", "S", "김하린");
		Member dto5 = new AdminMember("administrator", "admin1004", "유관순", "01012345000", "administrator@work.com", "2020-04-01", "A", "선임");
	}

}


