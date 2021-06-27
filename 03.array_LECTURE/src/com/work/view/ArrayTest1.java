package com.work.view;

public class ArrayTest1 {
	/**
	 * 자바 어프리케이션 시작메서드
	 * @param args 자바 어플리케이션 시작시에 전달받은 아규먼트 데이터
	 */
	public static void main(String[] args) {
		System.out.println("args.length = " + args.length);
		//main1();
		//main2();
		main3();
	};
	
	/* 실습 : 
	 * 학생의 성적을 관리하는 프로그램
	 * -- 5명 성적 : 92, 85, 77, 98, 65
	 * -- 5명 이름 : 홍길동 강감찬 이순신 김유신 유관순
	 * 
	 * # 출력형식
	 * 1번 홍길동 92
	 * 2번 강감찬 85
	 * ...
	 * 총점 : 000
	 * 평균 : 000
	 */
	public static void main3() {
		int[] scores = {92, 85, 77, 98, 65};
		String[] names = {"홍길동", "강감찬", "이순신", "김유신", "유관순"};
		
		int total = 0;
		for (int index = 0; index < scores.length; index++) {
			System.out.println((index + 1) + "번 " + names[index] + "\t" + scores[index]);
			total += scores[index];
		}
		
		System.out.println("총점 : " + total);
		//System.out.println("평점 : " + total / scores.length);
		System.out.println("평점 : " + total / 5.0);  // int / double = double
		System.out.println("평점 : " + (int)(total / 5.0));  // (int)(int / double) = int
	}
	
	/* 실습 : ## 1차원 배열 : 선언 + 생성 + 명시적초기화 */
	public static void main2() {
		// 5명의 학생의 이름을 관리하는 프로그램 개발
		// 5명 학생 이름 : 홍길동 강감찬 이순신 김유신 유관순
		String[] names = {"홍길동", "강감찬", "이순신", "김유신", "유관순"};
		for (int index=0; index < names.length; index++) {
			System.out.println(names[index]);
		}
	}
	
	public static void main1() {
		// 5명의 학생의 성적관리하는 프로그램 개발
		// 5명 성적 : 92, 85, 77, 98, 65
		// 배열을 자료 저장구조 사용
		
		// 출력형식 요구사항변경
		// 1번 : 92
		// 2번 : 85
		// ...
		// 총점 : 000
		// 평균 : 00 (소수이하 버림처리)
		
		// 1. 배열 선언
		int[] scores;
		
		// 2. 배열 생성	=> 현재 배열요소 저장된값???
		scores = new int[5];
		
		// 3. 배열요소 사용
		// 배열요소에 학생의 성적을 순서대로 값할당
		scores[0] = 92;
		scores[1] = 85;
		scores[2] = 77;
		scores[3] = 98;
		scores[4] = 65;
		
		// 배열요소에 담긴 값을 전체 출력 : 배열의 크기만큼 반복하면서 배열요소의 값을 순서대로 출력
		int total = 0;
		int avg = 0;
		for (int index = 0; index < scores.length; index++) {
			System.out.println((index + 1) + "번 : " + scores[index]);
			total += scores[index];
		}
		
		avg = total / scores.length;
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
	}

}
