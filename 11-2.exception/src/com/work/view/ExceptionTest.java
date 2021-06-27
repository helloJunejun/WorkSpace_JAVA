package com.work.view;

public class ExceptionTest {
	
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
			
			
			String[] names = {"홍길동", "강감찬", "이순신"};
			String data = null;
			
			for(int index = 0; index < 5; index++) {
				try {
//					System.out.println(names[index]); // 예외 발생 가능 코드
//					System.out.println(data.length()); // null.length() => NullPointerException 발생
					System.out.println(5 / 0); // ArithmeticException
					
					String message = "안녕예외!";
					System.out.println(message);
					
//					StringBuilder builder = (StringBuilder)message; // ClassCastException
					int mileage = Integer.parseInt(""); // NumberFormatException
					
				} catch(ArrayIndexOutOfBoundsException e) {
					String message = e.getMessage();
					System.out.println("[오류처리]잘못된 배열요소 번호 : " + message);
					break;
				} catch(NullPointerException e) {
					System.out.println("[오류메세지]" + e.getMessage());
					break;
				} catch(Exception e) {
					System.out.println("[오류메세지] : " + e.getMessage());
					System.out.println("[오류클래스] : " + e.getClass().getName());
					break;
				} finally {
					System.out.println("[반드시 수행되는 로직]");
				}
			}
			
			
			System.out.println("프로그램 정상 종료");
		}
	
	public static void main2(String[] args) {
	System.out.println("프로그램 시작");
		
		
		String[] names = {"홍길동", "강감찬", "이순신"};
		String data = null;
		
		for(int index = 0; index < 5; index++) {
			try {
//				System.out.println(names[index]); // 예외 발생 가능 코드
				System.out.println(data.length()); // null.length() => NullPointerException 발생
				
			} catch(ArrayIndexOutOfBoundsException e) {
				String message = e.getMessage();
				System.out.println("[오류처리]잘못된 배열요소 번호 : " + message);
				break;
			} finally {
				System.out.println("[반드시 수행되는 로직]");
			}
		}
		
		
		System.out.println("프로그램 정상 종료");
	}

	public static void main1(String[] args) {
		System.out.println("프로그램 시작");
		
		
		String[] names = {"홍길동", "강감찬", "이순신"};
		
		for(int index = 0; index < 5; index++) {
			try {
				System.out.println(names[index]); // 예외 발생 가능 코드
			} catch(ArrayIndexOutOfBoundsException e) {
				String message = e.getMessage();
				System.out.println("[오류처리]잘못된 배열요소 번호 : " + message);
				break;
			} finally {
				System.out.println("[반드시 수행되는 로직]");
			}
		}
		
		
		System.out.println("프로그램 정상 종료");

	}

}
