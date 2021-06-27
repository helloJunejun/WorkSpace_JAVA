package com.work.static_test;

/**
 * 회원도메인 클래스
 * 1. 회원아이디 memberId
 * 2. 이름 name
 * 3. 휴대폰 mobile
 * 
 * # 도메인 설계규칙 : DTO
 * 1. encapsulation
 * 2. 생성자 중복정의 : 기본, 전체
 * 3. toString() 재정의
 * 4. equals(), hashCode() 재정의 : 아이디 같으면 같은 객체
 */

public class SimpleMember {
	// CLASS 변수 : 객체생성없이 사용가능, 모든 객체가 공유변수
	public static int classCount;
	
	// instance 변수 : 객체생성후 참조변수명을 통해서 해당객체에서 사용하는 변수
	public int instanceCount;
	
	// static block 초기화
	static {
		classCount = 1234567;
		System.out.println(classCount + "클래스가 로드될때(프로그램시작) 딱 한번만 수행합니다.");
	}
	
	// instance block 초기화 => 생성자 중복정의 활용
	{
		
		System.out.println("객체 생성할때마다 수행합니다.");
	}

	private String memberId;
	private String name;
	private String mobile;
	
	public SimpleMember() {
		System.out.println("생성자 : 객체생성시 호출수행됩니다.");
	}

	/**
	 * @param memberId
	 * @param name
	 * @param mobile
	 */
	public SimpleMember(String memberId, String name, String mobile) {
		this.memberId = memberId;
		this.name = name;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return memberId + ", " + name + ", " + mobile;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleMember other = (SimpleMember) obj;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		return true;
	}
	
	

}
