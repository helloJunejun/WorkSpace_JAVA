package com.work.view;

import com.work.model.dto.Member;

public class main {

		public static void main(String[] args) {
			Member dto = new Member("3번","일반 회원", 358, "이순신", 88);
			dto.printInfo();
		}



}
