package loop;

import java.util.Scanner;
public class DoWhile2 {

	public static void main(String[] args) {
		//특정 조건에 대하여 계속 반복하는 프로그램
		Scanner sc = new Scanner(System.in);
		int input = 0;
		String answer ="";
		
		System.out.println("과정 안내 프로그램");
		
		do {
			System.out.print("\n1~4 번호 입력 :" );
					input = sc.nextInt();
					
					switch(input) {
					case 1: System.out.println("Java프로그래밍"); break;
					case 2:System.out.println("데이터베이스"); break;
					case 3:System.out.println("빅데이터 분석"); break;
					case 4:System.out.println("AI"); break;
					default : System.out.println("잘못 입력 하였습니다"); break;
					}
					System.out.println("\n 계속 조회 하시겠습니까? (y/n) 입력 :");
					answer =sc.next();
		}while(answer.contentEquals("y")); //사용자로부터 값을 입력받아 입력된 값이 y 면 계속 반복
		
		System.out.println("종료합니다");
		sc.close();

	}

}
