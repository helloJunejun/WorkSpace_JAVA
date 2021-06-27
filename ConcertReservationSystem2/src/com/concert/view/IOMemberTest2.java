package com.concert.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.concert.exception.CommonException;
import com.concert.exception.DuplicateException;
import com.concert.exception.RecordNotFoundException;
import com.concert.model.Member;
import com.concert.service.MemberService;

public class IOMemberTest2 {

	public static void main(String[] args) throws RecordNotFoundException, CommonException, DuplicateException {
		mainMenu();
			
		while(true) {			
			int menuNo = inputNumber();
			switch(menuNo) {
			case 1:
				loginMenu();
				break;
			
			case 2:
				addMemberMenu();
				break;
				
			case 0:
				System.out.println("회원관리 프로그램이 종료됩니다.");
				System.exit(0);
				break;
			default:
				System.out.println("메뉴번호 오류");
				break;
			}
		}
		
	}
	
	public static void mainMenu() {
//		System.out.println("-------------------------");
//		System.out.println("회원관리시스템 메인메뉴");
//		System.out.println("-------------------------");
		printTitle("회원관리시스템 메인메뉴");
		
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("0. 프로그램 종료");
		printLine();
		System.out.print("메뉴번호 입력 : ");
	}
	
	public static void loginMenu() throws RecordNotFoundException, CommonException, DuplicateException {
		MemberService service = new MemberService();
		
		printTitle("로그인 메뉴");
		System.out.print("아이디 : ");
		String memberId = inputString();

		System.out.print("비밀번호 : ");
		String memberPw = inputString();

		// service login 요청 처리
		service.initMember();
		boolean dto = service.login1(memberId, memberPw);
		if(dto) {
			System.out.println("로그인에 성공하였습니다.");
			memberMenu();
			
		} else {
			System.out.println("로그인에 실패하였습니다.");
			mainMenu();
		}
	}
	
	public static void printLine() {
		System.out.println("-------------------------");
	}
	
	public static void printTitle(String title) {
		System.out.println();
		printLine();
		System.out.println(title);
		printLine();
	}
	

	
	
	public static void memberMenu() {
//		System.out.println("-------------------------");
//		System.out.println("로그인 후 화면");
//		System.out.println("-------------------------");
		Member dto = new Member();
		printTitle(dto.getName() + "님 환영합니다.");
		
		System.out.println("1. 공연 정보 조회");
		System.out.println("2. 공연 예약");
		System.out.println("3. 공연 취소");
		System.out.println("4. 캐쉬 조회 및 충전 및 결제 내역");
		printLine();
		System.out.print("메뉴번호 입력 : ");
		
		while(true) {			
			int menuNo = inputNumber();
			switch(menuNo) {
			case 1:
				System.out.println("1. 공연 정보 조회");		
				break;
			case 2:
				System.out.println("2. 공연 예약");				
				break;
			case 3:
				System.out.println("3. 공연 취소");
				break;
			case 4:
				System.out.println("4. 캐쉬 조회 및 충전 및 결제 내역");
				break;
			case 0:
				System.out.println("회원관리 프로그램이 종료됩니다.");
				System.exit(0);
				break;
			default:
				System.out.println("메뉴번호 오류");
				break;
			}
		}
		
	}
	
	public static void addMemberMenu() throws DuplicateException {
		Member dto = new Member();
		MemberService service = new MemberService();
		
		printTitle("회원 가입 메뉴");
		
		System.out.print("아이디 : ");
		String memberId = inputString();
//		dto.setMemberId(memberId);

		System.out.print("비밀번호 : ");
		String memberPw = inputString();
//		dto.setMemberId(memberPw);

		System.out.print("이름 : ");
		String name = inputString();
//		dto.setMemberId(name);
		
		System.out.print("휴대폰 : ");
		String mobile = inputString();
//		dto.setMemberId(mobile);
		
		
//		dto = new Member(memberId, memberPw, name, mobile);
		
		service.addMember(memberId, memberPw, name, mobile);
		
		
		System.out.println("현재 등록회원수 : " + service.getCount());
		
		mainMenu();
		
	}
	
	
	

	// 실습1
	// 객체생성없이 사용가능한 메서드
	// 키보드로부터 읽은 데이터를 문자열로 반환하는 메서드
	public static String inputString() {
		String data = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			data = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	// 실습2
	// 객체생성없이 사용가능한 메서드
	// 키보드로부터 읽은 데이터를 int로 반환하는 메서드
	public static int inputNumber() {
		String data = null;
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			data = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Integer.parseInt(data);
	}
	
	public static void main21(String[] args) {
		System.out.println("회원 가입 메뉴");
		System.out.print("아이디 : ");
		String memberId = inputString();

		System.out.print("비밀번호 : ");
		String memberPw = inputString();

		System.out.print("이름 : ");
		String name = inputString();

		System.out.print("휴대폰 : ");
		String mobile = inputString();

		System.out.print("이메일 : ");
		String grade = inputString();

		System.out.print("마일리지 : ");
		int money = inputNumber();

		Member dto = new Member(memberId, memberPw, name, mobile, grade, money);
		
		
		System.out.println(dto);
	}

	
}
