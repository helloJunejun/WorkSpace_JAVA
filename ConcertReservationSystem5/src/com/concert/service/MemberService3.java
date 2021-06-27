package com.concert.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import com.concert.exception.CommonException;
import com.concert.exception.DuplicateException;
import com.concert.exception.RecordNotFoundException;
import com.concert.model.Info;
import com.concert.model.Member;
import com.concert.util.Utility;

/**
 * Collection API 활용 변경
 * -- ArrayList
 * -- Generic Collection 변경
 * 
 */
public class MemberService3 {
	/** 회원들을 저장관리하기 위한 자료 저장구조 : Generic */
	public static ArrayList<Member> list = new ArrayList<Member>();
	public static ArrayList<Info> infoList = new ArrayList<Info>();
	
	
	/** 기본생성자 : 초기화 회원 등록 수행 */
	public MemberService3() {}
	
	
	/**
	 * 테스트를 위한 회원 초기화 등록 메서드
	 * @throws DuplicateException 
	 */
	public static void initMember() throws DuplicateException {
		list.add(new Member("user01", "password01", "홍길동", "01012341000", "VIP", 50000));
		list.add(new Member("user02", "password02", "강감찬", "01012342000",  "VIP", 30000));
		list.add(new Member("user03", "password03", "이순신", "01012343000",  "S", 80000));
		list.add(new Member("user04", "password04", "김유신", "01012344000", "S", 60000));
		list.add(new Member("administrator", "admin1004", "유관순", "01012345000","R", 100000));
	}
	
	/**
	 * 리스트에 추가하는 공연 등록 메서드
	 * @throws DuplicateException
	 */
	public static void initInfo() throws DuplicateException {
		infoList.add(new Info("play_001", "뮤지컬 더 리퍼", "6/12", "19:30 ~ 22:00", "문채원", "송중기", 10000));
		infoList.add(new Info("play_002", "옥탁방 고양이", "6/19", "20:00 ~ 22:00",  "남정은", "이경민", 10000));
		infoList.add(new Info("play_003", "피카츄의 대모험", "6/26", "19:30 ~ 21:30", "소니아", "금랑", 10000));
		infoList.add(new Info("play_004", "낫아웃", "7/3", "20:00 ~ 22:30", "송이재", "정재광", 10000));
		infoList.add(new Info("play_005", "행복", "7/10","19:30 ~ 21:30", "김단율", "정영성", 10000));
	}
	
		
	/** 현재 등록한 전체 회원 조회 */
	public ArrayList<Member> getMember() {
		return list;
	}
	
	/** 현재 등록한 전체 공연 조회 */
	public static void getInfo() {
		for(int index = 0; index < infoList.size();index++) {
			System.out.println("[" + (index + 1) + "번]" + infoList.get(index));
		}
	}
	
	/**
	 * 현재 등록 인원수 조회
	 * @return 현재 등록 인원수
	 */
	public int getCount() {
		return list.size();
	}
	
//	/**
//	 * 회원 등록
//	 * @param dto 등록 회원
//	 */
//	public void addMember(Member dto) throws DuplicateException {
//		int index = exist(dto.getMemberId());
//		if (index >= 0) {
//			throw new DuplicateException(dto.getMemberId());
//		}
//				
//		list.add(dto);
//	}
	
//	/**
//	 * 회원 등록
//	 * -- 사용자 입력 데이터 : 아이디, 비밀번호, 이름, 휴대폰, 이메일
//	 * -- 시스템 최초 가입시 일반회원 가입처리 : 가입일, 등급, [마일리지]
//	 * @param memberId 아이디
//	 * @param memberPw 비밀번호
//	 * @param name 이름
//	 * @param mobile 휴대폰 
//	 * @param grade
//	 * @throws money
//	 */
//	public void addMember(String memberId, String memberPw, String name, String mobile) throws DuplicateException {
//		Member dto = new Member(memberId, memberPw, name, mobile);
//
//		addMember(dto);
//	}
	
	/**
	 * 회원 존재 유무 조회
	 * @param memberId 아이디
	 * @return 존재시 저장위치 인덱스번호, 미존재시 -1
	 */
	public int exist(String memberId) {
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getMemberId().equals(memberId)) {
				return index;
			}
		}
		return -1;
	}
	

	
	
//	/**
//	 * 공연 등록
//	 * @param dto 등록 회원
//	 */
//	public void addInfo(Info dto) throws DuplicateException {
//		int index = exist(dto.getInfoCode());
//		if (index >= 0) {
//			throw new DuplicateException(dto.getInfoCode());
//		}
//				
////		list.add(dto);
//	}
	
///**
// * 공연 등록
// * @param infoCode
// * @param infoName
// * @param infoDate
// * @param infoTime
// * @param infoFemaleActor
// * @param infoMaleActor
// * @param ticketPrice
// * @throws DuplicateException
// */
//	public void addInfo(String infoCode, String infoName, String infoDate, String infoTime, String infoFemaleActor,
//			String infoMaleActor, int ticketPrice) throws DuplicateException {
//		Info dto = new Info(infoCode, infoName, infoDate, infoTime, infoFemaleActor,
//				infoMaleActor, ticketPrice);
//
//		addInfo(dto);
//	}
	
	


	/**
	 * 회원 상세조회
	 * @param memberId 회원아이디
	 * @return 존재하면 회원객체, 미존재 null
	 * @throws RecordNotFoundException 
	 * @see exist(String)
	 */
	public Member getMember(String memberId) throws RecordNotFoundException {
		int index = exist(memberId);
		if (index >= 0) {
			return (Member)list.get(index);
		}
		
		throw new RecordNotFoundException(memberId);
//		return null;
	}

	
	/**
	 * 로그인
	 * @param memberId
	 * @param memberPw
	 * @return 성공시 true, 실패시 false
	 * @throws CommonException 
	 */
	public boolean login1(String memberId, String memberPw) throws RecordNotFoundException, CommonException {
			Member dto = getMember(memberId);
			if (dto.getMemberPw().equals(memberPw)) {
				
				return true;
			} 
		return false;
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
		MemberService3 service = new MemberService3();
		
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
		MemberService3 service = new MemberService3();
		
		String cusName = null; // 예약자 성명
		int stGubun = 0; // 좌석타입
		int stNum = 0;
		int infoNum = 0;
		
		Book ss = new Book(cusName, stGubun, stNum, infoNum);
				
		while(true) {
			printTitle(memberId + "님 환영합니다.");
			
			System.out.println("1. 공연 정보 조회");
			System.out.println("2. 공연 예약");
			System.out.println("3. 공연 예약 조회");
			System.out.println("4. 캐쉬 조회 및 충전 및 결제 내역");
			printLine();
			System.out.print("메뉴번호 입력 : ");
			
			
			
			int menuNo = inputNumber();
			switch(menuNo) {
			case 1:
				service.getInfo();
				break;
			case 2:
				ss.bookSeat();
				break;
			case 3:
				ss.searchSeat();
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
		MemberService3 service = new MemberService3();
		
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
		MemberService3 service = new MemberService3();
		
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
		MemberService3 service = new MemberService3();
			printTitle("좌석 예약");
			
			
//			cusName = null; // 예약자 성명
//			stGubun = 0; // 좌석타입
//			stNum = 0;
//			infoNum = 0;
			
			Book ss1 = new Book(cusName, stGubun, stNum, infoNum);
			Book ss2 = new Book(cusName, stGubun, stNum, infoNum);
			Book ss3 = new Book(cusName, stGubun, stNum, infoNum);
			Book ss4 = new Book(cusName, stGubun, stNum, infoNum);
			Book ss5 = new Book(cusName, stGubun, stNum, infoNum);
		
					
			while(true) {
					service.getInfo();
					printLine();
					System.out.println("공연을 선택하세요");
					System.out.print("번호 : ");
					infoNum = inputNumber();
				
					printLine();
					System.out.println(service.infoList.get(infoNum-1));
					printLine();
					
				switch(infoNum) {
				case 1:
					bookSeatBody();
					break;
				case 2:
					bookSeatBody();
					break;
				case 3:
					bookSeatBody();
					break;
				case 4:
					bookSeatBody();
					break;
				case 5:
					bookSeatBody();
					break;
				case 0:
					System.out.println("회원관리 프로그램이 종료됩니다.");
					System.exit(0);
					break;
				default:
					System.out.println("공연번호 오류");
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
		MemberService3 service = new MemberService3();
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
	
	

