package extendsex;

public class Child extends Parent{//동일 패키지 내부의 클래스 상속 - default
	private int c;
	
	public void setChild() {
		//p=10 //the field Paren.p  is  not visible(private 이어서 상속되지 않음)
		c=20;
		p3 =50; // p3 가 public 이므로 동일 패키지 또는 패키지가 달라도 상속 되어짐
	}
	
	public void showChild() {
		//상속받은 클래스에서 super 클래스 상속된 기능 사용 가능
		showParent();
		System.out.println("부모 클래스 p2 :"+ p2);//자식 클래스에서 부모클래스 필드 접근 : default 접근제한이고 동일패키지에서는 접근 가능
		System.out.println("자식 클래스 c :"+ c);
	}
}
