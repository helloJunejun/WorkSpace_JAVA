package com.work.model.dto;

/**
 * <pre>
 * 회원 정보 도메인 클래스 
 * </pre>
 * @author 유준성
 * @version ver.1.0
 * @since jdk1.8
 */



public class Member {
	/** 회원id : 식별키 */
	public String memberId;
	
	/** 회원등급 : 필수 */
	public String grade;
	
	/** 포인트 : 필수 */
	public int point;
	
	/** 이름 : 필수 */
	public String name;
	
	/** 비밀번호 : 필수 */
	public int passWord;
	
	
	/** 기본 생성자 */
	public Member() {
		System.out.println("기본생성자 수행 : 객체생성시 공통로직 : 바람출력");
	}
	
	
	/**
	 * 필수 데이터 초기화 생성자
	 * @param memberNo 회원식별
	 * @param name 이름
	 */
	public Member(String memberId, String grade, int point, String name, int passWord) {	
//		this(memberId, name, passWord);
		this.memberId = memberId;
		this.grade = grade;
		this.point = point;
		this.name = name;
		this.passWord = passWord;
		//System.out.println("필수초기화생성자 수행 : 달출력");
	}
	
	/**
	 * 학생의 성적 정보 출력 메서드 
	 */
	public void printInfo() {
		System.out.println(memberId + ",\t" + name + ",\t" + passWord);
	}
	
	/**
	 * 성적 변경 메서드
	 * @param modifyScore 변경 성적
	 */
	public void setScore(int modifyScore) {
		passWord = modifyScore;
	}

	/**
	 * 학생 성적 조회 메서드
	 * @return 학생 성적
	 */
	public int getScore() {
		return passWord;
	}
	
	/**
	 * 학생 이름 변경 메서드
	 * @param modifyName 변경 이름
	 */
	public void setName(String modifyName) {
		name = modifyName;
	}
	
	/**
	 * 학생 이름 조회 메서드
	 * @return 학생 이름
	 */
	public String getName() {
		return name;
	}
	
	
}