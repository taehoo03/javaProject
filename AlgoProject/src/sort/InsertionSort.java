package sort;

public class InsertionSort {

	public static void main(String[] args) {
		// 삽입 정렬
		int[]arr = {5,2,8,3,1};
		
		insertionSort(arr);
		

	}
	static void insertionSort(int [] arr) {
		int temp,index;
		
		System.out.println("초기 배열 : ");
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]+ "");
		}
		System.out.println();
		System.out.println("\n정렬 진행");
		
		
		for(int i=1;i<arr.length;i++) {
			System.out.println();
			
			System.out.println("k 값  : " + arr[i]);
			temp = arr[i];
			index = i-1;
			
			while(index >=0 && temp < arr[index]) {
				System.out.printㅣㅜ(arr[index] + "이동 : " + " ");
				arr[index+1]=  arr[index];
				index--;
			}
			/*
			 * 반복문이 종료되면 앞의 원소가 k값 보다 작다는 의미
			 * k원소는 index 원소보다 오른쪽에 와야하므로 
			 * index +1 에 위치
			 */
			arr[index+1] = temp;
			
			for(int k=0;k<arr.length -1; k++) {
				System.out.println(arr[k]+ "");
				
				
				}
		}
		System.out.println();
		System.out.print("정렬된 배열 : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + "");
		}
		}
	
}

