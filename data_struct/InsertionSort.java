public class InsertionSort{
    public static void main(String[] args){
        int[] array = new int[]{1,3,5,2,1,4,6,3,2,5,7,89,2,1,4,6,0,1};
        sort(array);
        for(int i : array){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void sort(int[] array){
        for(int i = 1; i < array.length; i++){
            int cur = array[i];
            int j = i;
            while(j > 0 && cur < array[j - 1]){
                array[j] = array[j - 1];
                j--;
            }
            array[j] = cur;
        }
    }
}