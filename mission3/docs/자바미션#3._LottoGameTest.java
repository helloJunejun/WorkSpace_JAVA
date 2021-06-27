/* 자바 미션 #3 */

package com.work.view;

import java.util.Random;

/**
	# 자바 미션 #3 : 오늘까지 배운 배열을 활용하여서 Lotto645 게임을 구현하세요.
	임의의 숫자를 추출하는 코드는 아래에 제공합니다.

	-- 로또 645는 1~45번 사이의 숫자 6개를 추출하는 게임입니다.
	-- 6개의 번호는 중복번호 불가입니다.
	
	-- 실습1 : 로또 1게임 : 1차원 배열 사용
	-- 실습2 : 로또 5게임 : 2차원 배열 사용
	-- 실습3 : 정렬알고리즘을 활용하여서 중복되지 않게 출력된 6개의 로또 번호를 올림차순정렬하여 출력하도록 해보세요.
*/
public class LottoGameTest {
	public static void main(String[] args) {
	
		// 임의의 숫자 출력 예시:
		for (int index=0; index < 6; index++) {
			System.out.print(getLottoNo());
			System.out.println("\t");
		}
	}

	/** 객체를 생성하지 않고 임의의 1~45 사이의 숫자를 반환하는 메서드 */
	public static int getLottoNo() {
		/* 임의의 정수형 숫자를 추출하기 위한 제공 코드입니다. */
		Random extractNo = new Random((long)(Math.random() * System.nanoTime()));
		int no = extractNo.nextInt(45) + 1; // 0 ~ 44 사이의 임의의 숫자 추출 => +1 => 1 ~ 45 사이 임의숫자 추출
		return no;
	}
}













