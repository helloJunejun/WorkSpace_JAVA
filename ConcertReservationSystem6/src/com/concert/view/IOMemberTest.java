package com.concert.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.concert.exception.CommonException;
import com.concert.exception.DuplicateException;
import com.concert.exception.RecordNotFoundException;
import com.concert.model.Member;
import com.concert.service.MemberService;

public class IOMemberTest {

	public static void main(String[] args) throws RecordNotFoundException, CommonException, DuplicateException {
		MemberService service = new MemberService();
		service.initMember();
		service.initInfo();
		
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
		boolean dto = service.login1(memberId, memberPw);
		
		if(dto && (memberId.equals("administrator"))) {
			System.out.println("관리자 로그인에 성공하였습니다.");
			adminMenu();
			
		} else if(dto) {
			System.out.println("로그인에 성공하였습니다.");
			memberMenu(memberId);
			
		} else {
			
			System.out.println("로그인에 실패하였습니다.");
			mainMenu();
		}
	}
	
	
	
	public static void memberMenu(String memberId) throws RecordNotFoundException {
				
		String cusName = null; // 예약자 성명
		int stGubun = 0; // 좌석타입
		int stNum = 0;
		int infoNum = 0;
		
		Book ss = new Book(cusName, stGubun, stNum, infoNum);
				
		while(true) {
			printTitle(memberId + "님 환영합니다.");
			
			System.out.println("1. 공연 정보 조회");
			System.out.println("2. 공연 예약");
			System.out.println("3. 공연 취소");
			System.out.println("4. 캐쉬 조회 및 충전 및 결제 내역");
			printLine();
			System.out.print("메뉴번호 입력 : ");
			
			
			
			int menuNo = inputNumber();
			switch(menuNo) {
			case 1:
				ss.searchSeat();
				break;
			case 2:
				ss.bookSeat();
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
	
	public static void adminMenu() {

		while(true) {
			printTitle("관리자님 환영합니다.");
			
			System.out.println("1. 예약 전체 조회");
			System.out.println("2. 공연 추가");
			System.out.println("3. 공연 수정");
			System.out.println("4. 공연 삭제");
			printLine();
			System.out.print("메뉴번호 입력 : ");
			
			int menuNo = inputNumber();
			switch(menuNo) {
			case 1:
//				mainSearch();
				break;
			case 2:
//				mainBook();
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
		MemberService service = new MemberService();
		
		printTitle("회원 가입 메뉴");
		
		System.out.print("아이디 : ");
		String memberId = inputString();

		System.out.print("비밀번호 : ");
		String memberPw = inputString();


		System.out.print("이름 : ");
		String name = inputString();

		
		System.out.print("휴대폰 : ");
		String mobile = inputString();

		if(service.exist(memberId) >= 0) {
			System.out.println("---------중복된 ID입니다.---------");
		} else {
		service.list.add(new Member(memberId, memberPw, name, mobile));
		}
		
		System.out.println("현재 등록회원수 : " + service.getCount());
		
		mainMenu();
		
	}
	
	public static void addInfoMenu() throws DuplicateException {
		MemberService service = new MemberService();
		
		printTitle("회원 가입 메뉴");
		
		System.out.print("아이디 : ");
		String memberId = inputString();

		System.out.print("비밀번호 : ");
		String memberPw = inputString();


		System.out.print("이름 : ");
		String name = inputString();

		
		System.out.print("휴대폰 : ");
		String mobile = inputString();

		if(service.exist(memberId) >= 0) {
			System.out.println("중복된 ID입니다.");
		} else {
		service.list.add(new Member(memberId, memberPw, name, mobile));
		}
		
		System.out.println("현재 등록회원수 : " + service.getCount());
		
		mainMenu();
		
	}
	
	
	
	public static class Book{
		String cusName; // 예약자 성명
		int stGubun; // 좌석타입
		int stNum; // 좌석번호
		int infoNum; // 공연 번호
		static String[][] seats = new String[3][10]; // 좌석구분 - VIP S R 각 10석씩.
		static String[] list = {"VIP","S","R"};
		
		public Book(String cusName, int stGubun, int stNum, int infoNum) {
			this.cusName = cusName;
			this.stGubun = stGubun;
			this.stNum = stNum;
			this.infoNum = infoNum;
			
			for(int i = 0 ; i < 3 ; i++) {
				for(int j = 0; j < 10 ; j++) {
					seats[i][j] = "__";
				}
			}
		}
		
	public void bookSeat() { // 좌석예약
		MemberService service = new MemberService();
			printTitle("좌석 예약");
			
			
			cusName = null; // 예약자 성명
			stGubun = 0; // 좌석타입
			stNum = 0;
			infoNum = 0;
			
			Book ss1 = new Book(cusName, stGubun, stNum, infoNum);
			Book ss2 = new Book(cusName, stGubun, stNum, infoNum);
			Book ss3 = new Book(cusName, stGubun, stNum, infoNum);
			Book ss4 = new Book(cusName, stGubun, stNum, infoNum);
			Book ss5 = new Book(cusName, stGubun, stNum, infoNum);
						
				System.out.println(service.getInfo());
				printLine();
				System.out.println("공연을 선택하세요");
				System.out.print("번호 : ");
				infoNum = inputNumber();
			
				System.out.println("---------------------------");
				System.out.println(service.infoList.get(infoNum-1));
				System.out.println("---------------------------");
				
			while(true) {
				switch(infoNum) {
				case 1:
					ss1.bookSeatBody();
					break;
				case 2:
					ss2.bookSeatBody();
					break;
				case 3:
					ss3.bookSeatBody();
					break;
				case 4:
					ss4.bookSeatBody();
					break;
				case 5:
					ss5.bookSeatBody();
					break;
				case 0:
					System.out.println("회원관리 프로그램이 종료됩니다.");
					System.exit(0);
					break;
				default:
					System.out.println("메뉴번호 오류");
					break;
				}
				break;
			}
			
	}			
			
	public static void bookSeatBody() {
	while(true) {
		System.out.println("성명을 입력하세요");
		System.out.print("성명 : ");
		String cusName = inputString();
		System.out.println("원하시는 좌석등급을 선택하세요. VIP석 = 1/S석 = 2/R석 = 3 (숫자로 입력해주세요)");
		System.out.print("좌석등급 : ");
		int stGubun = inputNumber()-1;
		System.out.println("원하시는 좌석번호을 선택하세요. 1~10번");
		System.out.print("좌석번호 : ");
		int stNum = inputNumber()-1;
     		if(stNum>10){
     			System.out.println("잘못된 좌석번호 입니다. 다시 입력해주세요.");
     			stNum = inputNumber();
     		}
     		if(seats[stGubun][stNum].equals(cusName)){
     			System.out.println("이미 예약된 자리입니다.다시 시도해주세요.");
     	}
     	seats[stGubun][stNum] = (cusName);
     	break;
	}
}
	
	
	public void searchSeat() { // 좌석조회 및 출력
		// 조회 - 조회는 모든 좌석을 출력한다.
		MemberService service = new MemberService();
		System.out.println();
		System.out.println("-------공연 좌석 조회-------");
		System.out.println(service.infoList.get(infoNum-1));
		System.out.print("-------------------------");
		for (int i = 0; i < 3; i++) {
            System.out.print("\n" + list[i] + "석 ");
            for (int j = 0; j < 10; j++) {
                System.out.print(" "+ seats[i][j]);
            }
        }
		System.out.println();
		System.out.println();
		printLine();
	}
	
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
	
	
	public static void printLine() {
		System.out.println("-------------------------");
	}
	
	public static void printTitle(String title) {
		System.out.println();
		printLine();
		System.out.println(title);
		printLine();
	}
	
}
