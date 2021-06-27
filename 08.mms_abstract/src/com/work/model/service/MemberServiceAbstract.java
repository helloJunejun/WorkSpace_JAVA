package com.work.model.service;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

/**
 * <pre>
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
		 * 회원들을 관리하기 위한 자료저장구조 : 배열 다형성 반영(부모타입) :
		 * 생성자 사용초기화, 확장, 고정 본인이 편한 로직으로 진행하세요.
		 */
		private Member[] members = new Member[10];
		
		/** 등록인원수 및 등록될 배열요소 위치정보 */
		private int count;
			
//		/** 기본생성자 : 배열의 크기를 기본 10개 초기화 */
//		public MemberServiceAbstract() {
//			this(10);
//		}
//		/**
//		 * 배열의 크기를 전달받아서 배열생성 할당 초기화 생성자
//		 * @param length
//		 */
//		public MemberServiceAbstract(int length) {
//			members = new Member[length];	
//		}
		
		/**
		 * 현재 등록 인원수 조회
		 * @return 현재 등록 인원수
		 */
		public int getCount() {
			return count;
		}	
		
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
		 * -- 반환타입 : Member(반호나타입다형성 : 부모타입)
		 */
		public abstract Member getMember(String memberId);


		/**
		 * 전체조회
		 * -- 메서드명 : getMember()
		 * -- 매개변수 : no argument
		 * -- 반환타입 : 현재 등록된 모든 회원들의 정보만을 저장한 배열, 다형성 Member[]
		 */
		public abstract Member[] getMember();
		
		/**
		 * 회원정보 전체변경
		 * -- 메서드명 : setMember()
		 * -- 매개변수 : Member
		 * -- 반환타입 : void / 오류발생시 메세지 처리
		 */
		
		/**
		 * 회원 비밀번호 변경
		 * -- 메서드명 : setMemberPw()
		 * -- 매개변수 : 아이디, 비밀번호(기존), 변경비밀번호
		 * -- 반환타입 : boolean 암호변경성공 true, 실패하면 false
		 */
		
		/**
		 * 회원 탈퇴
		 * -- 메서드명 : removeMember()
		 * -- 매개변수 : 아이디, 비밀번호
		 * -- 반환타입 : void
		 */
		
		/**
		 * 회원 전체 탈퇴 
		 * -- 메서드명 : removeMember()
		 * -- 매개변수 : no argument
		 * -- 반환타입 : void
		 */
	
		/** 초기회원 등록 메서드 */
		public void initMember() {
			
		}
	
	
		
		
		
		
	}		
		
	
	
	
