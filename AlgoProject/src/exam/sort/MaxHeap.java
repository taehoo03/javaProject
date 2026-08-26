package exam.sort;

public class MaxHeap {

    private int[] heap;
    private int size;

    public MaxHeap(int capacity) {
        heap = new int[capacity];
        size = 0;
    }

    public void add(int value) {
        if (size == heap.length) {
            return;
        }

        heap[size] = value;

        int index = size;

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

        size++;
    }

    public int remove() {
        if (size == 0) {
            return -1;
        }

        int result = heap[0];

        size--;

        heap[0] = heap[size];

        int index = 0;

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

        return result;
    }

    public int[] sort(int[] array) {

        MaxHeap h = new MaxHeap(array.length);

        for (int value : array) {
            h.add(value);
        }

        int[] result = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            result[i] = h.remove();
        }

        return result;
    }
}