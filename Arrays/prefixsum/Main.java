import java.util.*;
public class Main {
    public void suffix(int[] arr){
        int n = arr.length;;
        int[] suffix = new int[n];
        suffix[n-1] = arr[n-1];
        for(int i = n-2;i>=0;i++){
            suffix[i] = suffix[i+1]+((i+1 < n) ? arr[i+1] : 0);
        }
    }
    public void prefix(int[]arr){
        int n =arr.length;
        int[] prefix = new int[n];
        prefix[0] = 0;

        for(int i =0;i<n;i++){
            prefix[i] = prefix[i-1] + arr[i-1];
        }

    }
    public int pivotIndex(int[] arr) {
        int n = arr.length;
        int sum=0;
        int right=0;
        int left=0;
        for(int i=0; i<n;i++){
            sum +=arr[i];
        }
        if (sum - arr[0] == 0) {
            return 0;
        }

        for(int i =1;i<n;i++){
            left+=arr[i-1];
            right = sum - arr[i]-left;

            if(left==right) {
                return i;
            }
        }

        return -1;
    }
    public int subarraySum(int[] arr, int k) {
        int res=0;
        int sum=0;
        HashMap<Integer,Integer>f=new HashMap<>();
        f.put(0, 1);

        for(int i =0;i<arr.length;i++){
            sum+=arr[i];
            int ques = sum-k;
            int freq = f.getOrDefault(ques,0);
            res+=freq;
            f.put(sum, f.getOrDefault(sum, 0) + 1);
        }
        return res;

    }
    public static void main(String[] args) {

    }
}
