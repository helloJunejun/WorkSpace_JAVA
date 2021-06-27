package com.work.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StandardTest {

	public static void main(String[] args) {
		System.out.println("키보드에서 영문자/한글한글자 입력하세요 [종료 Ctrl+Z]");
		
		try {
			// byte 단위 읽기
			//int input = System.in.read();
			
			// character 단위 읽기
			//InputStreamReader in = new InputStreamReader(System.in);
			//int input = in.read();
			
			// 라인단위(String) 읽기
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String input = in.readLine();
			
			System.out.println("입력데이터 : " + input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
