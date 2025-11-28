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
    public static void main(String[] args) {
        int arr[] = {1,2,2,2,3,3,4,5,6};
        int tar = 11;
        System.out.println(removeDuplicates(arr));
    }
}
