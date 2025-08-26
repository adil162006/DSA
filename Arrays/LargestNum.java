public class LargestNum {
    public static  int getLargest(int[] arr){
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i]>largest){
                largest = arr[i];
            }
            if (smallest>arr[i]){
                smallest = arr[i];
            }

        }
        return largest;
    }
    public static void main(String[] args) {

        int [] numbers ={1,2,3,4,6,7};
      int result =   getLargest(numbers);

        System.out.println(result);
    }
}
