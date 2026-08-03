package nestedclass.thisex;

public class Outter {
		String sield ="Outter-field";
		
		void method() {
			System.out.println("Outter-method");
		}
		
		//인스턴스 멤버클래스(중첩 클래스)
		class  Nested{
			String field ="Nested-field";
			
			void method() {
				System.out.println("Nested-method");

			}
			void print() {
				//Nested 클래스 참조
				System.out.println(this.field);
				this.method();
				//Outter 클래스 참조
				System.out.println(Outter.this.field);
				this.method();
			}
		}
}
