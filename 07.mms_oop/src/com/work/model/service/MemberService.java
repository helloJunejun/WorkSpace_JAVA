package com.work.model.service;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

/**
 * <pre>
 * 회원을 관리하기 위한 서비스 클래스
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

	public class MemberService {
		
		/**
		 * 초기회원 등록 메서드
		 */
		public void initMember() {
			Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 5000);
			Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2020-12-15", "G", 95000);
			Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-12-15", "S", "강동원");
			Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2020-12-15", "S", "김하린");
			Member dto5 = new AdminMember("adminstrator", "admin1004", "유관순", "01012345000", "adminstrator@work.com", "2020-12-15", "A", "선임");
		}
		
		private Member[] members;
		
		private int count;
			
		/** 기본생성자 : 배열의 크기를 기본 10개 초기화 */
		public MemberService() {
			this(10);
		}
		/**
		 * 배열의 크기를 전달받아서 배열생성 할당 초기화 생성자
		 * @param length
		 */
		public MemberService(int length) {
			members = new Member[length];	
		}
		/** 실습 : 현재 등록한 학생성적의 숫자 조회 메서드 */
		public int getCount() {
			return count;
		}	
		
		public void addMember(String memberId, String memberPw, String name, 
				String mobile, String email, String entryDate, String grade) {
			
			Member dto = new Member();
			
			dto.setMemberId(memberId);
			dto.setMemberPw(memberPw);
			dto.setName(name);
			dto.setMobile(mobile);
			dto.setEmail(email);
			dto.setEntryDate(entryDate);
			dto.setGrade(grade);
			
			
			
			}
	
	}

	
	
	
	
	
	
	
	
