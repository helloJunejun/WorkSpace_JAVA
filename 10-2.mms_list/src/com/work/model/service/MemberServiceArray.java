/**
 * 
 */
package com.work.model.service;

import com.work.model.dto.Member;

/**
 * @author 준성
 *
 */
public class MemberServiceArray {
		/**
		 * 회원들을 관리하기 위한 자료저장구조 : 배열 다형성 반영(부모타입) :
		 * 생성자 사용초기화, 확장, 고정 본인이 편한 로직으로 진행하세요.
		 */
		private Member[] members = new Member[10];
		
		/** 등록인원수 및 등록될 배열요소 위치정보 */
		private int count;
			
		/**
		 * 현재 등록 인원수 조회
		 * @return 현재 등록 인원수
		 */
		public int getCount()  {
			return count;
		}	
		
		

		/**
		 * 회원등록 구현 절차 :
		 * 1. 현재 등록된 회원수와(count) 현재배열의 크기와 같은지 비교해서
		 * 
		 * - 별도의 메서드로 분리 설계 : 구현클래스에서 메서드 선언
		 * 2. 같으면 새로이 확장배열(기존배열의 크기 +)을 생성해서
		 * 3. 새로이 확장한 배열요소에 기존에 배열요소에 저장된 객체들을 이동저장시킨후
		 * 4. 기존에 참조하고 있는 배열대신에 새로이 확장한 배열요소 변경 참조설정
		 * ...
		 * 5. count의 배열요소에 아규먼트로 전달받은 회원객체 등록하고
		 * 6. count를 1증가 시킴
		 * 
		 */
		public void addMember(Member dto) {
			if (count == members.length) {
				extendMembers();
			} 
			
			if(exist(dto.getMemberId()) == -1) {
				members[count++] = dto; // 입력받은 정보를 members 배열에 저장하고 count++ 이용해서 인덱스 하나씩 늘리면서 배열에 저장
				// 무조건 등록 문제 : 중복 => 해결 : 등록하기전에 등록된 회원의 아이디가 같은지 (같은객체 equals())
			} else {
				// 동일아이디를 갖는 회원객체 존재하는 경우에는 오류메세지 출력
				// 오류메세지 : [오류] 000 아이디는 사용할 수 없습니다.
				System.out.println("오류메세지 : [오류] " + dto.getMemberId() + " 아이디는 사용할 수 없습니다.");
			}
		}
		// 기존 배열요소를 기본배열크기 + 배열크기를 확장처리 메서드
		// System.arraycopy() 메서드 활용
		/**
		 * <pre>
		 * 배열구조 추가 확장해서 기존 저장정보 이동 처리 메서드
		 * 1. 멤버 배열에 멤버temp 변수를 선언해주고 temp에 멤버 배열+ 배열 선언
		 * 2. arraycopy 이용해서 배열 확장
		 * 3. 확장한 temp를 다시 members 변수에 넣어주기
		 * </pre>
		 * @see java.lang.System#arraycopy(Object, int, Object, int, int)
		 */
		public void extendMembers() {
			Member[] membersTemp = new Member[members.length + members.length];
			System.arraycopy(members, 0, membersTemp, 0, members.length);
			members = membersTemp;
		}

		/*
		 * CRUD 메서드에서 사용하기 위한 회원 존재유무 및 저장 위치 조회 메서드
		 * 1. 현재 등록된 회원수만큼 반복하면서
		 * 2. 배열에 저장된 객체 순서대로 저장된 객체의 아이디(dto.getMemberId())와 아규먼트로 전달받은 아이디가 같은지 비교해서 (String#equals(문자열))  
		 * 3. 아이디가 같으면 현재 저장된 배열요소의 인덱스번호를 반환
		 * 
		 * 4. 반복을 다했는데도 return 되지 않았따면 아이디정보를 갖는 회원객체가 존재하지 않으므로 return -1
		 * ...
		 * @param memberId 아이디
		 * @return 존재시에 저장위치번호, 미존재시 -1
		 */
		public int exist(String memberId) {
			// 1.
			for(int index = 0; index < count; index++) {
				// 2. 
				if(members[index].getMemberId().equals(memberId)) {
					//3.
					return index;
				}
			}
			// 4.
			return -1;
		}

		/*
		 * 회원등록 상세 조회 구현 절차
		 * 1. exist(String memberId) 수행결과 : 저장위치 반환
		 * 2. 저장위치 0보다 크거나 같은지 비교해서
		 * 3. 0보다 크거나 같으면 존재하니까 해당 배열요소의 객체를 return 반환
		 * 4. 0보다 크거나 같지않으면(0보다작으면) 존재하지 않음 : 존재하지 않으므로 객체타입의 기본값 return null
		 */
		public Member getMember(String memberId) { //Member가 객체 타입이다.
			int idx = exist(memberId); // 1.
			if(idx >= 0) {			   // 2.
				return members[idx];   // 3.
			}
			
			System.out.println("[오류] " + memberId + "는 존재하지 않는 아이디입니다.");
			return null; 				// 4.
		}

		/*
		 * 회원등록 전체 조회 구현 절차
		 * 1. exist(String memberId) 수행결과 : 저장위치 반환
		 * 2. 저장위치 0보다 크거나 같은지 비교해서
		 * 3. 0보다 크거나 같으면 존재하니까 해당 배열요소의 객체를 return 반환
		 * 4. 0보다 크거나 같지않으면(0보다작으면) 존재하지 않음 : 존재하지 않으므로 객체타입의 기본값 return null
		 */
		public Member[] getMember() {
			for(int index = 0; index < count; index++) {
				int idx = exist(members[index].getMemberId());
				if(idx >= 0) {
					System.out.println(members[index]);
				}
			}
			return members;
		}
		
		
		
		
		
		
}































