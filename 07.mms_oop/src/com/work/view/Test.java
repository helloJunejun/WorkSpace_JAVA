package com.work.view;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

public class Test {
	// instanceof, typecasting, virtual method invocation 테스트
	public static void main(String[] args) {
		// 회원 초기화데이터 참고로해서 회원 5명 객체 생성
		// 참조변수 타입은 부모타입 : 변수 다형성
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 5000);
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2020-12-15", "G", 95000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-12-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2020-12-15", "S", "김하린");
		Member dto5 = new AdminMember("adminstrator", "admin1004", "유관순", "01012345000", "adminstrator@work.com", "2020-12-15", "A", "선임");
		System.out.println(dto1); // 자식이 재정의해놓은 자식의 toString() 호출수행
		System.out.println(dto2);
		System.out.println(dto3);
		System.out.println(dto4);
		System.out.println(dto5);
		
		dto1.getMemberId();
//		dto1.getMileage(); // error : 부모타입의 참조변수는 자식의 멤버 접근 불가
		
		// 실제 메모리에 생성된 자식객체타입으로 형변환 => 실제 자식객체의 멤버 접근가능
		GeneralMember g1 = (GeneralMember)dto1;
		System.out.println(g1); // 자식이 재정의해놓은 자식의 toString() 호출수행
		g1.getMileage(); // ok
		
		// 형변환하기전에 해당 클래스의 객체(intanceof) 여부 체킹
		if(dto1 instanceof AdminMember) {
		// 컴파일 ok : 문법체크
		AdminMember a1 = (AdminMember)dto1;
		// 실행 error
		a1.getPosition();
		} else {
			System.out.println("[오류] 해당 클래스의 인스턴스가 아닙니다.");
		}
	}
	// 재정의 테스트
	public static void main2(String[] args) {
		Member dto1 = new Member("user01", "password01", "홍길동", "01012341234", "user01@work.com");
		System.out.println(dto1); // 어떤클래스의 toString() 결과?? 부모 재정의
		// toString() 재정의하지 않는 경우 : com.work.model.dto.Member@15db9742
		
		// 일반회원객체 생성
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012341000", "user02@work.com");
		System.out.println(dto2); // 어떤클래스의 toString() 결과?? 자식 재정의
	}
	
	
	// 부모타입의 다형성 : 모든 자식객체를 참조(저장) 기능
	public static void main1(String[] args) {
		// ok : 같은 타입 자동할당 : 다형성 변수타입
		Member dto1 = new Member();
				
		// ok : 부모타입(상속) : 큰타입
		Member dto2 = new GeneralMember();
		
		// ok : 부모타입(상속) : 큰타입
		Member dto3 = new SpecialMember();
		
		// error : 다른타입, 작은(자식)타입, 즉 부모객체를 자식객체에 저장(참조)불가
		// GeneralMember dto4 = new Member();
		
		// error : 다른타입, 
		// GeneralMember dto5 = new AdminMember();
	}
}
