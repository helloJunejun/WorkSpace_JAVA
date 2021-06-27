/**
 * 
 */
package com.work.model.dto;

/**
 * @author 준성
 *
 */
public class AdminMember extends Member {
	/** 관리자 직책 */
	private String position;
	
	
	/** 기본생성자 */
	public AdminMember() {
	
	}

	/**
	 * 회원 입력 필수데이터 초기화 생성자
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 */
public AdminMember(String memberId, String memberPw, String name, String mobile, String email) {
	
	//자식객체의 생성자에서 부모객체의 생성자를 미지정 => javac 자동으로 부모의 기본생성자 super() 자동 지정 호출수행
	
	// 자식객체의 생성자에서 부모객체의 생성자를 명시적으로 지정
//	super(memberId, memberPw, name, mobile, email);
	
	// 부모의 private 멤버는 접근권한으로 인해서 자식클래스일지라도 접근 불가
//	super.memberId = memberId;
	
	// 부모로부터 상속받은 setter() 메서드를 이용해서 데이터 초기화 수행 가능
	setMemberId(memberId);
	setMemberPw(memberPw);
	setName(name);
	setMobile(mobile);
	setEmail(email);
	
	setGrade("G");
	setEntryDate("2021-05-25");
	
	

}

	 /**
	 * 관리자 모든데이터 초기화 생성자
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 * @param entryDate 가입일 
	 * @param grade 등급
	 * @param position 직책
	 */
	public AdminMember(String memberId, String memberPw, String name, String mobile, String email,
			String entryDate, String grade, String position) {
		super(memberId, memberPw, name, mobile, email, entryDate, grade);
		this.position = position;
	}

	/**
	 * @return the manager
	 */
	public String getPosition() {
		return position;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", " + position;
	}
	
	
}
