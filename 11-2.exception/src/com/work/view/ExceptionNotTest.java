package com.work.view;

public class ExceptionNotTest {
	
		public static void main(String[] args) {
			System.out.println("프로그램 시작");
			
			// 이름 : 홍길동, 강감찬, 이순신 : 배열에 저장, 선언 + 생성 + 초기화 동시수행
			
			String[] names = {"홍길동", "강감찬", "이순신"};
			
			// for 구문 이용해서 5번 반복하면서 배열저장된 이름정보를 출력
			for(int index = 0; index < 5; index++) {
				System.out.println(names[index]);
			}
			
			/*
			 * 수행결과?
			 * 예측 : 3번까지 다 나오고 오류 발생
			 */
			
			
			System.out.println("프로그램 정상 종료");
		}
}
