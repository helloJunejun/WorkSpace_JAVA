package com.work.view;

import com.work.model.dto.StudentScore;
import com.work.model.service.StudentScoreService;

/**
 * <pre>
 * 학생 성적 관리 프로그램 시작 클래스
 * </pre>
 * 
 * @author 임경혜
 * @version ver.1.0
 * @since jdk.1.8
 * @see com.work.model.dto.StudentScore
 * @see com.work.model.service.StudentScoreService
 */
public class Test {
	
	/* this() 테스트 */
	public static void main3(String[] args) {
		StudentScore dto3 = new StudentScore("3번", "이순신", 88);
		dto3.printInfo();
	}
	
	/* 생성자 테스트 */
	public static void main2(String[] args) {
		// 기본생성자 이용한 객체 생성
		StudentScore dto1 = new StudentScore();
		dto1.studentNo = "1번";
		dto1.setName("홍길동");
		dto1.setScore(92);
		
		// 필수초기화생성자 이용한 객체 생성
		StudentScore dto2 = new StudentScore("2번", "강감찬");
		dto2.setScore(92);
		
		// 전체초기화생성자 이용한 객체 생성
		StudentScore dto3 = new StudentScore("3번", "이순신", 88);
		
		dto1.printInfo();
		dto2.printInfo();
		dto3.printInfo();
	}

	/**
	 * {92, 85, 77, 98, 65};
	 * 학생 성적 관리 프로그램 시작 메서드
	 * @param args 시작시 전달받은 문자열타입 배열정보
	 */
	public static void main(String[] args) {
		StudentScoreService service = new StudentScoreService(100); // 회원들의자료저장구조 배열객체 100개 생성
		
		// 회원들의자료저장구조 배열을 접근해서 변경 가능
		//service.students = null; 
		
		System.out.println("\n### 등록");
		service.addStudentScore("1번", "홍길동", 92);		// null => 배열객체 접근 불가 => NullPointerException 예외발생 강제종료
		service.addStudentScore("2번", "강감찬", 85);
		service.addStudentScore("3번", "이순신", 77);
		service.addStudentScore("4번", "김유신", 98); // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
		service.addStudentScore("5번", "유관순", 65);
		
//		service.students = null;	
		// 기존 학생들의 성적정보가 저장된 배열객체가 메모리에서 사라짐 => 학생들의성적정보 유실(엄청난문제)
		// public => private 접근권한 변경으로 인해서 외부에서 함부로 변경불가 (보안문제 해결)
		
		//System.out.println("\n### 성적 등록 학생수 : " + service.count);
		System.out.println("\n### 성적 등록 학생수 : " + service.getCount());
		
		//service.count = 500; // => 학생등록 숫자 및 다음에 저장될 배열요소 인덱스번호 문제
		service.addStudentScore("1번", "홍길동", 92);  // java.lang.ArrayIndexOutOfBoundsException: 500 실행시 예외발생
		
		System.out.println("\n### 전체 학생 성적 조회");
		service.printStudentScore(); // null => 배열객체 접근 불가 => NullPointerException 예외발생 강제종료
	}

}
