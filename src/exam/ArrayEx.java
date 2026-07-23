package exam;

import java.util.Scanner;

public class ArrayEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

	
		String[] name = new String[5];
		int[] gram =new int[5];
		int[]list =new int[5];
		int[] read =new int[5];
		String answer ="";
		int num =0;
		
		System.out.print("*** 영어 시험 점수 입력 ****** ");
		System.out.println();
		do {
			System.out.println((num+1)+"번 성명 입력");
			name[num] = sc.next();
			System.out.println((num+1)+"번 문법 점수 입력");
			gram[num] = sc.nextInt();
			System.out.println((num+1)+"번 듣기 점수 입력");
			list[num] = sc.nextInt();
			System.out.println((num+1)+"번 독해 점수 입력");
			read[num] = sc.nextInt();
			num++;
			if(num ==5)
				break;
			

			System.out.println("\n 계속 조회 하시겠습니까? (y/n) 입력 :");
			answer =sc.next();
}while(answer.contentEquals("y"));


		System.out.println("***영어 시험 결과 ***");
		for(int i = 0; i < num; i++) {

		    int score = gram[i] + list[i] + read[i];  

		    int grade;

		    if(score >= 800)
		        grade = 1;
		    else if(score >= 600)
		        grade = 2;
		    else if(score >= 400)
		        grade = 3;
		    else
		        grade = 4;

		    switch(grade) {
		    case 1:
		        System.out.println((i+1) + "번 " + name[i] + " " + score + " 1등급");
		        break;
		    case 2:
		        System.out.println((i+1) + "번 " + name[i] + " " + score + " 2등급");
		        break;
		    case 3:
		        System.out.println((i+1) + "번 " + name[i] + " " + score + " 3등급");
		        break;
		    default:
		        System.out.println((i+1) + "번 " + name[i] + " " + score + " 4등급");
		    }
		}
	
		sc.close();
		
	}

}
