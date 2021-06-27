package com.work.model.service;

import com.work.model.dto.StudentScore;

/**
 * <pre>
 * 학생 성적관련 서비스 제공 클래스
 * 1. 등록 기능 : + addStudentScore(학번, 이름, 성적) : void
 * 2. 조회 기능
 * 		>> 전체학생성적조회기능 : + printStudentScore
 * 3. 총점 계산 기능
 * 4. 평균 계산 기능
 * </pre>
 * @author 준성
 * @version ver.1.0
 * @since jdk.1.8
 * @see com.work.model.dto.StudentScore
 * @see com.work.model.dtoStudentScore#printInfo()
 *
 */
public class StudentScoreService {
	/** 학생들의 성적정보 객체를 그룹으로 관리하기 위한 자료 저장구조 : 필요시에 확장하도록 처리 */
	//public StudentScore[] students = new StudentScore[3];
	
	/** 학생들의 성적정보 객체를 그룹으로 관리하기 위한 자료 저장구조 멤버변수 선언 : 배열객체 생성은 생성자 위임처리*/
	private StudentScore[] students;
	
	/** 등록된 학생의 숫자 정보 및 등록해야하는 배열요소의 인덱스번호 정보
	 * -- 접근권한 : public => private 변경 (외부에서 함부로 변경할 수 없음 : 보안데이터)
	 * 등록 학생수 조회 제공 : getter()
     */
	private int count;
	
	/** 기본생성자 : 배열의 크기를 기본 10개 초기화 */
	public StudentScoreService() {
		//students = new StudentScore[10];
		this(10);
	}
	/**
	 * 배열의 크기를 전달받아서 배열생성 할당 초기화 생성자
	 * @param length
	 */
	public StudentScoreService(int length) {
		students = new StudentScore[length];	
	}
	/** 실습 : 현재 등록한 학생성적의 숫자 조회 메서드 */
	public int getCount() {
		return count;
	}
	
	// 1. 등록 기능 : + addStudentScore(학번, 이름, 성적) : void : 메서드 선언 실습
	/**
	 * <pre>
	 * 학생성적 등록 메서드
	 * -- 등록결과 메세지 출력
	 * -- 성공 : 등록 성공
	 * -- 실패 : 등록 실패
	 * </pre>
	 * @param studentNo 학번
	 * @param name 이름
	 * @param score 성적
	 * 
	 * # 처리 수행절차
	 * 1.StudentScore 객체 생성
	 * 2.아규먼트로 전달받은 정보로 생성 객체 정보 설정
	 * 3.생성된 객체를 배열요소 count 요소위치에 등록
	 * 4.count 등록인원을 1 증가
	 */
	public void addStudentScore(String studentNo, String name, int score) {
		
		StudentScore dto = new StudentScore();
		dto.studentNo = studentNo;
		dto.name = name;
		dto.score = score;
		
		addStudentScore(dto);
		
		} 		
		
	
	// 실습 : 등록메서드 중복정의 : StudentScore 매개변수 전달받음
	public void addStudentScore(StudentScore dto) {	
		if(count == students.length) {
			extendStudents(10);
			System.out.println("학생들의 자료저장구조를 추가 확장하였습니다.");
		}
		students[count++] = dto;
		
		
//		if(students.length == count) {
//			students = new StudentScore[count+10];
//			System.out.println("학생 저장 수를 늘렸씁니다.");
//	}
 }
	
	public void extendStudents(int length) {
		StudentScore[] studentsTemp = new StudentScore[students.length + length];
		
		for(int index = 0; index < students.length; index++) {
			studentsTemp[index] = students[index];
		}
		students = studentsTemp;
	}
	/**
	 * 전체학생 성적 조회 메서드
	 */
	public void printStudentScore() {
		for(int index = 0; index < count; index++) {
			students[index].printInfo();
		}
	}
}

















