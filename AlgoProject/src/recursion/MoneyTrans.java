package recursion;

import java.util.Scanner;

public class MoneyTrans {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("금액 입력 : ");
        int money = sc.nextInt();

        int[] coin = {5000, 1000, 500, 100, 50, 10};

        for (int i = 0; i < coin.length; i++) {
            int count = money / coin[i];

            if (count > 0) {
                System.out.println(coin[i] + "원 : " +count);
            }

            money = money % coin[i];
        }
        System.out.println("나머지 : "+ money);
    }
}