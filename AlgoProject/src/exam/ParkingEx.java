package exam;

import java.util.Scanner;
import datastructure.queue.MyQueueMove;

public class ParkingEx {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("주차 가능 대수를 입력하세요 : ");
        int parkingSize = sc.nextInt();

        MyQueueMove parking = new MyQueueMove(parkingSize);

        // 차량별 주차시간 저장
        char[] carList = new char[parkingSize];
        long[] parkingTime = new long[parkingSize];

        while (true) {

            System.out.println();
            System.out.println("0. 주차여부확인");
            System.out.println("1. 자동차 주차");
            System.out.println("2. 자동차 출차");
            System.out.println("3. 만차 여부");
            System.out.println("4. 종료");
            System.out.print("메뉴 선택 : ");

            int menu = sc.nextInt();

            switch (menu) {

            // 0. 주차여부확인
            case 0:

                if (parking.isEmpty()) {

                    System.out.println("주차된 차량이 없습니다.");

                } else {

                    System.out.println("현재 주차된 차량");
                    parking.showQueue();
                }

                break;

            // 1. 자동차 주차
            case 1:

                if (parking.isFull()) {

                    System.out.println("주차장이 만차입니다.");
                    break;
                }

                System.out.print("차량 고유문자를 입력하세요 : ");
                char car = sc.next().charAt(0);

                // 이미 주차된 차량인지 확인
                if (parking.contains(car) != -1) {

                    System.out.println("이미 주차된 차량입니다.");
                    break;
                }

                // 큐에 차량 저장
                parking.enqueue(car);

                // 차량 주차시간 저장
                for (int i = 0; i < parkingSize; i++) {

                    if (carList[i] == '\0') {

                        carList[i] = car;
                        parkingTime[i] = System.currentTimeMillis();

                        break;
                    }
                }

                System.out.println(car + " 차량 주차 완료");

                break;

            // 2. 자동차 출차
            case 2:

                if (parking.isEmpty()) {

                    System.out.println("주차된 차량이 없습니다.");
                    break;
                }

                System.out.print("출차할 차량의 고유문자를 입력하세요 : ");
                char outCar = sc.next().charAt(0);

                // 차량이 주차되어 있는지 확인
                if (parking.contains(outCar) == -1) {

                    System.out.println("해당 차량이 주차되어 있지 않습니다.");
                    break;
                }

                // 출차 차량의 주차시간 찾기
                long outCarTime = 0;

                for (int i = 0; i < parkingSize; i++) {

                    if (carList[i] == outCar) {

                        outCarTime = parkingTime[i];
                        break;
                    }
                }

                // 현재 시간
                long currentTime = System.currentTimeMillis();

                // 경과 시간
                long elapsedTime = currentTime - outCarTime;

                // 1시간 = 60분 * 60초 * 1000
                long oneHour = 60 * 60 * 1000;

                // 1시간이 지나지 않은 경우
                if (elapsedTime < oneHour) {

                    System.out.println(
                        outCar + " 차량은 1시간이 경과하지 않아 출차할 수 없습니다."
                    );

                    break;
                }

                /*
                 * 현재 큐의 차량들을 임시 배열에 저장
                 */
                int count = parking.size();

                char[] temp = new char[count];

                for (int i = 0; i < count; i++) {
                    temp[i] = parking.dequeue();
                }

                // 출차 차량의 위치
                int targetIndex = -1;

                for (int i = 0; i < count; i++) {

                    if (temp[i] == outCar) {

                        targetIndex = i;
                        break;
                    }
                }

                /*
                 * 출차 차량보다 먼저 주차된 차량이 있는지 확인
                 */
                boolean penalty = false;

                if (targetIndex > 0) {
                    penalty = true;
                }

                /*
                 * 패널티 적용
                 */
                if (penalty) {

                    System.out.println(
                        outCar + " 차량보다 먼저 주차된 차량이 있습니다."
                    );

                    System.out.println(
                        "패널티 적용! " +
                        outCar +
                        " 차량의 출차 순서가 마지막으로 변경됩니다."
                    );

                    // 출차 차량을 제외하고 다시 큐에 저장
                    for (int i = 0; i < count; i++) {

                        if (temp[i] != outCar) {
                            parking.enqueue(temp[i]);
                        }
                    }

                    // 출차 차량을 마지막에 저장
                    parking.enqueue(outCar);

                } else {

                    /*
                     * 정상 출차
                     */
                    for (int i = 0; i < count; i++) {

                        if (temp[i] != outCar) {
                            parking.enqueue(temp[i]);
                        }
                    }

                    System.out.println(
                        outCar + " 차량 출차 완료"
                    );

                    // 주차시간 정보 삭제
                    for (int i = 0; i < parkingSize; i++) {

                        if (carList[i] == outCar) {

                            carList[i] = '\0';
                            parkingTime[i] = 0;

                            break;
                        }
                    }
                }

                break;

            // 3. 만차 여부
            case 3:

                if (parking.isFull()) {

                    System.out.println("주차장이 만차입니다.");

                } else {

                    System.out.println(
                        "주차 가능 공간이 있습니다."
                    );

                    System.out.println(
                        "현재 주차 대수 : " +
                        parking.size() +
                        "/" +
                        parkingSize
                    );
                }

                break;

            // 4. 종료
            case 4:

                System.out.println("프로그램을 종료합니다.");
                sc.close();
                return;

            default:

                System.out.println("잘못된 메뉴입니다.");
            }
        }
    }
}