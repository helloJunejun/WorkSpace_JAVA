package com.work.view;

public class LoopTest {
	
	/*
	 * 1 ~ 5까지 출력하면서 누적된 결과를 출력해보세요
	 * while 구문
	 * do ~ while 구문 이용 
	 */
	public static void main(String[] args) {
		
		int total = 0;
		System.out.println("\n1. for 구문");
		for (int i = 1; i <= 5; i++ ) {
			System.out.println(i);
			total += i;
		}
		System.out.println("total = " + total);
		
		total = 0;
		System.out.println("\n2. while 구문");
		int i = 1;
		while(i<=5) {
			System.out.println(i);
			total += i;
			i++;
		}
		System.out.println("total = " + total);

		total = 0;
		i = 1;
		System.out.println("\n3. do~while 구문");
		do {
			System.out.println(i);
			total += i;
			i++;
		} while(i <= 5);
		System.out.println("total = " + total);
		}
	
	
		
	
	public static void main2(String[] args) {
		/*
		 * 실습 : 영문 대문자에 대한 ascii code를 출력하는 프로그램을 작성하세요.
		 * 힌트 : 영문은 알파벳 26자, type casting(형변환)
		 * 출력형식
		 * A : 65
		 * B : 66
		 * ...
		 * Z : xx
		 */
		for(char i = 'A'; i <= 'Z'; i++) {
			System.out.println(i + " : " + (int)i);
			
			
		}
	}

	public static void main1(String[] args) {
		// for 구문을 이용해서 1 ~ 10 까지 출력하면서 누적된 결과를 출력해보세요.
		//짝수만 누적해서 출력
		
		int total = 0;
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
			System.out.println(i);
			total += i; // total = total + i;
			}
		}
		System.out.println("total : " + total);

	}

}
