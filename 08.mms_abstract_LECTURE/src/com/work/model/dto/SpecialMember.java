/**
 * 
 */
package com.work.model.dto;

/**
 * <pre>
 * 우수 회원 도메인 클래스 
 * -- 회원(부모클래스)의 자식(상속)
 * 
 * # 우수회원 속성
 * 1. 아이디
 * 2. 비밀번호
 * 3. 이름
 * 4. 휴대폰
 * 5. 이메일
 * 6. 가입일
 * 7. 등급
 * 
 * 8. 담당자
 *  
 * </pre>
 * @author 임경혜
 * @version ver.1.0
 * @since jdk1.8
 */
public class SpecialMember extends Member {
	/** 우수회원 담당자 */
	private String manager;
	
	/** 기본생성자 */
	public SpecialMember() {}

	/**
	 * 회원 입력 필수데이터 초기화 생성자
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름 
	 * @param mobile 휴대폰
	 * @param email 이메일
	 */
	public SpecialMember(String memberId, String memberPw, String name, String mobile, String email) {
		setMemberId(memberId);
		setMemberPw(memberPw);
		setName(name);
		setMobile(mobile);
		setEmail(email);
		
		setGrade("S");
		setEntryDate("2021-05-26");
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
	public SpecialMember(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, String manager) {
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
