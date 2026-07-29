package extendsex.instarray;
import java.util.Scanner;
public class Person {
		static Scanner s = new Scanner(System.in);
		
		String name;
		int age,height,weight;
		
		public void input() {
			
			System.out.println("\n성명 입력: ");
			this.name =s.next();
			System.out.println("\n나이 입력: ");
			this.age =s.nextInt();
			System.out.println("\n키 입력: ");
			this.height =s.nextInt();
			System.out.println("\n몸무게 입력: ");
			this.weight =s.nextInt();
		}
		
		public void output() {
			System.out.print(name +" ");
			System.out.print(age +" 살");
			System.out.print(height +"cm ");
			System.out.print(weight +"kg ");
			System.out.println();
		}
}
