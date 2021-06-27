package com.work.model.dto;

/**
 * <pre>
 * 회원 정보 도메인 클래스 
 * -- encapsulation 설계 반영 변경
 * </pre>
 * @author 유준성
 * @version ver.1.0
 * @since jdk1.8
 */



public class Member {
	/** 회원id : 식별키 */
	private String memberId;
	
	/** 비밀번호 : 필수 */
	private String memberPw;
	
	/** 이름 : 필수 */
	private String name;
	
	/** 휴대폰 : 필수 */
	private String mobile;
	
	/** 이메일 : 필수 */
	private String email;
	
	/** 가입일 : 필수, 시스템 */
	private String entryDate;
	
	/** 등급 : 필수 , 시스템 */
	private String grade;
	
	/** 마일리지, 선택, 일반회원 */
	private int mileage;
	
	/** 담당자, 선택, 우수회원 */
	private String manager;

	/**
	 * 기본 생성자
	 */
	public Member() {
	}

	/**
	 * 사용자 입력 데이터 초기화 생성자 (생성자 중복정의)
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}

	/**
	 * 필수 데이터 초기화 생성자 (생성자 중복정의)
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 * @param entryDate 가입일
	 * @param grade 등급
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade) {
		this(memberId, memberPw, name, mobile, email);
		this.entryDate = entryDate;
		this.grade = grade;
	}

	/**
	 * 전체데이터 초기화 생성자 (생성자 중복정의)
	 * @param memberId 아이디
	 * @param memberPw 비밀번호
	 * @param name 이름
	 * @param mobile 휴대폰
	 * @param email 이메일
	 * @param entryDate 가입일
	 * @param grade 등급
	 * @param mileage 마일리지
	 * @param manager 담당자
	 */
	public Member(String memberId, String memberPw, String name, String mobile, String email, String entryDate,
			String grade, int mileage, String manager) {
		this(memberId, memberPw, name, mobile, email, entryDate, grade);
		this.mileage = mileage;
		this.manager = manager;
	}
	

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * 아이디 검증규칙 :
	 * -- 최소 6자리, 최대 30자리
	 * -- 문자열길이 메서드 : {@link String#length()}
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		boolean result = isMemberId(memberId);
		if(result) {
		this.memberId = memberId;
		} else {
			System.out.println("[오류]아이디는 6~30자리 이내로 입력하세요.");
		}
	}
	
	/**
	 * 아이디 검증메서드
	 * @param memberId 아이디
	 * @return 아이디길이가 6~30자리 이내면 true, 그렇지 않으면 false
	 */
	private boolean isMemberId(String memberId) {
		if(memberId.length() >= 6 && memberId.length() <= 30) {
			return true;
		} else {
			return false;
		}
}
	
	/**
	 * 
	 * @return
	 */
	public String getMemberPw() {
		return memberPw;
	}

	/**
	 *  비밀번호 검증규칙 :
	 * -- 최소 6자리, 최대 20자리
	 * -- 문자열길이 메서드 : {@link String#length()}
	 * @param memberPw the memberPw to set
	 */
	public void setMemberPw(String memberPw) {
		boolean result = isMemberPw(memberPw);
		if(result) {
		this.memberPw = memberPw;
		} else {
			System.out.println("[오류]비밀번호는 6~20자리 이내로 입력하세요.");
		}
	}
	
	/**
	 * 패스워드 검증메서드
	 * @param memberPw 패스워드
	 * @return 비밀번호 길이가 6~20자리 이내면 true, 그렇지 않으면 false
	 */
	private boolean isMemberPw(String memberPw) {
		if(memberPw.length() >= 6 && memberPw.length() <= 20) {
			return true;
		} else {
			return false;
		}
}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the entryDate
	 */
	public String getEntryDate() {
		return entryDate;
	}

	/**
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}

	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 *   회원등급 검증규칙 :
	 * -- G, S, A 이외에 오류
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		boolean result = isGrade(grade);
		if(result) {
		this.grade = grade;
		} else {
			System.out.println("[오류]회원등급은 G, S, A만 존재합니다.");
		}
	}

	/**
	 * 등급 검증메서드
	 * @param grade 등급
	 * @return G, S, A가 아니면 잘못 등록된 값.
	 */
	private boolean isGrade(String grade) {
		if(grade.equals("G") || grade.equals("S") || grade.equals("A")) {
			return true;
		} else {
			return false;
		}
}	

	/**
	 * @return the mileage
	 */
	public int getMileage() {
		return mileage;
	}

	/**
	 * 마일리지 검증규칙 :
	 * -- 0 ~ 100,000 사이의 숫자
	 * @param mileage the mileage to set
	 */
	public void setMileage(int mileage) {
		boolean result = isMileage(mileage);
		if(result) {
		this.mileage = mileage;
		} else {
			System.out.println("[오류]마일리지는 0 ~ 100,000이내 입니다.");
		}
	}
	
	/**
	 * 마일리지 검증메서드
	 * @param mileage 마일리지
	 * @return 마일리지가 0 ~ 100,000 이내면 true, 그렇지 않으면 false
	 */
	private boolean isMileage(int mileage) {
		if(mileage >= 0 && mileage <= 100000) {
			return true;
		} else {
			return false;
		}
}

	/**
	 * @return the manager
	 */
	public String getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(String manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return memberId + ", " + memberPw + ", " + name + ", " + mobile + ", " + email + ", " + entryDate + ", " + grade
				+ ", " + mileage + ", " + manager;
	}

//	@Override
//	public String toString() {
//		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", name=" + name + ", mobile=" + mobile
//				+ ", email=" + email + ", entryDate=" + entryDate + ", grade=" + grade + ", mileage=" + mileage
//				+ ", manager=" + manager + "]";
//	}
	
		
	
}












