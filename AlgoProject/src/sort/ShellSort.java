package sort;

public class ShellSort {
	//Ciura 시퀸스 사용 : 단 알려진건 1750까지만 알려져 있음
	
	private final static int[] gap =
		{ 1, 4, 10, 23, 57, 132, 301, 701, 1750, 3937, 	
		8858, 19930, 44842, 100894, 227011, 510774,
		1149241, 2585792, 5818032, 13090572, 29453787,
		66271020, 149109795, 335497038, 754868335, 1698453753
		};
	
	public static void shellSort(int[]arr a) {
		shellSort(a,a.length);
	}
	private static int getGap(int length) {
		int index = 0;
		int ken = (int)(length/2.25);
		while(gap[index]<len) {
			index++;
		}
		return index;
	}
	private static void shellSort(int[]a, int size) {
		int index = getGap(size);
		
		for(int i=index;i>=0;i--) {
			System.out.println("gap :" + gap[i]);
			for(int j=0;j<gap[i]; j++) {
				insertion_sort(a,j,size,gap[i]);
			}
			System.out.println("gap :"+gap[i] + "삽입 정렬 종료");
			for(int k=0;k<a.length;k++) {
				System.out.print(a[k]+"");
			}
			System.out.println();
		}
	}
	/*
	 * @param a : 배열(정렬 대상)
	 * @param start  : 부분 리스트(부분 배열)의 첫번째 원소 인덱스
	 * @param size : 전체 배열 크기
	 * @param gap : 현재 부분리스트의 간격
	 */
	private static void insertion_sort(int[] a , int start , int size , int gap) {
		//부분 배열의 두번째 원소부터  size 까지 반복함(gap 만큼 건너 뜀)
		for(int i = start+gap;i<size;i+=gap) {
			int target = a[i];
			int j = i-gap;
			while(j>=start &&target<a[j]) {
				a[j+gap] = a[j];
				j-=gap;
			}
			//반복을 벗어나면 target 보다 작은 값의 원소 위치에 있음
			a[j+gap] = target;
			
			for(int k=0;k<a.length;k++) {
				System.out.print(a[k]+ "");
			}
			System.out.println();
		}
	}

}
