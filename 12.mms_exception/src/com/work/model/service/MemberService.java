package com.work.model.service;

import java.util.ArrayList;

import com.work.exception.DuplicateException;
import com.work.exception.RecordNotFoundException;
import com.work.model.dto.Member;
import com.work.util.Utility;

/**
 * Collection API 활용 변경
 * -- ArrayList
 * -- Generic collection 변경 //객체로 한방에 변경가능
 * @author 준성
 */
public class MemberService {
	/** 회원들을 저장관리하기 위한 자료 저장구조 */
	private ArrayList<Member> list = new ArrayList<Member>(); //객체 설정을 후에 안해줘도 한방에 교체가능
	
	/** 기본생성자 : 초기화 회원 등록 수행 */
	
	/**
	 * 회원 탈퇴
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @return 성공시 탈퇴회원기존정보, 실패시 null
	 */
	public Member removeMember(String memberId, String memberPw) {
		int index = exist(memberId);
		if(index >= 0 && list.get(index).getMemberPw().equals(memberPw)) {
			
			return list.remove(index);
			}
		return null;	
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
		if(index >= 0 && list.get(index).getMemberPw().equals(memberPw)) {
					list.get(index).setMemberPw(modifyMemberPw);
					return true;
			}
		
		return false;
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
	public void addMember(Member dto) throws DuplicateException {
//		if(exist(dto.getMemberId()) == -1) {
//			list.add(dto); // list 순서존재, 중복 허용 구조 => 개발자 등록전에 중복여부 검증 처리 : 순서 인덱스는 사용하고, 중복되지않고 처리 가능
//		} else {
//			// 동일아이디를 갖는 회원객체 존재하는 경우에는 오류메세지 출력
//			// 오류메세지 : [오류] 000 아이디는 사용할 수 없습니다.
//			System.out.println("오류메세지 : [오류] " + dto.getMemberId() + " 아이디는 사용할 수 없습니다.");
//		}
		int index = exist(dto.getMemberId());
		if(index >= 0 ) {
			throw new DuplicateException(dto.getMemberId());
		}
		
		list.add(dto);
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
	public void addMember(String memberId, String memberPw, String name, String mobile, String email) throws DuplicateException {
		Member dto = new Member(memberId, memberPw, name, mobile, email);
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
		// Generic jdk1.5 변경 구현
		for(int index = 0; index < list.size(); index++) {
		if(list.get(index).getMemberId().equals(memberId))
			return index;
		}
		
	return -1; //아닐경우 -1값 반환
	}
	
	
	
	/**
	 * 테스트를 위한 회원 초기화 등록 메서드
	 * @return 초기화 회원등록 인원수
	 */
	public int initMember() throws DuplicateException {
		Member dto1 = new Member("user01", "password01", "홍길동", "01012341000", "user01@work.com", "2020-12-15", "G", 5000, null);
		Member dto2 = new Member("user02", "password02", "강감찬", "01012342000", "user02@work.com", "2020-12-15", "G", 1100000, null);
		Member dto3 = new Member("user03", "password03", "이순신", "01012343000", "user03@work.com", "2020-12-15", "S", 0, "강동원");
		Member dto4 = new Member("user04", "password04", "김유신", "01012344000", "user04@work.com", "2020-12-15", "S", 0,  "김하린");
		Member dto5 = new Member("adminstrator", "admin1004", "유관순", "01012345000", "adminstrator@work.com", "2020-12-15", "A");
	
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
	public Member getMember(String memberId) throws RecordNotFoundException {
		int index = exist(memberId);
		if (index >= 0) {
			return (Member)list.get(index);
		}
//		return null;
		throw new RecordNotFoundException(memberId);
	}
	
	/*
	 * 로그인
	 * -- 처리절차
	 * -- 메서드명
	 * -- 매개변수
	 * -- 반환타입
	 * 1. 회원전용서비스 : boolean
	 * 2. 회원등급별 차등 서비스 : 해당회원의 등급(String), 로그인실패 - null (아이디 미존재, 비밀번호 불일치)
	 * 3. 로그인시에 자동 등업처리 : 
	 * 	=> 반환타입?? 로그인성공한 회원의 등급, 일반회원이 우수회원등업시 결과메세지
	 * 	=> 단일값 String, Domain 객체 Member x(사용할 수 없다.), Collection(List, Set, Map-key:value)
	 * 	3.1 : 로그인 성공?
	 * 	3.2 : 등급이 일반회원??
	 * 	3.3 : 일반회원이면 마일리지 변경(로그인 마일리지 추가)
	 * 	3.4 : 일반회원이면 마일리지가 100,000이상인지 확인??
	 * 	3.5 : 일반회원의 현재 마일리지가 100,000이상이면 => 우수회원 등업처리를 위한 메서드 dispatch(위임)
	 * 	3.6 : 일반회원이 우수회원으로 등업처리 결과를 받아서 : 담당자 결과 받아서
	 * 	3.7 : 우수회원으로 등업된 회원에게 "우수회원 등업처리 축하... 전용담당자 정보 "000" 로그인성공 응답
	 * 		=> 우수회원 등업의 결과를 출력 메시지 처리
	 * 		=> 응답결과로 반환
	 * 	4.0 : 로그인성공은 했으나 일반회원이 아니라면
	 * 	4.1 : 로그인 성공처리 응답
	 */
	
	/*
	 * 마일리지 변경
	 * -- 마일리지 정책 ??
	 * 1. 로그인시마다 일반회원인 경우에는 마일리지 500 추가
	 */
	
	
	/*
	 * 우수회원 등업메서드
	 * --처리절차(방법)
	 * 1. 일반회원이 본인의 마일리지정보 조회하고 => 관리자에게(시스템) 등업요청
	 * 2. 자동등업 : 
	 * 	=>100,000점 넘으면 자동으로 등업 => 마일리지 변경처리 메서드에서 수행로직
	 * 	=> 로그인 성공시 자동으로 확인해서 등업
	 * 3. 관리자 회원정보 조회해서 등업처리
	 * 
	 * -- 처리절차
	 * 1. 아이디 매개변수 전달 => 일반회원?? 마일리지 100,000??
	 * 2. 등급 : 우수회원 변경
	 * 3. 담당자 : 배정
	 * 4. 마일리지 : 0 변경
	 * 5. 배정된 담당자 이름 반환
	 * 
	 * --메서드명 
	 * --매개변수 : 회원아이디
	 * --반환타입 : 담당자
	 * 
	 * -- 담당자 고정지정
	 * -- 담당자 랜덤지정
	 */
	Member key = new Member();
	public void gradeMember() {
		if(key.getMileage() >= 100000) {
			key.setGrade("A");
		} 
	}
	
	/*
	 * 아이디 찾기
	 */
	
	/*
	 * 비밀번호 찾기
	 * 1. 기존비밀번호 반환 : 현재 보안이슈...진행하는 사이트 없음...
	 * 2. 임시암호발급 변경 후 반환 : 휴대폰 문자, 이메일 발송, 응답화면 메세지
	 * 3. 암호변경위한 메뉴 제공 :
	 * 		
	 * 	-- 처리절차
	 * 	-- 메서드명
	 * 	-- 매개변수
	 * 	-- 반환타입
	 */
}











