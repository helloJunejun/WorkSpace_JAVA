package com.work.view;

public class ArrayTest1 {
	
	public static void main(String[] args) {
		//main1(); String[] args main1 에서 생략하면 null 생략가능
		System.out.println("args.length = " + args.length);
		//main2();
		main3();
	}
	/*
	 * 실습:
	 * 학생의 성적을 관리하는 프로그램
	 * 
	 * #출력형식
	 * 1번 홍길동 92
	 * 2번 강감찬 85
	 * ...
	 * 총점 : 000
	 * 평균 : 000 
	 */
	public static void main3() {
		String[] name = {"홍길동", "강감찬", "이순신", "김유신", "유관순"};
		int[] score = {92, 85, 77, 98, 65};
		int total = 0;
		int avg = 0;
		for(int i = 0; i < name.length; i++) {
			System.out.println((i+1) + "번 " + name[i] + "\t" + score[i]);
			total += score[i];
		}
		avg = total / score.length;
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
		System.out.println("평균 : " + total / 5.0); //int/ double = double
		System.out.println("평균 : " + (int)(total / 5.0)); //int(int/ double) = int
	}

		//실습 : ## 1차원 배열 : 선언 + 생성 + 명시적 초기화
	public static void main2() {
		// 5명의 학생의 이름을 관리하는 프로그램 개발
		// 5명 학생 이름 : 홍길동 강감찬 이순신 김유신 유관순
		String[] name = {"홍길동", "강감찬", "이순신", "김유신", "유관순"};
		for(int i = 0; i < name.length; i++) {
			System.out.println("학생이름 : " + name[i]);
		}
	}
	
	public static void main1() {
		// 5명의 학생의 성적관리하는 프로그램 개발
		// 5명 성적 : 92, 85, 77, 98, 65
		// 배열을 자료 저장구조 사용
		// 출력형식
		// 1번 : 92
		// 2번 : 85
		// ...
		// 총점 : 000
		// 평균 : 00 (소수이하버림처리)
		
		// 1. 배열 선언
		int[] nos;
		// 2. 배열 생성	=> guswo qodufdyth wjwkdehlsrkqt???
		nos = new int[5];
		// 3. 배열요소 사용
		// 배열요소에 학생의 성적을 순서대로 값할당
		nos[0] = 92;
		nos[1] = 85;
		nos[2] = 77;
		nos[3] = 98;
		nos[4] = 65;
		// 배열요소에 담긴 값을 전체 출력 : 배열의 크기만큼 반복하면서 배열요소의 값을 순서대로 출력
		int total = 0;
		int avg = 0;
		for(int i = 0; i < nos.length; i++) {
			System.out.println((i+1) + "번 : " + nos[i]);
			total += nos[i];
		}
		avg = total / nos.length;
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
	}

}
