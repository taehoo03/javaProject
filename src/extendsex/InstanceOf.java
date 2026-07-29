package extendsex;

class Parent1{
	
	
}
class Child1 extends Parent1{
	
	
}







public class InstanceOf {

	public static void main(String[] args) {
			//객체 타입 확인 예시
		Parent1 p =new Parent1();
		System.out.println(p instanceof Parent1); //true
		System.out.println(p instanceof Child1); //false
		
		Child1 c =new Child1();
		System.out.println(p instanceof Parent1);//true(자동형변환 가능한 관계이므로 true 반환)
		System.out.println(p instanceof Child1); //true
		
		Parent1 pc =new Child1();
		System.out.println(pc instanceof Parent1);//true(자동형변환 가능한 관계이므로 true 반환)
		System.out.println(pc instanceof Child1);
		
		Child1 c2 =(Child1)pc;
		Child1 c3 =(Child1)pc;
		//(p1 instanceof Child1)


	}

}
