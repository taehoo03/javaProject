package exception.classcat;

public class Parent {
	private int p; //private 상속되지 않는다
	 int p2;
	 public int p3;
	
	public void setParent() {// public 이므로 동일 패키지 또는 다른 패키지 클래스에 상속될 수있음
		p=10;
	}
	public void showParent() {//default 기 때문에 동일 패키지 클래스에 상속되고 패키지가 다르면 상속되지 않음
		System.out.println("부모 클래스 p :"+ p);
	}