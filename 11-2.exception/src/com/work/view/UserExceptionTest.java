package com.work.view;

import com.work.exception.UserException;

public class UserExceptionTest {

	public static void main(String[] args) {
//		doA("G"); // static 메서드인 main() 메서드는 같은 클래스에 있는 인스턴스 메서드는 객체생성후 사용가능
		UserExceptionTest a = new UserExceptionTest();
		try {
		a.doA("x");
		} catch(UserException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("정상 종료");
	}
		
		/**
		 * -- grade "G", "S", "A"가 아니면 사용자예외(UserException) 발생
		 * -- throw new 사용자예외클래스명();
		 * 
		 */
		public void doA(String grade) throws UserException {
			switch(grade) {
			case "G":
			case "S":
			case "A":
				break;
			default:
//				System.out.println("[오류] 등급은 G, S, A만 해당됩니다.");
				throw new UserException();
			}
			
			
		}
		
	

}
