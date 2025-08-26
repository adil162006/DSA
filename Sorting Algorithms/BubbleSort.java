public class BubbleSort {
    static void sort(int [] arr){
        for (int i = 0; i <= arr.length-1 ; i++) {
            int swap = 0;
            for (int j = 0; j <arr.length-1-i ; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap++;
                }


            }
            if(swap==0){
                break;
            }
        }



    }
    static void print(int [] arr){
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        sort(arr);
        print(arr);
    }
}
