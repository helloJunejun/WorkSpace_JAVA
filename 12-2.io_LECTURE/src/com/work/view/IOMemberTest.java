package com.work.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.work.model.dto.Member;

public class IOMemberTest {

	public static void main(String[] args) {
		while(true) {
			mainMenu();
			int menuNo = inputNumber();
			switch(menuNo) {
			case 1:
				//System.out.println("1. 로그인");
				loginMenu();
				break;
			case 2:
				//System.out.println("2. 회원가입");
				addMemberMenu();
				break;
			case 3:
				System.out.println("3. 아이디찾기");
				break;
			case 4:
				System.out.println("4. 비밀번호찾기");
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
	
	public static void loginMenu() {
		printTitle("로그인 메뉴");
		System.out.print("아이디 : ");
		String memberId = inputString();

		System.out.print("비밀번호 : ");
		String memberPw = inputString();

		// service login 요청 처리
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
	
	public static void mainMenu() {
//		System.out.println("-------------------------");
//		System.out.println("회원관리시스템 메인메뉴");
//		System.out.println("-------------------------");
		printTitle("회원관리시스템 메인메뉴");
		
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		System.out.println("3. 아이디찾기");
		System.out.println("4. 비밀번호찾기");
		System.out.println("0. 프로그램 종료");
		printLine();
		System.out.print("메뉴번호 입력 : ");
	}
	
	public static void addMemberMenu() {
		printTitle("회원 가입 메뉴");
		
		System.out.print("아이디 : ");
		String memberId = inputString();

		System.out.print("비밀번호 : ");
		String memberPw = inputString();

		System.out.print("이름 : ");
		String name = inputString();

		System.out.print("휴대폰 : ");
		String mobile = inputString();

		System.out.print("이메일 : ");
		String email = inputString();
		
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
	
	public static void main1(String[] args) {
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
		String email = inputString();

		System.out.print("마일리지 : ");
		int mileage = inputNumber();

		Member dto = new Member(memberId, memberPw, name, mobile, email);
		dto.setMileage(mileage);
		
		System.out.println(dto);
	}

	
}
