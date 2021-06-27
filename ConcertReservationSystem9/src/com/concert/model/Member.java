package com.concert.model;

/**
 * <pre>
 * 회원 정보 도메인 클래스 
 * -- encapsulation 설계 반영 변경
 * ## 회원 검증조건
 * 1. 아이디
 * 2. 비밀번호
 * 3. 이름
 * 4. 휴대폰
 * 5. 등급
 * 6. 캐쉬
 * </pre>
 * @author 유준성
 * @version ver.1.0
 * @since jdk1.8
 */



public class Member {
	/** 회원id : 식별키 */
	public String memberId;
	
	/** 비밀번호 : 필수 */
	public String memberPw;
	
	/** 이름 : 필수 */
	public String name;
	
	/** 휴대폰 : 필수 */
	public String mobile;
	
	/** 등급 : 필수 */
	public String grade;
	
	/** 캐쉬 : 필수 */
	public int money;

		
	
	
	
	
	/**
	 * 기본 생성자
	 */
	public Member() {
	}

	
	/**
	 * 필수 멤버 변수 초기화
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 */
	public Member(String memberId, String memberPw, String name, String mobile) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.mobile = mobile;
	}


	/**
	 * 선택 멤버 변수 초기화
	 * @param memberId
	 * @param memberPw
	 * @param name
	 * @param mobile
	 * @param grade
	 * @param money
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String grade, int money) {
		this(memberId, memberPw, name, mobile);
		this.grade = grade;
		this.money = money;
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
	 * @return the money
	 */
	public int getMoney() {
		return money;
	}



	/**
	 * @param money the money to set
	 */
	public void setMoney(int money) {
		this.money = money;
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
		builder.append(grade);
		builder.append(", ");
		builder.append(money);
		return builder.toString();
	}
	
	
	
	

}
