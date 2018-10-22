public class HeapSort {
    public static void main(String[] args) {
        int[] array = new int[]{7, 3, 5, 2, 6, 4, 1};
        sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void sort(int[] array) {
        buildMaxHeap(array);
        debugLine(array);
        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            maxHeap(array, i, 0);
            debugLine(array);
        }
    }

    /**
     * 构建大顶堆
     *
     * @param array
     */
    private static void buildMaxHeap(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int half = (array.length >> 1) - 1;
        for (int i = half; i >= 0; i--) {
            maxHeap(array, array.length, i);
        }
    }

    /**
     * 构建指定根结点的大顶堆
     *
     * @param array
     * @param heapSize 堆的大小
     * @param index    结点索引
     */
    private static void maxHeap(int[] array, int heapSize, int index) {
        int left = (index << 1) + 1;
        int right = (index << 1) + 2;

        int largest = index;
        if (left < heapSize && array[left] > array[largest]) {
            largest = left;
        }
        if (right < heapSize && array[right] > array[largest]) {
            largest = right;
        }
        if (index != largest) {
            swap(array, index, largest);
            maxHeap(array, heapSize, largest);
        }
    }

    private static void swap(int[] array, int m, int n) {
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }

    private static void debugLine(int[] array) {
        for (int h : array) {
            System.out.print(h + " ");
        }
        System.out.println();
    }
}