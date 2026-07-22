package exam;
import java.util.Scanner;
public class ForEx3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i;
		System.out.print("start 입력 : ");
		i = sc.nextInt();
		int j;
		System.out.print("end 입력 : ");
		j = sc.nextInt();
		int sum=0;
		int start =i;
	
		for(;i<=j;i++) {
			sum+=i;
			}
		System.out.println(start+"~"+j+"의 합 : " +sum);
		sc.close();
		}

	}


