package com.work.test;
/*'
 * 	1. 매개변수 없고, 반환타입 없음
	2. 매개변수 있고, 반환타입 없음
	3. 매개변수 없고, 반환타입 있음
	4. 매개변수 있고, 반환타입 있음
 */

public class MethodType {
	// 1. 매개변수 없고, 반환타입 없음
	public void doA() {
		System.out.println("안녕");
	}
	// 2. 매개변수 있고, 반환타입 없음
	public void doB(String message) {
		System.out.println(message);
	}
	// 3. 매개변수 없고, 반환타입 있음
	public int doC() {
		System.out.println("call doC()");
		return 1004;
	}
	// 4. 매개변수 있고, 반환타입 있음
	// 2개의 정수 데이터를 매개변수로 받아서
	// 매개변수로 전달받은 데이터의 덧셈결과를 반환하는 메서드
	public int add(int op1, int op2) {
		System.out.println("int, int");
		return op1 + op2;
	}
	// 메서드 중복정의
	// 매개변수 타입의 다형성(매개변수 자동 형변환)
	public long add(long op1, long op2) {
		System.out.println("long, long");
		return op1 + op2;
	}
	public double add(double op1, double op2) {
		System.out.println("double, double");
		return op1 + op2;
	}
}
