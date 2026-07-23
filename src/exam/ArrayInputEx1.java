package exam;

import java.util.Scanner;

public class ArrayInputEx1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] num = new int[5];

        System.out.println("숫자  입력");

      
        for (int i = 0; i < num.length; i++) {
            System.out.print("num["+i+"] : ");
            num[i] = sc.nextInt();
        }

        
        System.out.print("입력된 값 : ");
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }

      
        int max = num[0];

        for (int i = 1; i < num.length; i++) {
            if (num[i] > max) {
                max = num[i];
            }
        }

        System.out.println();
        System.out.println("최대값 : " + max);
    }
}