package exam;

import java.util.Scanner;

public class ControlEx {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int code, count;
		int price = 0;
		int pay;
		double discount = 0;
		String product = "";

		System.out.println("****** 상품 정보 ******");
		System.out.println("1. 노트북 : 1,200,000원");
		System.out.println("2. 디지털카메라 : 400,000원");
		System.out.println("**********************");

		System.out.print("상품번호 입력 : ");
		code = sc.nextInt();

		// 상품번호 선택
		switch (code) {
		case 1:
			product = "노트북";
			price = 1200000;
			break;

		case 2:
			product = "디지털카메라";
			price = 400000;
			break;

		default:
			System.out.println("잘못 입력하였습니다. 프로그램을 종료합니다.");
			sc.close();
			return;
		}

		System.out.print("주문 수량 입력 : ");
		count = sc.nextInt();

		pay = price * count;

		// 할인율 결정
		if (pay >= 1000000) {
			discount = 0.10;
		} else if (pay >= 500000) {
			discount = 0.05;
		} else {
			discount = 0;
		}

		System.out.println("\n****** 주문 내역 ******");
		System.out.println("상품명 : " + product);
		System.out.println("가격 : " + price + "원");
		System.out.println("주문수량 : " + count + "개");
		System.out.println("주문액 : " + pay + "원");
		System.out.println("할인액 : " + (int) (pay * discount) + "원");
		System.out.println("총 지불액 : " + (int) (pay - pay * discount) + "원");

		sc.close();
	}
}

