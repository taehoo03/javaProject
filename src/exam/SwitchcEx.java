package exam;
import java.util.Scanner;
public class SwitchcEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int score;

		System.out.print("점수 입력 : ");
		score = sc.nextInt();

		switch (score / 10) {
		case 10:
		case 9:
		    System.out.println("학점 : A");
		    break;

		case 8:
		    System.out.println("학점 : B");
		    break;

		case 7:
		    System.out.println("학점 : C");
		    break;

		case 6:
		    System.out.println("학점 : D");
		    break;

		default:
		    System.out.println("학점 : F");
		}
	}

}
