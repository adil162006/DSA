public class Main {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int n = arr.length;
        int low=0;
        int high=k-1;
        int sum=0;
        int result = Integer.MIN_VALUE;;
        for(int i=0;i<=high;i++){
            sum+=arr[i];
        }
        while(high<n){
            result=Math.max(result,sum);
            low++;
            high++;
            if(high==n) break;
            sum=sum-arr[low-1]+arr[high];
        }
        return result;
    }
    public int minSubArrayLen(int target, int[] arr) {
        int n = arr.length;
        int low=0;
        int high =0;
        int result=Integer.MAX_VALUE;
        int sum=0;
        while(high<n){
            sum=sum+arr[high];
            while(sum>=target){
                int len = high-low+1;
                result = Math.min(result,len);
                sum = sum-arr[low];
                low++;
            }
            high++;
        }
        return (result==Integer.MAX_VALUE) ? 0:result;
    }
    public static void main(String[] args) {

    }
}
