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
	public ArrayList<Member> list = new ArrayList<Member>();

	
	
	/** 기본생성자 : 초기화 회원 등록 수행 */
	public MemberService() {}
	
	/**
	 * 회원 탈퇴 
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @return 성공시 탈퇴회원기존정보, 실패시 null
	 */
	public Member removeMember(String memberId, String memberPw) throws RecordNotFoundException {
		int index = exist(memberId);
		if (index >= 0 && list.get(index).getMemberPw().equals(memberPw)) {
			return list.remove(index);
		}
		throw new RecordNotFoundException(memberId);
//		return null;
	}

	public Member removeMember(String memberId) throws RecordNotFoundException  {
		int index = exist(memberId);
		if (index >= 0) {
			return list.remove(index);
		}
		
		throw new RecordNotFoundException(memberId);
//		return null;
	}
	
	/**
	 * 회원정보 전체 변경
	 * @param dto 변경회원객체
	 * @return 성공시 true, 실패시 false
	 */
	public boolean setMember(Member dto) throws RecordNotFoundException {
		int index = exist(dto.getMemberId());
		if (index >= 0) {
			list.set(index, dto);
			return true;
		}
		
		throw new RecordNotFoundException(dto.getMemberId());
//		return false;
	}
	
	/**
	 * 비밀번호 변경 
	 * -- 아규먼트 : 아이디, 비밀번호, 변경비밀번호
	 * -- 도메인 데이터 각각 : 아이디, 비밀번호, 변경비밀번호
	 * -- 도메인 객체?? : Member??? xxx 도메인 속성에 변경비밀번호 없음
	 * -- Map : key:value
	 * @return
	 */
	public boolean setMemberPw(String memberId, String memberPw, String modifyMemberPw) throws RecordNotFoundException {
		int index = exist(memberId);
		
		if (index >= 0 && list.get(index).getMemberPw().equals(memberPw)) {
			list.get(index).setMemberPw(modifyMemberPw);
			return true;
		}
		
		throw new RecordNotFoundException(memberId);
//		return false; 
	}
	
	
	/** 현재 등록한 전체 회원 조회 */
	public ArrayList<Member> getMember() {
		return list;
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
	 * 테스트를 위한 회원 초기화 등록 메서드
	 * @return 초기화 회원등록 인원수
	 * @throws DuplicateException 
	 */
	public int initMember() throws DuplicateException {
		Member dto1 = new Member("user01", "password01", "홍길동", "01012341000", "VIP", 50000);
		Member dto2 = new Member("user02", "password02", "강감찬", "01012342000",  "VIP", 30000);
		Member dto3 = new Member("user03", "password03", "이순신", "01012343000",  "S", 80000);
		Member dto4 = new Member("user04", "password04", "김유신", "01012344000", "S", 60000);
		Member dto5 = new Member("administrator", "admin1004", "유관순", "01012345000","R", 100000);

		addMember(dto1);
		addMember(dto2);
		addMember(dto3);
		addMember(dto4);
		addMember(dto5);
		
		return list.size();
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
	
	
	public int initInfo() throws DuplicateException {
		Info dto1 = new Info("play_001", "뮤지컬 더 리퍼", "6/12", "19:30 ~ 22:00", "문채원", "송중기", 10000);
		Info dto2 = new Info("play_002", "옥탁방 고양이", "6/19", "20:00 ~ 22:00",  "남정은", "이경민", 10000);
		Info dto3 = new Info("play_003", "피카츄의 대모험", "6/26", "19:30 ~ 21:30", "소니아", "금랑", 10000);
		Info dto4 = new Info("play_004", "낫아웃", "7/3", "20:00 ~ 22:30", "송이재", "정재광", 10000);
		Info dto5 = new Info("play_005", "행복", "7/10","19:30 ~ 21:30", "김단율", "정영성", 10000);

		addInfo(dto1);
		addInfo(dto2);
		addInfo(dto3);
		addInfo(dto4);
		addInfo(dto5);
		
		return list.size();
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
	
	
	/**
	 * 로그인
	 * @param memberId
	 * @param memberPw
	 * @return 성공시 회원 등급, 실패시 null
	 * @throws RecordNotFoundException 
	 * @throws CommonException 
	 */
	public String login2(String memberId, String memberPw) throws RecordNotFoundException, CommonException {
		try {
			Member dto = getMember(memberId);
			if (dto.getMemberPw().equals(memberPw)) {
				if(dto.getGrade().equals("G")) {
									}
				return dto.getGrade();
			}
			throw new CommonException("회원의 정보가 올바르지 않습니다.");
		} catch (RecordNotFoundException e) {
			throw e;
		}
	}
	
	/**
	 * 로그인
	 * -- 로그인 성공시 : 회원 등급(grade), [+ ... name 등 필요시 부가 속성 추가 가능] 
	 * -- 일반회원 자동등업 성공시 : 회원 등급(grade) + 담당자(manager)
	 * @param memberId
	 * @param memberPw
	 * @return 성공시 HashMap, 실패시 null
	 * @throws CommonException 
	 * @throws RecordNotFoundException 
	 */
	public HashMap<String, String> login3(String memberId, String memberPw) throws CommonException, RecordNotFoundException {
		try {
			Member dto = getMember(memberId);
			if (dto.getMemberPw().equals(memberPw)) {
				HashMap<String, String> loginMap = new HashMap<String, String>();
				// 일반회원 인경우에 마일리지 100,000 이상여부 체킹 로직 추가
				
				loginMap.put("grade", dto.getGrade());
				loginMap.put("name", dto.getName());
				return loginMap;
			}
			throw new CommonException("[로그인 실패] 회원의 정보가 올바르지 않습니다.");
		} catch (RecordNotFoundException e) {
			throw e;
		}
	}
}
	
	

