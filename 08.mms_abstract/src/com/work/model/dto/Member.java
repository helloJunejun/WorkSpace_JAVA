package com.work.model.dto;

/**
 * <pre>
 * 회원 정보 도메인 클래스 
 * -- encapsulation 설계 반영 변경
 * ## 회원 검증조건
 * 	1. 아이디
 * 	2. 마일리지
 * 	3. ...
 * 
 * -- inheritance 설계 반영 변경
 * 	>> 모든 회원들의 공통(일반화) : 부모 클래스 설계 변경
 *  * 1. 아이디
 * 2. 비밀번호
 * 3. 이름
 * 4. 휴대폰
 * 5. 이메일
 * 6. 가입일
 * 7. 등급
 * </pre>
 * @author 유준성
 * @version ver.1.0
 * @since jdk1.8
 */



public class Member {
	/** 회원id : 식별키 */
	private String memberId;
	
	/** 비밀번호 : 필수 */
	private String memberPw;
	
	/** 이름 : 필수 */
	private String name;
	
	/** 휴대폰 : 필수 */
	private String mobile;
	
	/** 이메일 : 필수 */
	private String email;
	
	/** 가입일 : 필수, 시스템 */
	private String entryDate;
	
	/** 등급 : 필수 , 시스템 */
	private String grade;

	/** 기본 생성자 */
	public Member() {
	
	}
	
	/**사용자입력 필수데이터 초기화 생성자
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}

	/**
	 * 회원 필수데이터 초기화 생성자
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 * @param entryDate
	 * @param grade
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade) {
		this(memberId, memberPw, name, mobile, email);
		this.entryDate = entryDate;
		this.grade = grade;
	}

	
	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}



	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}



	/**
	 * @return the memberPw
	 */
	public String getMemberPw() {
		return memberPw;
	}



	/**
	 * @param memberPw the memberPw to set
	 */
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}



	/**
	 * @param mobile the mobile to set1004
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}



	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}



	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}



	/**
	 * @return the entryDate
	 */
	public String getEntryDate() {
		return entryDate;
	}



	/**
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}



	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}



	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}


	
// 	재정의하지 않으면 java.lang.Object#toString() 상속 메서드를 그대로 사용
	
	//재정의하면 => 재정의한 결과의 문자열 반환
	@Override
	public String toString() {
		return memberId + ", " + memberPw + ", " + name + ", " + mobile + ", " + email + ", " + entryDate + ", "
				+ grade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		return result;
//		return 1004;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) // 멤버변수와 아규먼트 obj가 같을때
			return true; // 참 반환
		
		if (obj == null) // 아규먼트가 null일때
			return false; // 거짓 반환
		
		if (getClass() != obj.getClass()) // 해당 클래스와 아규먼트 클래스가 다를때
			return false; // 거짓 반환
		
		Member other = (Member) obj; // 멤버로 형변환한 아규먼트값 obj를 other 변수에 삽입
		if (memberId == null) { // 멤버아이디가 비어있을때
			if (other.memberId != null) // obj의 멤버변수값이 null 이지 않을때
				return false; // 리턴값 거짓 반환
		} else if (!memberId.equals(other.memberId)) // 위에게 아니라면 멤버아이디와 
			return false;
		return true;
	}
	
	

}










