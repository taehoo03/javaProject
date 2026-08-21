package sort;

public class SelectionSort {

	public static void main(String[] args) {
		//선택 정렬
		int []arr =  {5,2,8,3,1};
		selectoinSort(arr);

	static void selectionSort(int []arr) {
		int temp;
		
		System.out.println("초기배열 : ");
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i] + "");
		}
		System.out.println();
		System.out.println("\n 정렬진행 : ");
		//총 라운드 배열크기 -1
		for(int i=0;i<arr.length -1; i++) {
			for(int j  = i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]);
				temp =arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			
		}
		for(int k=0;k<arr.length -1; k++) {
			System.out.println(arr[k]+ "");
			
			
			}
	}
	System.out.println();
	System.out.println("정렬된 배열 : ");
	for(int i=0; i<arr.length; i++) {
		System.out.println(arr[i] + "");
	}
}
}
