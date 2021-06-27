package com.work.model.service;

import java.util.ArrayList;

import com.work.model.dto.AdminMember;
import com.work.model.dto.GeneralMember;
import com.work.model.dto.Member;
import com.work.model.dto.SpecialMember;
import com.work.util.Utility;

/**
 * Collection API 활용 변경
 * -- ArrayList
 * @author 준성
 */
public class MemberService {
	/** 회원들을 저장관리하기 위한 자료 저장구조 */
	private ArrayList list = new ArrayList();
	
	/** 기본생성자 : 초기화 회원 등록 수행 */
//	public MemberService() {
//		int count = initMember();
//		System.out.println("초기화회원 등록작업이 완료되었습니다. : " + initMember());
//	}
	
	/**
	 * 회원 탈퇴
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @return 성공시 탈퇴회원기존정보, 실패시 null
	 */
	public Member removeMember(String memberId, String memberPw) {
		int index = exist(memberId);
		if(index >= 0) {
			Object obj = list.get(index);
			if(obj instanceof Member) {
				Member dto = (Member)obj;
				if(dto.getMemberPw().equals(memberPw)) {
					return (Member)list.remove(index);
					
				}
			}
		}				return null;
	}
	
	/**
	 *  회원정보 전체 변경
	 * @return 성공시 true, 실패시 false
	 */
	public boolean setMember(Member dto) {
		int index = exist(dto.getMemberId());
		if(index >= 0) {
			list.set(index,  dto);
			return true;
			
		}
		return false;
	}
	/**
	 * 비밀번호 변경
	 * -- 아규먼트 : 아이디, 비밀번호, 변경비밀번호
	 * -- 도메인 데이터 각각 : 아이디, 비밀번호, 변경비밀번호
	 * -- 도메인 객체?? : Member??? X 도메인 속성에 변경비밀번호 없음
	 * -- Map : key:value
	 * @return
	 */
	public boolean setMemberPw(String memberId, String memberPw, String modifyMemberPw) {
		
		int index = exist(memberId);
		if(index >= 0) {
			Object obj = list.get(index);
			if(obj instanceof Member) {
				Member dto = (Member)obj;
				if(dto.getMemberPw().equals(memberPw)) {
					dto.setMemberPw(modifyMemberPw);
					return true;
				}
			}
		}		
		return false; // 아이디 존재하지 않거나, 기존비밀번호 틀린경우
	}
	
	/** 현재 등록한 전체 회원 조회 */
	public ArrayList getMember() {
		return list;
	}
	
	/**
	 * 현재 등록 인원수 조회
	 * @return
	 */
	public int getCount()  {
		return list.size();
	}	
	
	/**
	 * 회원 등록 
	 * -- 사용자 입력 데이터 : 아이디, 비밀번호, 이름, 휴대폰, 이메일
	 * -- 시스템 최초 가입시 일반회원 가입처리 : 가입일, 등급, [마일리지]
	 * @param dto 등록 회원
	 */
	public void addMember(Member dto) {
		if(exist(dto.getMemberId()) == -1) {
			list.add(dto); // list 순서존재, 중복 허용 구조 => 개발자 등록전에 중복여부 검증 처리 : 순서 인덱스는 사용하고, 중복되지않고 처리 가능
		} else {
			// 동일아이디를 갖는 회원객체 존재하는 경우에는 오류메세지 출력
			// 오류메세지 : [오류] 000 아이디는 사용할 수 없습니다.
			System.out.println("오류메세지 : [오류] " + dto.getMemberId() + " 아이디는 사용할 수 없습니다.");
		}
	}
	
	/**
	 * 회원 등록 
	 * -- 사용자 입력 데이터 : 아이디, 비밀번호, 이름, 휴대폰, 이메일
	 * -- 시스템 최초 가입시 일반회원 가입처리 : 가입일, 등급, [마일리지]
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email0 이메일
	 */
	public void addMember(String memberId, String memberPw, String name, String mobile, String email) {
		GeneralMember dto = new GeneralMember(memberId, memberPw, name, mobile, email);
		dto.setGrade("G");
		dto.setEntryDate(Utility.getCurrentDate());
		dto.setMileage(1000);
		
		addMember(dto);
	}
	
	/**
	 * 회원 존재 유무 조회 : 저장된 회원의 크기만큼 반복, 저장객체 조회(Object), instanceOf, type casting, equals()
	 * @param memberId 아이디
	 * @return 존재시 저장위치 인덱스번호, 미존재시 -1
	 */
	public int exist(String memberId) {
//		 jdk 1.4
		for(int index = 0; index < list.size(); index++) { // index 돌리기 사이즈보다작게
			Object obj = list.get(index); // obj 객체생성 index들어간 getter 반환타입이 object
			if(obj instanceof Member) { // obj랑 Member 객체 비교
				Member dto = (Member)obj; // obj Member객체로 형변환 하면서 dto 대입
				if(dto.getMemberId().equals(memberId)) { // 멤버아이디 불러내서 equals로 문자열 비교
					return index; // 인덱스 반환
				}
				
			}
		}
		
		// 중복체크 결과가 올바르지 않게 나옴
//		for(int index = 0; index < list.size(); index++) {
//			if(list.get(index).equals(memberId)) {
//				return index;
//			}
//		}
//		
		
//		// jdk1.5
//		for(Object obj : list) {
//			if(obj.equals(memberId)) {
//				return ???;
//			}
//		}
				
				return -1; //아닐경우 -1값 반환
	}
	/**
	 * 테스트를 위한 회원 초기화 등록 메서드
	 * @return 초기화 회원등록 인원수
	 */
	public int initMember() {
		Member dto1 = new GeneralMember("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 5000);
		Member dto2 = new GeneralMember("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2020-12-15", "G", 95000);
		Member dto3 = new SpecialMember("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-12-15", "S", "강동원");
		Member dto4 = new SpecialMember("user04", "password04", "김유신", "01012344000", "user04@work.com", "2020-12-15", "S", "김하린");
		Member dto5 = new AdminMember("adminstrator", "admin1004", "유관순", "01012345000", "adminstrator@work.com", "2020-12-15", "A", "선임");
	
		addMember(dto1);
		addMember(dto2);
		addMember(dto3);
		addMember(dto4);
		addMember(dto5);

		return list.size();
	}
	/**
	 * 회원 상세조회
	 * @param memberId 회원아이디
	 * @return 존재하면 회원객체, 미존재 null
	 * @see exist(String)
	 */
	public Member getMember(String memberId) {
		int index = exist(memberId);
		if (index >= 0) {
			return (Member)list.get(index);
		}
		return null;
	}
}











