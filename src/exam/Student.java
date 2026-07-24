package exam;

import java.util.Scanner;

public class StdInfo(){
	int stdNo;
	String stdName;
	int year;
	int score;
}


public class Student {

	public static void main(String[] args) {
	
	public void input() {
		
		Scanner sc =new Scanner(System.in); 
		System.out.print("학번 : ");
		stdNo =sc.nextInt();
		
		System.out.print("성명 : ");
		stdName =sc.next();
		
		System.out.print("학년 : ");
		year =sc.nextInt();
		
		System.out.print("점수 : ");
		score =sc.nextInt();
  
		
		sc.close(); 
	}

}
