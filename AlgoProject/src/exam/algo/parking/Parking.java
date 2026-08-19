package exam.algo.parking;

import java.util.Scanner;

import datastructure.LinkedList.LinkedList;

public class Parking {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		LinkedList parking = new LinkedList();

		System.out.print("주차 가능 대수를 입력하세요 : ");
		int parkingSize = sc.nextInt();
		sc.nextLine();

		// 주차 위치를 배열로 관리
		String[] parkingSpace = new String[parkingSize];

		for(int i = 0; i < parkingSize; i++) {
			parkingSpace[i] = null;
		}

		while(true) {

			System.out.println();
			System.out.println("===== 주차 관리 프로그램 =====");
			System.out.println("0. 주차여부 확인");
			System.out.println("1. 자동차 주차");
			System.out.println("2. 자동차 출차");
			System.out.println("3. 만차여부");
			System.out.println("4. 주차상태 확인");
			System.out.println("5. 종료");
			System.out.print("메뉴 선택 : ");

			int menu = sc.nextInt();
			sc.nextLine();

			// 0. 주차여부 확인
			if(menu == 0) {

				System.out.print("차량 번호 입력 : ");
				String car = sc.nextLine();

				boolean find = false;

				for(int i = 0; i < parkingSize; i++) {

					if(car.equals(parkingSpace[i])) {

						System.out.println(car + " 차량은 "
								+ (i + 1) + "번 위치에 주차되어 있습니다.");

						find = true;
						break;
					}
				}

				if(!find) {
					System.out.println(car + " 차량은 주차되어 있지 않습니다.");
				}
			}

			// 1. 자동차 주차
			else if(menu == 1) {

				System.out.print("주차할 위치 입력 (1~" + parkingSize + ") : ");
				int position = sc.nextInt();
				sc.nextLine();

				if(position < 1 || position > parkingSize) {
					System.out.println("잘못된 주차 위치입니다.");
					continue;
				}

				// 해당 위치가 비어있는지 확인
				if(parkingSpace[position - 1] != null) {

					System.out.println(position + "번 위치에는 이미 "
							+ parkingSpace[position - 1]
							+ " 차량이 주차되어 있습니다.");

					continue;
				}

				System.out.print("차량 번호 입력 : ");
				String car = sc.nextLine();

				// 이미 주차되어 있는 차량인지 확인
				boolean duplicate = false;

				for(int i = 0; i < parkingSize; i++) {

					if(car.equals(parkingSpace[i])) {
						duplicate = true;
						break;
					}
				}

				if(duplicate) {

					System.out.println(car + " 차량은 이미 주차되어 있습니다.");

				} else {

					parkingSpace[position - 1] = car;

					// LinkedList에도 차량 추가
					parking.insertNode(car);

					System.out.println(car + " 차량이 "
							+ position + "번 위치에 주차되었습니다.");
				}
			}

			// 2. 자동차 출차
			else if(menu == 2) {

				System.out.print("출차할 차량 번호 입력 : ");
				String car = sc.nextLine();

				boolean find = false;

				for(int i = 0; i < parkingSize; i++) {

					if(car.equals(parkingSpace[i])) {

						parkingSpace[i] = null;

						parking.deleteNode(car);

						System.out.println(car + " 차량이 "
								+ (i + 1) + "번 위치에서 출차되었습니다.");

						find = true;
						break;
					}
				}

				if(!find) {
					System.out.println(car + " 차량은 주차되어 있지 않습니다.");
				}
			}

			// 3. 만차여부
			else if(menu == 3) {

				int count = 0;

				for(int i = 0; i < parkingSize; i++) {

					if(parkingSpace[i] != null) {
						count++;
					}
				}

				System.out.println("현재 주차 차량 : "
						+ count + "대 / " + parkingSize + "대");

				if(count == parkingSize) {
					System.out.println("주차장이 만차입니다.");
				} else {
					System.out.println("주차장이 만차가 아닙니다.");
				}
			}

			// 4. 주차상태 확인
			else if(menu == 4) {

				System.out.println();
				System.out.println("===== 현재 주차 상태 =====");

				for(int i = 0; i < parkingSize; i++) {

					if(parkingSpace[i] == null) {
						System.out.println((i + 1) + "번 : 비어있음");
					} else {
						System.out.println((i + 1) + "번 : "
								+ parkingSpace[i]);
					}
				}
			}

			// 5. 종료
			else if(menu == 5) {

				System.out.println("프로그램을 종료합니다.");
				break;

			} else {

				System.out.println("잘못된 메뉴입니다.");
			}
		}

		sc.close();
	}
}