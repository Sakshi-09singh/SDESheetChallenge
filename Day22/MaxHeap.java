package Day22;

import java.util.ArrayList;

public class MaxHeap {
    ArrayList<Integer> heap;

    public void initializeHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int key) {

        heap.add(key);

        int index = heap.size() - 1;

        // Heapify Up
        while (index > 0) {

            int parent = (index - 1) / 2;

            if (heap.get(parent) < heap.get(index)) {

                swap(parent, index);
                index = parent;

            } else {
                break;
            }
        }
    }

    public void changeKey(int index, int newVal) {

        int oldVal = heap.get(index);

        heap.set(index, newVal);

        // Heapify Up
        if (newVal > oldVal) {

            while (index > 0) {

                int parent = (index - 1) / 2;

                if (heap.get(parent) < heap.get(index)) {

                    swap(parent, index);
                    index = parent;

                } else {
                    break;
                }
            }
        }

        // Heapify Down
        else {
            heapify(index);
        }
    }

    public void extractMax() {

        int n = heap.size();

        if (n == 0) return;

        swap(0, n - 1);

        heap.remove(n - 1);

        heapify(0);
    }

    public boolean isEmpty() {
        return heap.size() == 0;
    }

    public int getMax() {
        return heap.get(0);
    }

    public int heapSize() {
        return heap.size();
    }

    private void heapify(int index) {

        int largest = index;

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        // LEFT child preferred when equal
        if (left < heap.size() && heap.get(left) > heap.get(largest)) {
            largest = left;
        }

        if (right < heap.size() && heap.get(right) > heap.get(largest)) {
            largest = right;
        }

        if (largest != index) {

            swap(index, largest);

            heapify(largest);
        }
    }

    private void swap(int i, int j) {

        int temp = heap.get(i);

        heap.set(i, heap.get(j));

        heap.set(j, temp);
    }
}
