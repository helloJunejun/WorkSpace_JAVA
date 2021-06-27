/**
 * 
 */
package com.work.model.service;

import com.work.model.dto.Member;

/**
 * MemberServiceAbstract 추상클래스를 구현한 서비스 클래스
 */
public class MemberService extends MemberServiceAbstract {
	/**  
	 * 회원들을 관리하기 위한 자료저장구조 : 배열 다형성 반영(부모타입) : 
	 * 생성자 사용초기화, 확장, 고정 본인이 편한 로직으로 진행하세요 
	 */
	private Member[] members = new Member[10];
	
	/** 등록인원수 및 등록될 배열요소 위치정보 */
	private int count;
	
	
	/**
	 * 현재 등록 인원수 조회
	 * @return 현재 등록 인원수
	 */
	public int getCount() {
		return count;
	}

	/*
	 * 회원등록 구현 절차 :
	 * 1. 현재 등록된 회원수와(count) 현재배열의 크기와 같은지 비교해서
	 * 
	 * => 별도의 메서드로 분리 설계 : 구현클래스에서 메서드 선언
	 * 2. 같으면 새로이 확장배열(기존배열의 크기 +)을 생성해서
	 * 3. 새로이 확장한 배열요소에 기존에 배열요소에 저장된 객체들을 이동저장시킨후
	 * 4. 기존에 참조하고 있는 배열대신에 새로이 확장한 배열요소 변경 참조설정
	 * ...
	 * 
	 * 5. count의 배열요소에 아규먼트로 전달받은 회원객체 등록하고
	 * 6. count를 1증가 시킴
	 */
	@Override
	public void addMember(Member dto) {
		if (count == members.length) {
			extendMembers();
		}
		
		if (exist(dto.getMemberId()) == -1) {
			members[count++] = dto; // 무조건 등록 문제 : 중복 => 해결 : 등록하기전에 등록된 회원의 아이디가 같은지(같은객체 equals()) 
		} else {
			// 동일아이디를 갖는 회원객체 존재하는 경우에는 오류메세지 출력
			// 오류메세지 : [오류] 000 아이디는 사용할 수 없습니다.
			System.out.println("[오류]" + dto.getMemberId() + "는 사용할 수 없습니다.");
		}
		
	}
	
	/*
	 * CRUD 메서드에서 사용하기 위한 회원 존재유무 및 저장 위치 조회 메서드
	 * 1. 현재 등록된 회원수만큼 반복하면서
	 * 2. 배열에 저장된 순서대로 저장된 객체의 아이디와(dto.getMemberId()) 아규먼트로 전달받은 아이디가 같은지 비교해서 (String#equals(문자열))
	 * 3. 아이디가 같으면 현재 저장된 배열요소의 인덱스번호를 반환
	 * 4. 반복을 다했는데도 return 되지 않았다면 아이디정보를 갖는 회원객체가 존재하지않으므로 return -1
	 * @param memberId 아이디
	 * @return 존재시에 저장위치번호, 미존재시 -1
	 */
	@Override
	public int exist(String memberId) {
		for(int index = 0; index < count; index++) { // 1.
			if(members[index].getMemberId().equals(memberId)) { // 2.
				return index; // 3.
			}
		}	
		return -1; // 4.
	}
	

	/**
	 * <pre>
	 * 배열구조 추가 확장해서 기존 저장정보 이동 처리 메서드
	 * 1.
	 * 2.
	 * 3. 
	 * </pre>
	 * @see java.lang.System#arraycopy(Object, int, Object, int, int)
	 */
	public void extendMembers() {
		Member[] membersTemp = new Member[members.length + members.length];
		System.arraycopy(members, 0, membersTemp, 0, members.length);
		members = membersTemp;
	}
	
	/*
	 * 회원 상세조회 구현 절차
	 * 1. exist(String memberID) 수행결과 : 저장위치 반환
	 * 2. 저장위치 0보다 크거나 같은지 비교해서
	 * 3. 0보다 크거나 같으면 존재하니까 해당 배열요소의 객체를 return 반환
	 * 4. 0보다 크거나 같지않으면(0보다작으면) 존재하지 않음 : 존재하지 않으므로 객체타입의 기본값 return null
	 */
	@Override
	public Member getMember(String memberId) {
		int idx = exist(memberId); 	// 1.
		if(idx >= 0) {				// 2.
			return members[idx];	// 3.
		}
		
		System.out.println("[오류]" + memberId + "는 존재하지 않는 아이디입니다");
		return null; // 4
	}

	
}


/*
	public void addStudentScore(StudentScore dto) {
		if (count == students.length) {
			extendStudents(10);
			System.out.println("학생들의 자료저장구조를 추가 확장하였습니다.");
		} 
		
		students[count++] = dto;
	}
	
	public void extendStudents(int length) {
		StudentScore[] studentsTemp = new StudentScore[students.length + length];
		
		for (int index = 0; index < students.length; index++) {
			studentsTemp[index] = students[index];
		}
		
		students = studentsTemp;
	}
  
 
1. 저장공간이 있는지 확인한다
2. dto 데이터 전달받는다
3. 저장한다
	
2. 몇명이 추가되는지 확인
3.추가할 인원이 들어갈 배열공간이 있는 지확인 있으면 집어넣고 없으면 공간이 추가
4.완료 메시지 출력

  * 1. addMember메서드로 Member타입의 dto를 받아온다 
  * 2. members[]가 끝까지 다 찼는지 아닌지 검사한다. 
  * 3. members[]가 끝까지 다 찼다면 확장 후 dto를 members에 저장한다.
  * 4. count를 1 증가시킨다.
	 
	 * 회원등록 구현 절차 :
	 * 1. 데이터를 전달받음
	 * 2. 각 데이터 조건에 맞는지 검증
	 * 3. 배열에 자리가 있다면 저장
	 
 */











