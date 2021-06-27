/**
 * 
 */
package com.work.model.dto;

/**
 * <pre>
 * 일반 회원 도메인 클래스
 * -- 회원(부모클래스)의 자식(상속)
 * 
 * # 일반회원 속성
 * 1. 아이디
 * 2. 비밀번호
 * 3. 이름
 * 4. 휴대폰
 * 5. 이메일
 * 6. 가입일
 * 7. 등급
 * 
 * 8. 마일리지
 * </pre>
 * @author 유준성
 * @version ver.1.0
 * @since jdk1.8
 */
	public class GeneralMember extends Member {
		/** 일반회원 마일리지 */
		private int mileage;
		
		
		/** 기본생성자 */
		public GeneralMember() {
		
		}

		/**
		 * 회원 입력 필수데이터 초기화 생성자
		 * @param memberId 아이디
		 * @param memberPw 비밀번호
		 * @param name 이름
		 * @param mobile 휴대폰
		 * @param email 이메일
		 */
	public GeneralMember(String memberId, String memberPw, String name, String mobile, String email) {
		setMemberId(memberId);
		setMemberPw(memberPw);
		setName(name);
		setMobile(mobile);
		setEmail(email);
		
		setGrade("G");
		setEntryDate("2021-05-25");
	}
	
		 /**
		 * 일반회원 모든데이터 초기화 생성자
		 * @param memberId 아이디
		 * @param memberPw 비밀번호
		 * @param name 이름
		 * @param mobile 휴대폰
		 * @param email 이메일
		 * @param entryDate 가입일 
		 * @param grade 등급
		 * @param mileage 마일리지
		 */
		public GeneralMember(String memberId, String memberPw, String name, String mobile, String email,
				String entryDate, String grade, int mileage) {
			super(memberId, memberPw, name, mobile, email, entryDate, grade);
			this.mileage = mileage;
		}

	/**
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * @param mileage the mileage to set
	 */
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return super.toString() +  ", " + mileage;
	}
	

}
