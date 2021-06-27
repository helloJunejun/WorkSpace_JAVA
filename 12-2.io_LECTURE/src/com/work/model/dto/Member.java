package com.work.model.dto;

/**
 * <pre>
 * 회원 도메인 클래스 
 * -- encapsulation 설계 반영 변경
 * ## 회원 검증조건
 * 	1. 아이디 : 6자리 ~ 30자리 이내
 * 	2. 비밀번호 : 6자리 ~ 20자리 이내
 * 	3. 마일리지 : 0 ~ 100,000 
 * 	4. 등급 : G, S, A
 * 	-- 문자열 비교 메서드
 * 	-- String
 * 	-- equals(Object anObject) : boolean
 * 
 * 	1. 아이디
 * 	2. 비밀번호
 * 	3. 이름
 * 	4. 휴대폰
 * 	5. 이메일
 * 	6. 가입일
 * 	7. 등급
 *  8. 마일리지
 *  9. 담당자
 * </pre>
 * 
 * @author 임경혜
 * @version ver.1.0
 * @since jdk1.8
 */
public class Member {
	/** 아이디, 식별키 */
	private String memberId;
	
	/** 비밀번호, 필수 */
	private String memberPw;
	
	/** 이름, 필수 */
	private String name;
	
	/** 휴대폰, 필수, 형식 01012341234 */
	private String mobile;
	
	/** 이메일, 필수 */
	private String email;
	
	/** 가입일, 필수, 형식 2021-05-26, 시스템 현재날짜 제공 */ 
	private String entryDate;
	
	/** 등급, 필수, 일반(G), 우수(S), 관리자(A), 시스템 제공 */
	private String grade;

	/** 마일리지 : 일반회원 */
	private int mileage;
	
	/** 담당자 : 우수회원 */
	private String manager;

	/**
	 * 기본생성자
	 */
	public Member() {}

	/**
	 * 사용자 입력데이터 초기화 생성자
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
	 * 회원 전체데이터 초기화 생성자
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param email
	 * @param entryDate
	 * @param grade
	 * @param mileage
	 * @param manager
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, int mileage, String manager) {
		this(memberId, memberPw, name, mobile, email, entryDate, grade);
		this.mileage = mileage;
		this.manager = manager;
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
	 * @param mobile the mobile to set
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

	/**
	 * @return the manager
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(memberId);
		builder.append(", ");
		builder.append(memberPw);
		builder.append(", ");
		builder.append(name);
		builder.append(", ");
		builder.append(mobile);
		builder.append(", ");
		builder.append(email);
		builder.append(", ");
		builder.append(entryDate);
		builder.append(", ");
		builder.append(grade);
		builder.append(", ");
		builder.append(mileage);
		builder.append(", ");
		builder.append(manager);
		return builder.toString();
	}
}



