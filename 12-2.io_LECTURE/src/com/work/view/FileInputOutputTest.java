package com.work.view;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileInputOutputTest {

	public static void main(String[] args) {
		// 키보드 입력 => 파일("test.txt") 출력
		
		// 키보드 입력 스트림 : 라인단위
		BufferedReader in = null;
		
		// 라인단위 출력 > 파일 스트림
		PrintWriter out = null;
		
		System.out.println("멋진 자기 소개를 부탁합니다.[종료 ctrl+z]");
		
		// 파일("test.txt") 출력 : 라인단위
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(new FileWriter("test.txt", true)); // append false : default
			String data = null;
			
			while((data = in.readLine()) != null) {
				out.println(data);
			}
			
			System.out.println("파일이 정상 저장되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			out.close();  // 반드시 출력 자원 해제해야 파일에 입력정보가 출력됨. 
		}
	}

}
