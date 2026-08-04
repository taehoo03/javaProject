package exam.Exception;
import java.util.Scanner;

public class ExceptionEx {

    public static void main(String[] args) {

        int num1, num2;
        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("정수 1 입력 : ");
            num1 = sc.nextInt();

            System.out.print("정수 2 입력 : ");
            num2 = sc.nextInt();

            if (num2 == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }

            System.out.println("나누기 결과 : " + (num1 / num2));

        } catch (ArithmeticException e) {

            System.out.println(e.getMessage());

        }

        sc.close();
    }

}