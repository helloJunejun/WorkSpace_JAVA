package com.work.abstract_test;

public class AbstractTest {

	public static void main(String[] args) {
		//Pet pet = new Pet(); // error ? : 추상 클래스는 직접 객체 생성불가
		Pet[] pets = new Pet[5]; // 부모타입의 다형성 반영한 변수 사용 가능
		pets[0] = new Dog();
		pets[1] = new Cat();
		pets[2] = new Cat();
		pets[3] = new Cat();
		pets[4] = new Cat();
		
		for(Pet p : pets) {
			p.eat(); //아 eat을해서 eat이 나오는거구나
		}
		
		pets[0].name = "코코";
		for (Pet p : pets) {
			System.out.println(p.name);
		}
	}

}


abstract class Pet {
	public String name = "씩씩이";
	
	public void eat() {
		System.out.println("애완동물은 음식을 먹습니다.");
	}
	
	public abstract void speak();
	
	public abstract void song();
	
}
/** 자식 클래스 */
class Dog extends Pet {
	
	@Override
	public void eat() {
		System.out.println("사료를 맛나게 먹습니다.");
	}
	
	@Override
	public void speak() {
		System.out.println("멍멍 말을합니다.");
	}
	
	@Override
	public void song() {
		System.out.println("멍멍 노래를 합니다.");
	}
	
	
}

// 고양이
/** 자식 클래스 */
class Cat extends Pet {
	
	@Override
	public void eat() {
		System.out.println("츄르를 맛나게 먹습니다.");
	}
	
	@Override
	public void speak() {
		System.out.println("야옹 말을합니다.");
	}
	
	@Override
	public void song() {
		System.out.println("야옹 노래를 합니다.");
	}
}






