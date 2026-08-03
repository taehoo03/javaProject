package exception.classcat;

public class ClassCatExcept {

	public static void main(String[] args) {
		// 상속 관계에 있는 두 클래스
		Child child =new Child();
		 Parent parent;
		 
		 parent =child;
		 
		 //Parent 클래스를 Child 클래스와 Child2 클래스가 상속
		 child2 =(Child2)parent;

	}

}
