package com.work.view;

public class GuGuDanTest {
	
	public static void main(String[] args) {
		System.out.println("\n5. 반복문을 활용한 홀수스텝의 구구단 출력");
		
		int dan;
		int step;
		int name;
		for(name = 2; name <= 9; name++) {
			System.out.print(name + "단\t");
		}
			System.out.print("\n");
		
		for(step = 1; step <= 9; step++) {
			for(dan = 2; dan <= 9; dan++) {
				if(step%2 == 1) {					
				System.out.print(dan+ "*" + step + "=" + dan * step+"\t");
				}
			}
			if(step%2 == 1)
			System.out.print("\n");
		}
		
	}
	
	public static void main5(String[] args) {
		System.out.println("\n4. 반복문을 활용한 짝수 구구단 출력");
		
		int dan;
		int step;
		int name;
		for(name = 2; name <= 9; name++) {
			if(name%2 == 0)
			System.out.print(name + "단\t");
		}
		System.out.print("\n");
		
		for(step = 1; step <= 9; step++) {
			for(dan = 2; dan <= 9; dan++) {
				if(dan%2 == 0)
				
				System.out.print(dan+ "*" + step + "=" + dan * step+"\t");
			
			}		
			System.out.println();
	}
		
	}
	
	public static void main4(String[] args) {
		System.out.println("\n3. do~while 구문을 활용한 구구단");
		
		int name = 2;
		do {
			System.out.print(name + "단\t");
			name++;
			
		}while(name<=9);
		System.out.print("\n");
		
		int step = 1;
		do {
			int dan = 2;
			do {
			System.out.print(dan+ "*" + step + "=" + dan * step+"\t");
			dan++;
			} while(dan<=9);
			System.out.print("\n");
			step++;
			
		} while(step <= 9);
			
				
	}
		
		
		
	
		public static void main3(String[] args) {
		System.out.println("\n2. while 구문을 활용한 구구단");
		
		int name = 2;
		while(name <= 9) {
			System.out.print(name + "단\t");
			name++;
		}
		System.out.print("\n");
		
		
		int step = 1;		
		while(step<=9) {
			int dan = 2;
			while(dan<=9) {
			System.out.print(dan+ "*" + step + "=" + (dan * step)+"\t");
			dan++;
		}
			
			System.out.print("\n");
			step++;
	}	
}
	
	public static void main2(String[] args) {
		System.out.println("\n1. for 구문을 활용한 구구단");
		
		int dan;
		int step;
		int name;
		for(name = 2; name <= 9; name++) {
			System.out.print(name + "단\t");
		}
		System.out.print("\n");
		
		for(step = 1; step <= 9; step++) {
			for(dan = 2; dan <= 9; dan++) {
				
				System.out.print(dan+ "*" + step + "=" + (dan * step) +"\t");
			
			}		
			System.out.println();
	}
				
}
		
}
	
/*
 
for(i = 2; i <= 9; i++) {
	for(j = 1; j <= 9; j++) {
	System.out.print(i + "단\t");
		System.out.println(i + "*" + j + " = " + i * j+"\t");		
}

}
System.out.println();*/