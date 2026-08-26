package exam.sort;

public class HeapSort {

    private static void printTree(int[] heap, int size) {
        int level = 0;
        int index = 0;

        while (index < size) {
            int count = 1 << level;

            for (int i = 0; i < count && index < size; i++) {
                System.out.print(heap[index++] + " ");
            }

            System.out.println();
            level++;
        }

        System.out.println();
    }

    private static void insert(int[] heap, int size, int value) {

        int index = size;
        heap[index] = value;

        while (index > 0) {

            int parent = (index - 1) / 2;

            if (heap[parent] >= heap[index]) {
                break;
            }

            int temp = heap[parent];
            heap[parent] = heap[index];
            heap[index] = temp;

            index = parent;
        }
    }

    private static void heapify(int[] heap, int size, int index) {

        while (true) {

            int left = index * 2 + 1;
            int right = index * 2 + 2;

            int largest = index;

            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }

            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }

            if (largest == index) {
                break;
            }

            int temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;

            index = largest;
        }
    }

    public static void main(String[] args) {

        int[] data = {2, 4, 5, 7, 3, 10, 8, 1, 9, 6};

        int[] heap = new int[data.length];

        int size = 0;

        System.out.println("================================");
        System.out.println("       힙에 추가하는 단계");
        System.out.println("================================");

        for (int value : data) {

            insert(heap, size, value);
            size++;

            System.out.println("[" + value + " 추가]");
            printTree(heap, size);
        }

        System.out.println("================================");
        System.out.println("          정렬 단계");
        System.out.println("================================");

        for (int i = size - 1; i > 0; i--) {

            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;

            System.out.println("[" + heap[i] + " 제거]");

            printTree(heap, i);

            heapify(heap, i, 0);
        }

        System.out.println("================================");
        System.out.print("최종 정렬 결과 : ");

        for (int value : heap) {
            System.out.print(value + " ");
        }

        System.out.println();
        System.out.println("================================");
    }
}