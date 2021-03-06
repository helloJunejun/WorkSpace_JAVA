package com.work.view;

public class ifTest {
	/* 실습 : if ~ else if ~ else 구문을 switch 구문으로 변경*/
	public static void main(String[] args) {
		int score = 100;
		String grade = null;
		
	if (score >= 0 & score <= 100) {
		switch (score/10) {
		case 10:
		case 9: grade = "A";
			break;
		case 8: grade = "B";
			break;
		case 7 : grade = "C";
			break;
		case 6 : grade = "D";
			break;
		default : grade = "F";
			break;
		}
		System.out.println("점수 : " + score + " 등급 : " + grade);
	} else {
		System.out.println("[오류] 성적은 0 ~ 100점 이내입니다." + score);
	}
	}
	
	
	/* 실습
	 * 성적에 따라 등급을 출력하는 프로그램을 완성하세요
	 * 성적은 0 ~ 100점 이내
	 * A : 90 ~ 100점
	 * B : 80 ~ 89점
	 * C : 70 ~ 79점
	 * D : 60 ~ 69점
	 * F : 0 ~ 59점
	 * 
	 * 출력형식
	 * 00점 0등급
	 * 00점 0등급 => 점수 : 00 등급 : 0
	 */
	public static void main3(String[] args) {
		
		int score = 90;
		String grade = null;
		
		if (score >= 0 & score <= 100) {
			if (90 <= score) {
				grade = "A";
			} else if (80 <= score) {
				grade = "B";
			} else if (70 <= score) {
				grade = "C";
			} else if (60 <= score) {
				grade = "D";
			} else {
				grade = "F";
			}
			System.out.println("점수 : " + score + "  등급 : " + grade);
		} else {
			System.out.println("[오류] 성적은 0 ~ 100점 이내입니다." + score);
		}
	}

	public static void main1(String[] args) {
		// 성적을 변수에 저장
		int score = 70;
		
		// 성적이 70점 이상이면 합격출력
		if (score>=70) {
			System.out.println(score + " 합격");
		} else {
			System.out.println(score + " 불합격");
		}
		
	}

}
