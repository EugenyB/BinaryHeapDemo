import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.add(1);
        queue.add(3);
        queue.add(8);
        queue.add(7);
        queue.add(6);
        queue.add(5);
        queue.add(4);
        System.out.println(queue);
        BinaryHeap heap = new BinaryHeap();
        heap.add(1);
        heap.add(3);
        heap.add(8);
        heap.add(7);
        heap.add(6);
        heap.add(5);
        heap.add(4);
        System.out.println(heap);
        while (!heap.isEmpty()) {
            System.out.print(heap.remove() + " ");
        }
        System.out.println();
    }

    private void run1() {
        BinaryHeap heap = new BinaryHeap();
////        heap.buildHeap(new int[]{1, 3, 8, 7, 6, 5, 4});
//        heap.add(1);
//        heap.add(3);
//        heap.add(8);
//        heap.add(7);
//        heap.add(6);
//        heap.add(5);
//        heap.add(4);
//        System.out.println(heap);
//        while (!heap.isEmpty()) {
//            System.out.print(heap.remove()+" ");
//        }
//
        int[] arr = {1,7,3,4,9,6,3,2};
        heap.heapSort(arr);

        for (int x : arr) {
            System.out.print(x + " ");
        }

    }
}

// 20 11 15 6 9 7 8 1 3 5