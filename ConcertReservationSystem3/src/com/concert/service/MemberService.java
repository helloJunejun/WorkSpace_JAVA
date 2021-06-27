package com.concert.service;

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
public class MemberService {
	/** 회원들을 저장관리하기 위한 자료 저장구조 : Generic */
	public static ArrayList<Member> list = new ArrayList<Member>();
	public static ArrayList<Info> infoList = new ArrayList<Info>();
	
	
//	/** 기본생성자 : 초기화 회원 등록 수행 */
//	public MemberService() {}
	
	
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
	public ArrayList<Info> getInfo() {
		for(int index = 0; index < infoList.size();index++) {
			System.out.println(infoList.get(index));
		}
		return infoList;
	}
	
	/**
	 * 현재 등록 인원수 조회
	 * @return 현재 등록 인원수
	 */
	public int getCount() {
		return list.size();
	}
	
	/**
	 * 회원 등록
	 * @param dto 등록 회원
	 */
	public void addMember(Member dto) throws DuplicateException {
		int index = exist(dto.getMemberId());
		if (index >= 0) {
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
	 * @param grade
	 * @throws money
	 */
	public void addMember(String memberId, String memberPw, String name, String mobile) throws DuplicateException {
		Member dto = new Member(memberId, memberPw, name, mobile);

		addMember(dto);
	}
	
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
	

	
	
	/**
	 * 공연 등록
	 * @param dto 등록 회원
	 */
	public void addInfo(Info dto) throws DuplicateException {
		int index = exist(dto.getInfoCode());
		if (index >= 0) {
			throw new DuplicateException(dto.getInfoCode());
		}
				
//		list.add(dto);
	}
	
	/**
	 * 회원 등록
	 * -- 사용자 입력 데이터 : 아이디, 비밀번호, 이름, 휴대폰, 이메일
	 * -- 시스템 최초 가입시 일반회원 가입처리 : 가입일, 등급, [마일리지]
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰 
	 * @param grade
	 * @throws money
	 */
	public void addInfo(String infoCode, String infoName, String infoDate, String infoTime, String infoFemaleActor,
			String infoMaleActor, int ticketPrice) throws DuplicateException {
		Info dto = new Info(infoCode, infoName, infoDate, infoTime, infoFemaleActor,
				infoMaleActor, ticketPrice);

		addInfo(dto);
	}
	
	


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
	
	
	

}
	
	

