import java.util.*;
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
    public int longestKSubstr(String s, int k) {
        // code here
        int low=0;
        int high;
        int n = s.length();
        Map<Character,Integer>f=new HashMap<>();
        int res=-1;
        for(high=0;high<n;high++){
            char c = s.charAt(high);
            f.put(c,f.getOrDefault(c, 0) + 1);
            while(f.size()>k){
                char leftChar=s.charAt(low);
                f.put(leftChar,f.get(leftChar)-1);
                if(f.get(leftChar)==0){
                    f.remove(leftChar);
                }
                low++;
            }
            if(f.size()==k){
                res=Math.max(res,high-low+1);
            }
        }
        return res;
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer>f=new HashMap<>();
        int low=0;
        int res=0;
        int n = s.length();
        for(int high=0;high<n;high++){
            char c =s.charAt(high);
            f.put(c,f.getOrDefault(c,0)+1);
            int k = high-low+1;
            while(f.size()<k){
                char left = s.charAt(low);
                f.put(left,f.get(left)-1);
                if(f.get(left)==0) {
                    f.remove(left);
                }
                low++;
                k = high-low+1;
            }
            k=high-low+1;
            res = Math.max(res,k);
        }
        return res;

    }
    int find(int[] a) {
        int maxc = -1;
        for (int i = 0; i < 256; i++) {
            maxc = Math.max(maxc, a[i]);
        }
        return maxc;
    }
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int low=0;
        int res=0;
        int [] f = new int[256];
        for(int high=0;high<n;high++){
            f[s.charAt(high)]++;
            int maxCount = find(f);
            int len = high-low+1;
            int diff = len-maxCount;
            while(diff>k){
                f[s.charAt(low)]--;
                low++;
                maxCount = find(f);
                len = high-low+1;
                diff = len-maxCount;
            }
            len = high-low+1;
            res = Math.max(res,len);


        }
        return res;
    }
    public String minWindow(String s, String t) {
        int[] needed = new int[256];
        int[] having = new int[256];

        for (int i = 0; i < t.length(); i++) {
            needed[t.charAt(i)]++;
        }

        int low = 0;
        int start = 0;
        int res = Integer.MAX_VALUE;

        for (int high = 0; high < s.length(); high++) {
            having[s.charAt(high)]++;

            while (sahi(needed, having)) {
                int len = high - low + 1;
                if (res > len) {
                    res = len;
                    start = low;
                }
                having[s.charAt(low)]--;
                low++;
            }
        }

        return res == Integer.MAX_VALUE ? "" : s.substring(start, start + res);
    }

    boolean sahi(int[] needed, int[] having) {
        for (int i = 0; i < 256; i++) {
            if (needed[i] > having[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
