public class BubbleSort{
    public static void main(String[] args){
        int[] array = new int[]{7,3,5,2,1,4,6,3,2,5,7,89,2,1,4,6,0,1};
        sort(array);
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void sort(int[] array){
        for(int i = array.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if (array[j] > array[j + 1]){
                    swap(array, j, j + 1);
                }
            }
            debugLine(array);
        }
    }

    private static void swap(int[] array, int m, int n){
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