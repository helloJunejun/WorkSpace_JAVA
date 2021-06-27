package com.work.view;

import java.util.Random;

public class RandomTeamTest {

	/*
	 *  # 수행결과 문제 및 개선사항
	 *  
	 *  1. 일부 수강생이 중복배정된 결과 문제
	 *  2. 팀원 이름 정렬 : {@link String#compareTo(String)}
	 */
	
	public static void main(String[] args) {
		int teamMemberLengthCols = 4;
		if (args.length == 1) {
			teamMemberLengthCols = Integer.parseInt(args[0]);
		} else {
			System.out.println("[사용방법] java RandomTeamTest 팀별인원숫자");
			System.out.println("[팀당 인원수를 입력하지 않아 팀당 인원수를 기본 4명으로 진행합니다.]");
		}
		
		String[] names = {
			"김기영", "김나연", "김대현", "김수정", "김의현", "김재현", "김종환", "김주리", "김주엽", "김지원", 
			"김현수", "김현진", "김혜진", "노한나", "문수인", "박민재", "박영규", "박유정", "신지수", "유건", 
			"유준성", "이태규", "이택근", "이희원", "장현우", "조성현", "최낙원", "한다예", "황윤아", "유동국"
		};
		
		String[][] teamMembers = null;
		int teamLengthRows = names.length / teamMemberLengthCols;;
		int remainderLength = names.length % teamMemberLengthCols;
		
		if (remainderLength == 0) { 
			teamMembers = new String[teamLengthRows][teamMemberLengthCols];
			System.out.println(teamLengthRows + "개의 팀에 " + teamMemberLengthCols + "명의 팀원을 균등하게 배정합니다.");
		} else {
			teamMembers = new String[teamLengthRows][];
			for (int index = 0; index < remainderLength; index++) {
				teamMembers[index] = new String[teamMemberLengthCols + 1];
			}
			
			for (int index = remainderLength; index < teamLengthRows; index++) {
				teamMembers[index] = new String[teamMemberLengthCols];
			}
			
//			for (int teamRows = 0; teamRows < teamMembers.length; teamRows++) {
//				System.out.println((teamRows + 1) + "팀의 팀원은 " + teamMembers[teamRows].length + "명을 배정합니다.");
//			}
			
			System.out.println(teamLengthRows + "개의 팀에 " + teamMemberLengthCols + "명을 배정합니다.");
			System.out.println("남은 인원은 " + remainderLength + "개의 팀에 1명씩 추가로 균등 배정합니다.");
		}
		
		int[] uniqueNamesIndex = new int[names.length];
		int uniqueLength = 0;
		
		int randomNo;
		for (int teamRows = 0; teamRows < teamMembers.length; teamRows++) {
			for (int teamCols = 0; teamCols < teamMembers[teamRows].length; teamCols++) {
				
				randomLoop:
				while(true) {
					randomNo = getRandomNo();
					for (int index = 0; index < uniqueLength; index++) {
						if (uniqueNamesIndex[index] == randomNo) {
							continue randomLoop;
						}
					}
					
					uniqueNamesIndex[uniqueLength] = randomNo;
					teamMembers[teamRows][teamCols] = names[randomNo];
					break randomLoop;
				} 
				
			}
		}
		
		System.out.println();
		System.out.println("[팀별 팀원 배정 정보]");
		
		for (int teamRows = 0; teamRows < teamMembers.length; teamRows++) {
			System.out.print((teamRows + 1) + "팀 팀원 : ");
			for (int teamCols = 0; teamCols < teamMembers[teamRows].length; teamCols++) {
				System.out.print(teamMembers[teamRows][teamCols] + "\t");
			}
			System.out.println();
		}
	}
	
	public static boolean isUniqueNo(int randomNo) {
		return false;
	}

	public static int getRandomNo() {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		return random.nextInt(30);
	}
}

/*
## 수행결과
	
1. 실행 : java RandomTeamTest 10
3개의 팀에 10명의 팀원을 균등하게 배정합니다.

[팀별 팀원 배정 정보]
1팀 팀원 : 김혜진	김주리	최낙원	박영규	김기영	유준성	김지원	김주리	이택근	장현우	
2팀 팀원 : 신지수	김재현	황윤아	김대현	유준성	신지수	이희원	이태규	신지수	한다예	
3팀 팀원 : 김수정	박유정	김지원	김혜진	장현우	김혜진	장현우	신지수	김현수	김의현	
	
2. 실행 : java RandomTeamTest 
[팀당 인원수를 입력하지 않아 팀당 인원수를 기본 4명으로 진행합니다.]

[팀별 팀원 배정 정보]
1팀 팀원 : 김의현	문수인	이희원	박민재	장현우	
2팀 팀원 : 유동국	김현진	황윤아	김기영	김현수	
3팀 팀원 : 유동국	한다예	이태규	박민재	
4팀 팀원 : 황윤아	이태규	김주리	김의현	
5팀 팀원 : 유동국	장현우	김의현	이택근	
6팀 팀원 : 이희원	조성현	이택근	김재현	
7팀 팀원 : 김기영	김나연	박유정	최낙원		
	
3. 실행 : java RandomTeamTest 7 
4개의 팀에 7명을 배정합니다.
남은 인원은 2개의 팀에 1명씩 추가로 균등 배정합니다.

[팀별 팀원 배정 정보]
1팀 팀원 : 유건	박유정	이희원	김기영	김나연	최낙원	이택근	노한나	
2팀 팀원 : 유동국	박민재	김기영	김대현	김지원	유준성	한다예	김의현	
3팀 팀원 : 김혜진	김주엽	한다예	한다예	이희원	조성현	김현진	
4팀 팀원 : 김의현	김의현	이택근	이택근	김재현	이희원	김기영	

4. 실행 : java RandomTeamTest 5
6개의 팀에 5명의 팀원을 균등하게 배정합니다.

[팀별 팀원 배정 정보]
1팀 팀원 : 김지원	문수인	김나연	김혜진	문수인	
2팀 팀원 : 김지원	박민재	이태규	한다예	김대현	
3팀 팀원 : 장현우	박민재	신지수	최낙원	한다예	
4팀 팀원 : 김의현	김현수	박민재	김현진	유건	
5팀 팀원 : 김현진	김재현	한다예	김기영	박유정	
6팀 팀원 : 박민재	김대현	노한나	김주엽	박영규	

5. 실행 : java RandomTeamTest 6
5개의 팀에 6명의 팀원을 균등하게 배정합니다.

[팀별 팀원 배정 정보]
1팀 팀원 : 김수정	이택근	김현수	김기영	유동국	김주리	
2팀 팀원 : 유건	김지원	유건	김주엽	김대현	김대현	
3팀 팀원 : 박유정	박유정	김주엽	김주리	한다예	최낙원	
4팀 팀원 : 이택근	김지원	김기영	김대현	김주리	박영규	
5팀 팀원 : 김혜진	조성현	문수인	최낙원	유준성	장현우	

*/