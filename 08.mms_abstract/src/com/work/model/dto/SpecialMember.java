/**
 * 
 */
package com.work.model.dto;

/**
 * @author 준성
 *
 */
public class SpecialMember extends Member {
	/** 우수회원 담당자 */
	private String manager;
	
	
	/** 기본생성자 */
	public SpecialMember() {
		System.out.println("일반 자식 기본생성자");
	}

	/**
	 * 회원 입력 필수데이터 초기화 생성자
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 */
public SpecialMember(String memberId, String memberPw, String name, String mobile, String email) {
	
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
	
	setGrade("S");
	setEntryDate("2021-05-25");
	
	System.out.println("자식 일반 입력필수데이터 초기화생성자");

}

	 /**
	 * 우수회원 모든데이터 초기화 생성자
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 * @param entryDate 가입일 
	 * @param grade 등급
	 * @param manager 담당자
	 */
	public SpecialMember(String memberId, String memberPw, String name, String mobile, String email,
			String entryDate, String grade, String manager) {
		super(memberId, memberPw, name, mobile, email, entryDate, grade);
		this.manager = manager;
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
	public String toString() {
		return super.toString() + ", " + manager;
	}
	
	
	
}
