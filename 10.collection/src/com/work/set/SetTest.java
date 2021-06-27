package com.work.set;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;

public class SetTest {
	
	public static void main(String[] args) {
		// collection Set : 순서없음, 중복불가
//		HashSet set = new HashSet();

		// jdk1.5 Generic : Member 저장되는 전용 collection
		HashSet<Member> set = new HashSet();
		
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 5000);
		Member dto2 = new GeneralMember("user01", "password02", "강감찬", "01012342000", "user02@work.com", "2020-12-15", "G", 95000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-12-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2020-12-15", "S", "김하린");
		Member dto5 = new AdminMember("adminstrator", "admin1004", "유관순", "01012345000", "adminstrator@work.com", "2020-12-15", "A", "선임");

		
		System.out.println();
		// 등록 : add(Object) : boolean(반환타입)
//		System.out.println(set.add("hello"));	// true
//		System.out.println(set.add("hello"));	// false 같은 단어가 미리 저장되어있기 때문에.
//		System.out.println(set.add("hello"));	// false
//		System.out.println(set.add("hello"));	// false
//		System.out.println(set.add("hello"));	// false
//		System.out.println(set.add(1004));		// true
//		System.out.println(set.add(new Integer(1004)));// false 이것도 형변환돼서 1004라는게 등록 되어 있기 때문에
		System.out.println(set.add(dto1));		// true
		System.out.println(set.add(dto2));		// false Member클래스에서 멤버아이디 같으면 같은거라고 재정의 해놨기때문에 equals로
		System.out.println(set.add(dto3));		// true
		System.out.println(set.add(dto4));		// true
		System.out.println(set.add(dto5));		// true
//		System.out.println(set.add(new Date()));	// true
		
		System.out.println("저장 갯수 : " + set.size()); // 7
		
		// 조회 : 전체조회
		System.out.println("\n전체조회");
		Iterator<Member> iterator = set.iterator(); // 앞에 참조형 데이터 타입 Iterator은 java.utill.에서 가져오는거다. 그래서 그게 데이터 타입이다 클래스에서 그 기능 사용하기위해
		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
			Member dto = iterator.next();
			System.out.println(dto);
		}
		
		// 조회 : 아이디가 "user01" 객체의 정보 조회 : instanceof / type casting [실습]
		System.out.println("\n상세조회");
		iterator = set.iterator();
		while(iterator.hasNext()) {
			Member dto = iterator.next();
			if(iterator.next().getMemberId().equals("user01")) {
				System.out.println(dto);
					// 수행문???
					break; // 반복문을 빠져나오기
				}
			}
		
		
		// 삭제 : see : -- boolean remove(object o)
		System.out.println("\n삭졔: user04");
		iterator = set.iterator();
		while(iterator.hasNext()) {
			Member dto = iterator.next();
			if(iterator.next().getMemberId().equals("user04")) {
				set.remove(dto);
				break; // 반복문을 빠져나오기
				}
			}
		
		System.out.println("\n전체조회");
		iterator = set.iterator(); // 앞에 참조형 데이터 타입 Iterator은 java.utill.에서 가져오는거다. 그래서 그게 데이터 타입이다 클래스에서 그 기능 사용하기위해
		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
			Member dto = iterator.next();
			System.out.println(dto);
		}

	}
	


	public static void main1(String[] args) {
		// collection Set : 순서없음, 중복불가
		HashSet set = new HashSet();
		
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 5000);
		Member dto2 = new GeneralMember("user01", "password02", "강감찬", "01012342000", "user02@work.com", "2020-12-15", "G", 95000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-12-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2020-12-15", "S", "김하린");
		Member dto5 = new AdminMember("adminstrator", "admin1004", "유관순", "01012345000", "adminstrator@work.com", "2020-12-15", "A", "선임");

		
		System.out.println();
		// 등록 : add(Object) : boolean(반환타입)
		System.out.println(set.add("hello"));	// true
		System.out.println(set.add("hello"));	// false 같은 단어가 미리 저장되어있기 때문에.
		System.out.println(set.add("hello"));	// false
		System.out.println(set.add("hello"));	// false
		System.out.println(set.add("hello"));	// false
		System.out.println(set.add(1004));		// true
		System.out.println(set.add(new Integer(1004)));// false 이것도 형변환돼서 1004라는게 등록 되어 있기 때문에
		System.out.println(set.add(dto1));		// true
		System.out.println(set.add(dto2));		// false Member클래스에서 멤버아이디 같으면 같은거라고 재정의 해놨기때문에 equals로
		System.out.println(set.add(dto3));		// true
		System.out.println(set.add(dto4));		// true
		System.out.println(set.add(dto5));		// true
		System.out.println(set.add(new Date()));	// true
		
		System.out.println("저장 갯수 : " + set.size()); // 7
		
		// 조회 : 전체조회
		System.out.println("\n전체조회");
		Iterator iterator = set.iterator(); // 앞에 참조형 데이터 타입 Iterator은 java.utill.에서 가져오는거다. 그래서 그게 데이터 타입이다 클래스에서 그 기능 사용하기위해
		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
			Object obj = iterator.next();
			System.out.println(obj);
		}
		
		// 조회 : 아이디가 "user01" 객체의 정보 조회 : instanceof / type casting [실습]
		System.out.println("\n상세조회");
		iterator = set.iterator();
		while(iterator.hasNext()) {
			Object obj = iterator.next();
			if(obj instanceof Member) {
				Member dto = (Member)obj;
				if(dto.getMemberId().equals("user01")) {
				System.out.println(dto);
					// 수행문???
					break; // 반복문을 빠져나오기
				}
			}
		}
		
		// 삭제 : see : -- boolean remove(object o)
		System.out.println("\n삭졔: user04");
		iterator = set.iterator();
		while(iterator.hasNext()) {
			Object obj = iterator.next();
			if(obj instanceof Member) {
				Member dto = (Member)obj;
				if(dto.getMemberId().equals("user01")) {
				set.remove(dto);
				break; // 반복문을 빠져나오기
				}
			}
		}
		
	}

}








