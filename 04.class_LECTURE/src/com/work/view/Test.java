package com.work.view;

import com.work.model.dto.StudentScore;

public class Test {
	
	// 메서드를 사용해서 생성객체의 정보를 변경
	// 메서드를 사용해서 생성객체의 정보를 출력 
	public static void main(String[] args) {
		StudentScore dto1 = new StudentScore();
		StudentScore dto2 = new StudentScore();
		StudentScore dto3 = new StudentScore();
		StudentScore dto4 = new StudentScore();
		StudentScore dto5 = new StudentScore();
		
		dto1.studentNo = "1번";
		dto1.setName("홍길동");
		dto1.setScore(92);
		//System.out.println(dto1.printInfo());
		dto1.printInfo();
		
		dto1.setScore(77);
		dto1.printInfo();
	}
	

	/*
	 * # 학생의 성적을 참고로해서 5명의 학생성적객체를 생성해서 
	 *   생성된객체의 각각의 멤버변수 정보를 아래의 정보로 변경
	 * # 정보를 변경한후 학생의 성적정보를 출력
	 * 
	 * # 출력형식 : 1번 홍길동 92
	 *  
	 *  -- 학번 : 1번, 2번, 3번, 4번, 5번
	 * 	-- 성적 : int[] scores = {92, 85, 77, 98, 65};
	 *  -- 이름 : String[] names = {"홍길동", "강감찬", "이순신", "김유신", "유관순"};
	 *  
	 *  #
	 */
	public static void main2(String[] args) {
		StudentScore dto1 = new StudentScore();
		dto1.studentNo = "1번";
		dto1.name = "홍길동";
		dto1.score = 92;

		StudentScore dto2 = new StudentScore();
		dto2.studentNo = "2번";
		dto2.name = "강감찬";
		dto2.score = 85;

		StudentScore dto3 = new StudentScore();
		dto3.studentNo = "3번";
		dto3.name = "이순신";
		dto3.score = 77;

		StudentScore dto4 = new StudentScore();
		dto4.studentNo = "4번";
		dto4.name = "김유신";
		dto4.score = 98;

		StudentScore dto5 = new StudentScore();
		dto5.studentNo = "5번";
		dto5.name = "유관순";
		dto5.score = 65;

		System.out.println(dto1.studentNo + "\t" + dto1.name + "\t" + dto1.score);
		System.out.println(dto2.studentNo + "\t" + dto2.name + "\t" + dto2.score);
		System.out.println(dto3.studentNo + "\t" + dto3.name + "\t" + dto3.score);
		System.out.println(dto4.studentNo + "\t" + dto4.name + "\t" + dto4.score);
		System.out.println(dto5.studentNo + "\t" + dto5.name + "\t" + dto5.score);
	}
	
	public static void main1(String[] args) {
		StudentScore dto = new StudentScore();
		
		// 생성한 객체의 여러분의 정보 변경 
		dto.studentNo = "201531775";
		dto.name = "김혜진";
		dto.score = 87;

		// 생성한 객체의 정보(학번, 이름, 성적) 출력
		System.out.println(dto.studentNo);
		System.out.println(dto.name);
		System.out.println(dto.score);
	}

}
