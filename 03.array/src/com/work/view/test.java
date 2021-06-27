package com.work.view;

import java.util.Random;

public class test {
	public static void main(String[] args) {
		int count = 20; // 난수 생성 갯수
		int a[] = new int[count];
		Random r = new Random();
		
		for(int i=0; i<count; i++){
			a[i] = r.nextInt(99) + 1; // 1 ~ 99까지의 난수 
			for(int j=0; j<i; j++){
				if(a[i] == a[j]){
					i--;
				}
			}
		}
		for(int i=0; i<count; i++){
			System.out.println("난수 " + (i+1) + " : " + a[i]);
		}
	}
	
	
	public static int getRandomNo() {
		/* 임의의 정수형 숫자를 추출하기 위한 제공 코드입니다. */
		
		Random extractNo = new Random((long)(Math.random() * System.nanoTime()));
		/* 0 ~ 29 사이의 임의의 숫자 추출 */
		int no = extractNo.nextInt(30); 
		return no;
	}
}
