package extendsex.toString;

public class Manager extends Employee{
		//매개변수가 있는 생성자를 super class가 명시하고 있는 경우 명시적으로 생성자 호출을 필요로 함
	
	private String position;
	
	public Manager(String empNo ,String name, String part, String position) {
		super(empNo,name,part);
		this.position =position;
	}
	
	@Override
	public String toString() {//Manager 본연 필드 값  뿐만 아니라 일반적인 사원 정보까지 출력
		
		//super 참조 : 상속받은 상위 클래스 인스턴스를 의미
		
		return super.toString() + "\t|" + position;
		
		//Employee 를 상속받은 Manager 클래스 객체 인스턴스 생성
		Manager mg = new Manager("1234","홍길동","마케팅","대리");
		System.out.println(mg);
				
	}
}
