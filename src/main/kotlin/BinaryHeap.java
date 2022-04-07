import java.util.Arrays;

public class BinaryHeap {
    private int[] list = new int[10];
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int value) {
        ensureCapacity(size+1);
        list[size++] = value;
        int i = size - 1;
        int parent = (i - 1) / 2;

        while (i > 0 && list[parent] < list[i]) {
            int temp = list[i];
            list[i] = list[parent];
            list[parent] = temp;

            i = parent;
            parent = (i - 1) / 2;
        }
    }

    private void ensureCapacity(int size) {
        if (list.length <= size) {
            list = Arrays.copyOf(list, list.length * 2);
        }
    }

    public void heapify(int i) {
        while (true) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            int largestChild = i;

            if (leftChild < size && list[leftChild] > list[largestChild]) {
                largestChild = leftChild;
            }

            if (rightChild < size && list[rightChild] > list[largestChild]) {
                largestChild = rightChild;
            }

            if (largestChild == i) {
                break;
            }

            int temp = list[i];
            list[i] = list[largestChild];
            list[largestChild] = temp;
            i = largestChild;
        }
    }

    public void buildHeap(int[] sourceArray) {
        list = sourceArray;
        size = sourceArray.length;
        for (int i = size/2; i >= 0; i--) {
            heapify(i);
        }
    }

    public void heapSort(int[] array) {
        buildHeap(array);
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = remove();
            heapify(0);
        }
    }

    public int remove() {
        int result = list[0];
        list[0] = list[--size];
        heapify(0);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(list[0]);
        for (int i = 1; i < size; i++) {
            sb.append(" ").append(list[i]);
        }
        return sb.toString();
    }
}
