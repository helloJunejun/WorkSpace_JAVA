package com.work.model.dto;

/**
 * 
 * @author 준성
 * @version ver.1.0
 * @since jdk1.8
 *
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
//		System.out.println("필수초기화생성자 수행");
		
	}
	/**
	 * 전체데이터 초기화생성자
	 * 
	 * @param studentNo 학번
	 * @param name 이름
	 * @param score 성적
	 */
	public StudentScore(String studentNo, String name, int score) {
		this(studentNo, name);
//		this.studentNo = studentNo;
//		this.name = name;
		this.score = score;
//		System.out.println("전체초기화생성자 수행");
	}
	
	/**
	 *  학생의 성적 정보 출력 메서드
	 */
	public void printInfo() {
		System.out.println(studentNo + ",\t" + name + ",\t" + score);
	}
	
	// 학생의 성적을 아규먼트로 전달받은 데이터로 변경하는 메서드
	public void setScore(int modifyScore) {
		score = modifyScore;
	}

	// 학생의 성적을 조회하는 메서드
	public int getScore() {
		return score;
	}
	
	/**
	 * 학생 이름 변경 메서드
	 * @param modifyName
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







