package com.work.static_test;

public class StaticTest {
	// class 멤버변수(static)
	public static String classTitle = "빅데이터과정";
	
	// instance 멤버변수
	public String instanceTitle = "자바프로그래밍";
	
	public static void main(String[] args) {
		System.out.println(classTitle);
//		System.out.println(instanceTitle); // error : Cannot make a static reference to the non-static field instanceTitle
		StaticTest test = new StaticTest();
		System.out.println(test.instanceTitle); // 같은 클래스에 있는 instance 멤버는 static 메서드에서는 반드시 명시적으로 생성후 참조변수를 통해서 사용
		
		System.out.println(Math.random());
		System.out.println(Math.random()*10);
		System.out.println((int)(Math.random()*10));
		System.out.println(Math.PI);
	}
	
	public void instanceMethod() {
		System.out.println(instanceTitle); // ok :같은 클래스에 있는 instance 멤버끼리는 그냥 호출 사용(메모리 로딩시점이 동일 함께 이루어짐)
	}

	public static void main1(String[] args) {
		SimpleMember dto1 = new SimpleMember();
		
		System.out.println();
		SimpleMember dto2 = new SimpleMember();
		
		dto1.classCount = 1000;
		dto1.instanceCount = 100;
		
		dto2.classCount = 2000;
		dto2.instanceCount = 200;
		
		SimpleMember.classCount = 5000;
		
		System.out.println(dto1.classCount);
		System.out.println(dto1.instanceCount);
		
		System.out.println();
		System.out.println(dto2.classCount);
		System.out.println(dto2.instanceCount);

		System.out.println();
		System.out.println(SimpleMember.classCount);
		
	}

}
