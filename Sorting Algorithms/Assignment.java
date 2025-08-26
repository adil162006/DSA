public class Assignment {
    static  void BubbleSort(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]<arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }

            }
        }
    }
    static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length ; i++) {
            int  c = arr[i];
            int p = i-1;
            while(p>=0 && arr[p]< c){
                arr[p+1] = arr[p];
                p--;
            }
            arr[p+1] = c;
        }

    }
    static void countingSort(int[] arr){

        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length ; i++) {
          largest =Math.max(largest,arr[i]) ;
        };

        int[] count = new int[largest+1];

        for (int i = 0; i < arr.length ; i++) {
            count[arr[i]] ++;
        }
        //sorting
        int j=0;
        for (int i = count.length-1; i >=0 ; i--) {
            while(count[i]>0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }


    }
    static void selectionSort(int[]arr){
        for (int i = 0; i <arr.length ; i++) {
            int p =i;
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[j]>arr[p]){
                    p = j;
                }
            }
            int temp = arr[p];
            arr[p] = arr[i];
            arr[i] = temp;

        }
    }

    static void print(int [] arr){
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] arr = { 3,6,2,1,8,7,4,5,3,1};
//        BubbleSort(arr);
//        selectionSort(arr);
//        insertionSort(arr);
        countingSort(arr);
        print(arr);


    }
}
