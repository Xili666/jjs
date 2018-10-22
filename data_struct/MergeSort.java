public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{7, 3, 5, 2, 1, 4, 6, 3, 2, 5, 7, 89, 2, 1, 4, 6, 0, 1};
        sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end) {
        if (end <= start) {
            return;
        }
        int mid = (start + end) >> 1;
        sort(array, start, mid);
        sort(array, mid + 1, end);
        merge(array, start, mid, end);
        debugLine(array);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int start = left;
        int end = right;
        int start2 = mid + 1;
        int[] tmpArray = new int[right - left + 1];
        int index = 0;
        while (start <= mid && start2 <= end) {
            if (array[start] <= array[start2]) {
                tmpArray[index++] = array[start++];
            } else {
                tmpArray[index++] = array[start2++];
            }
        }
        while (start <= mid) {
            tmpArray[index++] = array[start++];
        }
        while (start2 <= end) {
            tmpArray[index++] = array[start2++];
        }
        System.arraycopy(tmpArray, 0, array, left, tmpArray.length);
    }

    private static void debugLine(int[] array) {
        for (int h : array) {
            System.out.print(h + " ");
        }
        System.out.println();
    }
}