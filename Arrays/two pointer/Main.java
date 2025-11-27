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
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        int tar = 11;
        System.out.println(twoSum(arr,tar));
    }
}
