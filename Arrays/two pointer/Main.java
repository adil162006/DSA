import java.util.*;
public class Main {
        public static int[] twoSum(int[] numbers, int target) {
            int lp = 0;
            int rp = numbers.length-1;
            while(lp!=rp){
                if(numbers[lp]+numbers[rp]==target){
                    return new int[]{lp+1,rp+1};
                }
                if(numbers[lp]+numbers[rp]<target){
                    lp++;
                }else{
                    rp--;
                }
            }
            return new int[] {};
        }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n =nums.length;
        for (int i =0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right=n-1;
            int sum = -1*nums[i];

            while(left<right){
                int s = nums[right]+nums[left];
                if(s==sum){
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left<n && nums[left]==nums[left-1]){
                        left++;
                    }
                    while(right>=0 && nums[right]==nums[right+1]){
                        right--;
                    }
                }else if(s<sum){
                    left++;
                }else{
                    right--;
                }

            }
        }
        return result;
    }
    public int threeSumClosest(int[] arr, int target) {
        int n= arr.length;
        int result=0;
        Arrays.sort(arr);
        int MaxDiff=Integer.MAX_VALUE;
        for(int i =0;i<n-2;i++){
            int left = i+1;
            int right=n-1;
            while(left<right){
                int sum = arr[i]+arr[left]+arr[right];
                int diff = Math.abs(sum-target);
                if(MaxDiff>diff){
                    MaxDiff=diff;
                    result=sum;
                }
                if(sum==target){
                    return sum;
                }else if(sum<target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return result;
    }

    public static int removeDuplicates(int[] nums) {
        int count=1;
        int i=0;
        int j=1;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                j++;
            }else{
                nums[i+1]=nums[j];
                i++;
                count++;
            }
        }
        return count;

    }
    public int[] sortedSquares(int[] nums) {
        ArrayList<Integer>pos=new ArrayList<>();
        ArrayList<Integer>neg=new ArrayList<>();
        for(int num:nums){
            if(num<0){
                neg.add(num);
            }else{
                pos.add(num);
            }
        }
        //case 1:all array  elements are negative
        if(pos.size()==0){
            for(int i =0;i<neg.size();i++){
                neg.set(i,neg.get(i)*neg.get(i));
            }
            Collections.reverse(neg);

            return neg.stream().mapToInt(Integer::intValue).toArray();
        }
        //    case 2 : all are positive
        if(neg.size()==0){
            for(int i =0;i<pos.size();i++){
                pos.set(i,pos.get(i)*pos.get(i));
            }

            return pos.stream().mapToInt(Integer::intValue).toArray();
        }
        //    case 3 bot negative and positive
        int n1 = neg.size();
        int n2 = pos.size();
        int [] res = new int[n1+n2];
        int i =0;
        int j=0;
        int id=0;
        //squaring
        //squaring negative
        for (int k=0;k<n1;k++){
            neg.set(k,neg.get(k)*neg.get(k));
        }
        Collections.reverse(neg);
        //squaring positive
        for (int k=0;k<n2;k++){
            pos.set(k,pos.get(k)*pos.get(k));
        }
        while(i<n1&&j<n2){
            if(neg.get(i)<=pos.get(j)){
                res[id++]=neg.get(i++);
            }else{
                res[id++]=pos.get(j++);
            }
        }
        while(i<n1){
            res[id++]=neg.get(i++);
        }
        while(j<n2){
            res[id++]=pos.get(j++);
        }
        return res;
    }
    long countTriplets(int n, int target, long arr[]) {

        Arrays.sort(arr);
        int count=0;
        for(int i=0;i<n-2;i++){
            int left=i+1;
            int right=n-1;
            while(left<right){
                long sum = arr[i]+arr[left]+arr[right];

                if(sum>=target){
                    right--;
                }else{
                    count = count + (right-left);
                    left++;
                }
            }
        }
        return count;

    }
    public void sortColors(int[] arr) {
        int n = arr.length;
        int low =0;
        int high = n-1;
        int mid = 0;
        while(mid<=high){
            if (arr[mid] == 0){
                int temp =arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                low++;
                mid++;
            }else if(arr[mid]==1){
                mid++;
            }else{
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid]= temp;
                high--;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {1,2,2,2,3,3,4,5,6};
        int tar = 11;
        System.out.println(removeDuplicates(arr));
    }
}
