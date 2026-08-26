package exam.sort;

public class MaxHeapMain {

    public static void main(String[] args) {

        int[] array = {2, 4, 5, 7, 3, 10, 8, 1, 9, 6};

        MaxHeap heap = new MaxHeap(array.length);

        int[] result = heap.sort(array);

        System.out.print("정렬 결과 : ");

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}