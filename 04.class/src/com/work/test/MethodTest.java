package com.work.test;

public class MethodTest {

	public static void main(String[] args) {
		// MethodType 객체를 test 참조변수로 선언 및 생성
		MethodType test = new MethodType();

		// jdk1.5 for : 반복조건을 명시
		for (int index = 0; index < 5; index++) {
		test.doA();
//		test.doA();
//		test.doA();
//		test.doA();
//		test.doA();
 	}
		
		// 문자열 배열을 사용해서 인사말 정보를 저장 : 
		// 선언 + 생성 + 명시적초기화 동시
		String[] hello = {"안녕하세요", "반갑습니다", "다음에 또 봬요", "곰방와", "Hello"};
		// jdk1.5 for
		// 반복회수 지정하지 않음 : 배열 담긴 갯수만큼(items) 자동으로 반복하면서 한개씩 가져와서 할당
		// 배열객체, collection API 사용가능
		// 형식 : for (타입 변수명 : 배열명 또는 collection객체참조변수명) {}
		for (String message : hello) {
			test.doB(message);
		}
		
		test.doC();
		int result = test.doC();
		System.out.println(result);
		System.out.println(test.doC());
		
		System.out.println();
		result = test.add(100, 1234);
		System.out.println(result);
		
		test.add(100, 200); // int, int
		test.add(100L, 200); // long, int => long, long
		test.add(100, 200L); // int, long => long, long
		test.add(100L, 200L); // long, long
		
		test.add(100, 200F); // int, float => double, double
				
	}

}
