package com.work.model.dto;

/**
 * <pre>
 * 학생의 성적정보 도메인 클래스 
 * </pre>
 * @author 임경혜
 * @version ver.1.0
 * @since jdk1.8
 */
public class StudentScore {
	/** 학번 : 식별키 */
	public String studentNo = "210517";
	
	/** 이름 : 필수 */
	public String name;
	
	/** 성적 : 선택 */
	public int score;
	
	
	/** 기본 생성자 */
	public StudentScore() {
		System.out.println("기본생성자 수행 : 객체생성시 공통로직 : 바람출력");
	}
	
	/**
	 * 필수 데이터 초기화 생성자
	 * @param studentNo 학번
	 * @param name 이름
	 */
	public StudentScore(String studentNo, String name) {	
		this();
		this.studentNo = studentNo;
		this.name = name;
		//System.out.println("필수초기화생성자 수행 : 달출력");
	}
	
	/**
	 * 전체데이터 초기화생성자
	 * 
	 * @param studentNo 학번
	 * @param name 이름 
	 * @param score 점수
	 */
	public StudentScore(String studentNo, String name, int score) {
		this(studentNo, name);
//		this.studentNo = studentNo;
//		this.name = name;
		this.score = score;
		//System.out.println("전체초기화생성자 수행 : 별출력");
	}
	
	
	/**
	 * 학생의 성적 정보 출력 메서드 
	 */
	public void printInfo() {
		System.out.println(studentNo + ",\t" + name + ",\t" + score);
	}
	
	/**
	 * 성정 변경 메서드
	 * @param modifyScore 변경 성적
	 */
	public void setScore(int modifyScore) {
		score = modifyScore;
	}

	/**
	 * 학생 성적 조회 메서드
	 * @return 학생 성적
	 */
	public int getScore() {
		return score;
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







