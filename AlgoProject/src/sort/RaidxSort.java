package sort;

import java.util.LinkedList;
import java.util.Queue;

public class RaidxSort {

	//10진수 기준으로 구현
	private static int BUCKET_NUM = 10;

	public static void sort(int[]arr) {

		//버킷 생성
		Queue<Integer>[] bucket = new LinkedList[BUCKET_NUM];

		for(int i=0; i<BUCKET_NUM;i++) {
			bucket[i] = new LinkedList<>();
		}

		//정렬 대상에서 가장 자리수가 큰 수의 자리수 반환
		int maxLen = maxDigitCount(arr);
		int digitNumber = 0;
		int arrIndex = 0;

		for(int i=0;i<maxLen;i++) {

			for(int j=0;j<arr.length;j++) {

				digitNumber = getDigit(arr[j],i);
				bucket[digitNumber].add(arr[j]);
			}

			for(int j=0; j<BUCKET_NUM; j++) {

				while(!bucket[j].isEmpty()) {
					arr[arrIndex++] = bucket[j].remove();
				}
			}

			System.out.print((i + 1) + "의 자리 정렬 : ");

			int k = 0;
			while(k < arr.length) {
				System.out.print(arr[k] + " ");
				k++;
			}
			System.out.println();

			arrIndex = 0;
		}
	}

	private static int getDigit(int num,int index) {

		return (int)(Math.floor(Math.abs(num)) / Math.pow(10, index)) % 10;
	}

	private static int maxDigitCount(int[] arr) {

		int max = 0;

		for(int i=0;i<arr.length;i++) {
			max = Math.max(max, digitCount(arr[i]));
		}

		return max;
	}

	private static int digitCount(int num) {

		if(num == 0) {
			return 1;
		}

		int count = 0;

		while(num != 0) {
			num /= 10;
			count++;
		}

		return count;
	}

}