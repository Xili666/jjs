public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[]{7,3,5,2,1,4,6,3,2,5,7,89,2,1,4,6,0,1};
        sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void sort(int[] array) {
        int step = array.length;
        while ((step = (step >> 1)) >= 1) {
            sort(array, step);
            debugLine(array);
        }
    }

    private static void sort(int[] array, int step) {
        for (int i = step; i < array.length; i++) {
            int j = i;
            int cur = array[i];
            while (j > step - 1 && cur < array[j - step]) {
                array[j] = array[j - step];
                j -= step;
            }
            array[j] = cur;
        }
    }

    private static void debugLine(int[] array) {
        for (int h : array) {
            System.out.print(h + " ");
        }
        System.out.println();
    }
}