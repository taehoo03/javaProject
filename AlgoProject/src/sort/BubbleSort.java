package sort;

public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = {5, 3, 8, 1, 2, 7};
		bubbleSort(arr);

	}

	static void bubbleSort(int[] arr) {
		int temp;

		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = 0; j < arr.length - 1 - i; j++) {

				if (arr[j] > arr[j + 1]) {

					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

			for (int k = 0; k < arr.length; k++) {
				System.out.print(arr[k] + " ");
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("정렬 결과 : ");

		for (int k = 0; k < arr.length; k++) {
			System.out.print(arr[k] + " ");
		}

		System.out.println();
	}
}
		

