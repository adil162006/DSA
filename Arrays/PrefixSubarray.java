public class PrefixSubarray {
 static    void print(int[] arr){
        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        int [] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        //print prefix sum

        for (int i = 1; i < arr.length ; i++) {
            prefixSum[i]= prefixSum[i-1] + arr[i];
        }

        for (int i = 0; i <arr.length ; i++) {

            for (int j = i; j <arr.length ; j++) {
                sum = 0;  // ✅ Reset sum for every subarray from i to j
                    sum = i ==0 ? prefixSum[j] : prefixSum[j] - prefixSum[i-1];
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
