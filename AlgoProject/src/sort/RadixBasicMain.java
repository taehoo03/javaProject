package sort;

import java.util.Arrays;

public class RadixBasicMain {
	private static final int MAX_COUNT =15;
	public static void main(String[]args) {
		int[] arr =  new int[MAX_COUNT];
		for(int i=0;i<MAX_COUNT;i++) {
			arr[i] = (int)(Math.random() * MAX_COUNT);
		}
		System.out.println("원본 배열: " + Arrays.toString(arr));
		System.out.println();
		//RadixSort(arr);
		int [] radixSortArr = arr.clone();
		RadixSort.sort(radixSortArr);
		System.out.println("RadixSort 정렬 : "+ Arrays.toString(radixSortArr));
		System.out.println();
	}

}
