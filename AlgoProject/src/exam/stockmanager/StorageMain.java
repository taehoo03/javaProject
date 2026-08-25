package exam.stockmanager;

import java.util.Scanner;

public class StorageMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BinarySearchTreeStorage<Product> storage =
				new BinarySearchTreeStorage<Product>();

		storage.add(new Product("melon", 5));
		storage.add(new Product("apple", 5));
		storage.add(new Product("banana", 5));
		storage.add(new Product("orange", 5));
		storage.add(new Product("kiwi", 5));
		storage.add(new Product("mango", 5));
		storage.add(new Product("tomato", 5));

		System.out.print("재고 확인 : ");
		storage.preorder();
		System.out.println();

		while (true) {

			System.out.println();
			System.out.println("===== 재고 관리 프로그램 =====");
			System.out.println("1. 새 품목 등록");
			System.out.println("2. 재고 품목 반출");
			System.out.println("3. 재고 확인");
			System.out.println("0. 종료");
			System.out.print("메뉴 선택 : ");

			int menu = sc.nextInt();
			sc.nextLine();

			if (menu == 1) {

				System.out.print("품목명 : ");
				String productName =
						sc.nextLine();

				System.out.print("재고수량 : ");
				int productStock =
						sc.nextInt();

				sc.nextLine();

				Product product =
						new Product(
								productName,
								productStock);

				if (storage.add(product)) {

					System.out.println(
							"새 품목 등록 완료");

				} else {

					System.out.println(
							"이미 등록된 품목입니다.");
				}

			} else if (menu == 2) {

				System.out.print("품목명 : ");
				String productName =
						sc.nextLine();

				System.out.print("반출수량 : ");
				int quantity =
						sc.nextInt();

				sc.nextLine();

				System.out.println(
						"재고 반출 : "
						+ productName
						+ " "
						+ quantity);

				Product product =
						new Product(productName);

				int result =
						storage.updateStock(
								product,
								quantity);

				System.out.println(
						"재고 반출 결과 : "
						+ result);

				if (result == 0) {

					System.out.println(
							"재고가 없는 품목이므로 재고 품목에서 삭제합니다");

					storage.remove(product);

				} else if (result == -1) {

					System.out.println(
							"반출수량만큼 재고가 없습니다");

				} else if (result == -2) {

					System.out.println(
							"반출하려는 품목이 창고에 없습니다");

				} else {

					System.out.println(
							"재고 반출 완료");
				}

			} else if (menu == 3) {

				System.out.print("재고 확인 : ");

				storage.preorder();

				System.out.println();

			} else if (menu == 0) {

				System.out.println(
						"프로그램을 종료합니다.");

				break;

			} else {

				System.out.println(
						"잘못된 메뉴입니다.");
			}
		}

		sc.close();
	}
}