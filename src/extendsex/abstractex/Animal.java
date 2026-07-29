package extendsex.abstractex;

public  abstract class Animal {
	public void show() {
		System.out.println("동물입니다.");
	}
	
	//추상 메서드 : 상속받으면 반드시 구현해야함
	public abstract void sound();
}
