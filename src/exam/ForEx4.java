package exam;
import java.util.Scanner;
public class ForEx4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num;
		int plus = 0;   
		int minus = 0;  
		int zero = 0;   
		for (int i = 1; i <= 10; i++) {

			System.out.print(i + "번째 정수 입력 : ");
			num = sc.nextInt();

			if (num > 0) {
				plus++;
			} else if (num < 0) {
				minus++;
			} else {
				zero++;
			}
		}

		System.out.println("양수 개수 : " + plus);
		System.out.println("음수 개수 : " + minus);
		System.out.println("0의 개수 : " + zero);

		sc.close();

	}

}
