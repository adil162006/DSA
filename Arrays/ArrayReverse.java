public class ArrayReverse {
    public static void reverse(int[] arr ){
        int start = 0 , end = arr.length-1;
        int temp;
        while(start<end){
            temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end-- ;


        }

    }
    public static void main(String[] args) {
        int [] numbers = {1,2,3,4,10,33};

        reverse(numbers);
        for (int i = 0; i <numbers.length ; i++) {
            System.out.print(numbers[i] + " ");
        }
    }
}
