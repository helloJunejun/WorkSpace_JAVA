package com.work.final_test;

public class FinalTest {

class B {
	public void doA() {
		System.out.println("A");
	}
	
	public final void doB() {
		System.out.println("B");
	}
}

class C extends B {
	public int count = 100;
	
	// 상수 선언
	public static final int MAX_COUNT = 30;
	
	@Override
	public void doA() {
		count = 200;
//		MAX_COUNT = 500;
		System.out.println("자식에서 재정의 변경합니다.");
	}
	// 중복정의
	public void doA(int no1, final int no2) { // local variable cannot be assigned
		no1 = 100;
//		no2 = 200;
	}
	
//	@Override
//	public void doB() {
//		System.out.println("자식에서 재정의 변경합니다.");
//	}
}

}
