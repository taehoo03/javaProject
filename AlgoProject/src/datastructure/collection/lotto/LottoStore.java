package datastructure.collection.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LottoStore {

	
	public void lottoStoreStart() {

		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println();
			System.out.println("================================");
			System.out.println("          Lotto 프로그램");
			System.out.println("================================");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("================================");
			System.out.print("메뉴를 선택하세요 : ");

			int menu = sc.nextInt();

			switch (menu) {

			case 1:

				System.out.print("받은 금액을 입력하세요 : ");
				int money = sc.nextInt();

				if (money < 1000) {
					System.out.println("로또는 1장에 1000원입니다.");
					break;
				}

				getLotto(money);

				break;

			case 2:

				System.out.println("프로그램을 종료합니다.");
				sc.close();
				return;

			default:

				System.out.println("잘못된 메뉴입니다.");

			}
		}
	}

	
	public void getLotto(int money) {

		Set<Integer> lottoSet = new HashSet<>();

		int num = money / 1000;

		System.out.println();
		System.out.println("받은 금액은 " + money + "원입니다.");
		System.out.println("로또는 아래와 같습니다");

		for (int i = 1; i <= num; i++) { // 로또 장 수

			while (lottoSet.size() < 6) { // 로또 번호 생성

				lottoSet.add((int) (Math.random() * 45 + 1));

			}

			
			ArrayList<Integer> lottoList = new ArrayList<>(lottoSet);

			Collections.sort(lottoList);

			System.out.println("로또 번호 " + i + " : " + lottoList);

			lottoSet.clear();
		}

		int change = money % 1000;

		System.out.println();
		System.out.println("받은 금액은 " + money + "원이고 거스름돈은 "
				+ change + "원입니다.");
	}

	public static void main(String[] args) {

		new LottoStore().lottoStoreStart();

	}

}
