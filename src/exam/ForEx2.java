package exam;
import java.util.Scanner;
public class ForEx2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.print("단 수 입력 : ");
		num = sc.nextInt();

		System.out.println(num + "단");
			
			for(int n=1;n<=9;n++) {
				System.out.println(num+"x" +n +"="+(num*n));
			}
			sc.close();
		}

	}

