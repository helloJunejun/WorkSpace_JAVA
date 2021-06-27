package com.work.view;

import java.util.Random;

public class Lotto645 {

	public static void main(String[] args) {
		int[] lottos = new int[6];
		int uniqueLength = 0;
		
		int randomNo;
		outerLoop:
		while(uniqueLength < 6) {
			randomNo = getLottoNo();
			
			for (int index = 0; index < uniqueLength; index++) {
				if (lottos[index] == randomNo) {
					continue outerLoop;
				}
			}
			
			lottos[uniqueLength++] = randomNo;
		}
		
		System.out.print("[1등 당첨예약 번호] ");
		for (int index = 0; index < lottos.length; index++) {
			System.out.print(lottos[index] + "\t");
		}
		System.out.println();
		
	}

	public static int getLottoNo() {
		Random random = new Random((long)(Math.random() * System.nanoTime()));
		return random.nextInt(45) + 1;
	}
	
}
