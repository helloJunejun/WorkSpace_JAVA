package com.work.view;

public class ArrayTest2 {

	/** 2차원 배열 테스트 */
	public static void main(String[] args) {
		//doA();
		doB();
	}
	
	/* 행마다 열크기 다르게 지정 */
	public static void doB() {
		// 1반 80, 90
		// 2반 70, 60, 50, 88
		// 3반 95, 87, 67
		
		// 출력양식
		// 1반 : 80 90 
		// [총점:000, 평균:000]
		
		// 2반 : 70 60 50 88 
		// [총점:000, 평균:000]
		
		// 3반 : 95 87 67  
		// [총점:000, 평균:000]

		int[][] scores = new int[3][];
		
		scores[0] = new int[2];
		scores[1] = new int[4];
		scores[2] = new int[3];
		
		// 1반 80, 90
		scores[0][0] = 80;
		scores[0][1] = 90;

		// 2반 70, 60, 50, 88
		scores[1][0] = 70;
		scores[1][1] = 60;
		scores[1][2] = 50;
		scores[1][3] = 88;

		// 3반 95, 87, 67
		scores[2][0] = 95;
		scores[2][1] = 87;
		scores[2][2] = 67;

		int sum = 0;
		
		for (int i = 0; i < scores.length; i++) { 
			sum = 0;
			
			System.out.print((i + 1) + "반 " + "\t");
			for(int j = 0; j < scores[i].length; j++) {
				sum += scores[i][j];
				System.out.print(scores[i][j] + "\t");
			}
			System.out.println();
			System.out.println("[총점:" + sum + ", 평균:" + (sum / scores[i].length) +"]");
			System.out.println();
		}
		
	}

	/* 행과 열크기 동일하게 지정 */
	public static void doA() {
		// 1반 80, 90, 70, 80
		// 2반 70, 60, 50, 88
		// 3반 95, 87, 67, 92
		
		// 출력양식
		// 1반 : 80 90 70 80 [총점:000, 평균:000]
		// 2반 : 70 60 50 88 [총점:000, 평균:000]
		// 3반 : 95 87 67 92 [총점:000, 평균:000]
		
		// 1.선언 + 2.생성
		int[][] scores = new int[3][4];
		
		// 3. 2차원배열요소 값할당
		// 1반 80, 90, 70, 80
		scores[0][0] = 80;
		scores[0][1] = 90;
		scores[0][2] = 70;
		scores[0][3] = 80;
		
		// 2반 70, 60, 50, 88
		scores[1][0] = 70;
		scores[1][1] = 60;
		scores[1][2] = 50;
		scores[1][3] = 88;

		// 3반 95, 87, 67, 92
		scores[2][0] = 95;
		scores[2][1] = 87;
		scores[2][2] = 67;
		scores[2][3] = 92;
		
		// 3. 2차원배열요소 출력
//		for (int i = 0; i < scores.length; i++) {	// 행크기만큼 반복
//			for (int j = 0; j < scores[i].length; j++) { // 해당행의 열크기만큼 반복
//				System.out.print(scores[i][j] + "\t");
//			}
//			System.out.println();
//		}
		
		int sum = 0;
		
		// 1반 : 80 90 70 80 [총점:000, 평균:000]
		for (int i = 0; i < scores.length; i++) { 
			sum = 0;
			
			System.out.print((i + 1) + "반 " + "\t");
			for(int j = 0; j < scores[i].length; j++) {
				sum += scores[i][j];
				System.out.print(scores[i][j] + "\t");
			}
			System.out.print("[총점:" + sum + ", 평균:" + (sum / scores[i].length) +"]");
			System.out.println();
		}
	
	}
}
















