public class MaxSubarraySum {
    public static void print(int[] arr){
        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        for (int i = 0; i <arr.length ; i++) {

            for (int j = i; j <arr.length ; j++) {
            sum = 0;  // ✅ Reset sum for every subarray from i to j
                for (int k = i; k <= j ; k++) {
                    sum+= arr[k];
                }
                System.out.println(sum);
                if (sum>maxSum){
                    maxSum= sum;
                }
            }
        }
            System.out.println("max sum is " + maxSum);
    }

    public static void main(String[] args) {
        int[] arr = {1,-2,6,-1,3};
        print(arr);

    }
}
