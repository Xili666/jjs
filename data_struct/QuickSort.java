public class QuickSort {
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
        if (start < end) {
            int pos = partition(array, start, end);
            sort(array, start, pos);
            sort(array, pos + 1, end);
        }
        debugLine(array);
    }

    private static int partition(int[] array, int start, int end) {
        int piv = array[start];
        while (start < end) {
            while (start < end && array[end] >= piv) {
                end--;
            }
            if (start < end) { // 在piv右方找到 < piv
                array[start++] = array[end];
            }
            while (start < end && array[start] <= piv) {
                start++;
            }
            if (start < end) {// 在piv左方找到 > piv
                array[end--] = array[start];
            }
        }
        array[start] = piv;
        return start;
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