package extendsex2;

public class Child2 extends extendsex.Parent {
	private int c;
	
	
	public void setChild() {
		//p=10 //the field Paren.p  is not visible(private 이어서 상속되지 않음)
		setParent();;
		c=20;
		p3 =50; // p3 가 public 이므로  패키지가 달라도 상속 되어짐
	}
	
	public void showChild() {
		//상속받은 클래스에서 super 클래스 상속된 기능 사용 가능
		showParent();
		System.out.println("부모 클래스 p2 :"+ p2);//자식 클래스에서 부모클래스 필드 접근 : default 접근제한 패키지가 다름
		System.out.println("자식 클래스 c :"+ c);
	}
}
