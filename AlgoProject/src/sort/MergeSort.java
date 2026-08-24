package sort;

public class MergeSort {	

	private static int[] sorted;

	public static void mergeSort(int a[]) {
		sorted = new int[a.length];
		mergeSort(a,0,a.length-1);
		sorted = null;
	}

	private static void mergeSort(int [] a , int left , int right) {
		/*
		 * left ==right 즉 부분 리스트가1개의 원소만 갖고있는 경우
		 * 더이상 쪼갤수 없을때 return
		 */
		if(left == right) return;

		int mid = (left + right) / 2;

		System.out.print("분할 : ");
		int i = left;

		while(i <= right) {
			System.out.print(a[i] + " ");
			i++;
		}
		System.out.println();

		mergeSort(a,left,mid);
		mergeSort(a,mid+1,right);

		merge(a,left,mid,right);
	}

	/*
	 * 결합할 부분 리스트는 a 배열의 left-right 까지
	 * 
	 * a: 정렬할 배열
	 * left : 배열의 시작
	 *  right : 배열의 끝
	 *  mid: 배열의 중간점
	 */
	private static void merge(int[] a, int left , int mid,int right) {

		int l = left;
		int r = mid+1;
		int idx  = left;  // 정렬 결과를 넣은 idx

		while(l<=mid && r<=right) {

			if(a[l]<=a[r]) {
				sorted[idx] = a[l];
				idx++;
				l++;

			} else {
				sorted[idx] = a[r];
				idx++;
				r++;
			}
		}

		if(l>mid) {

			while(r<=right) {
				sorted[idx] = a[r];
				r++;
				idx++;
			}
		}
		else {

			while(l<=mid) {
				sorted[idx] = a[l];
				l++;
				idx++;
			}
		}

		idx = left;

		while(idx <= right) {
			a[idx] = sorted[idx];
			idx++;
		}

		System.out.print("결합 : ");
		idx = left;

		while(idx <= right) {
			System.out.print(a[idx] + " ");
			idx++;
		}
		System.out.println();
	}

}