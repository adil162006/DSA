public class KadanesAlgorithm {
    static  void print (int [] arr){
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        for (int i = 0; i <arr.length ; i++) {
            cs = Math.max(arr[i], cs + arr[i]);  // continue or start new

           ms= Math.max(cs,ms);
        }
        System.out.println(ms);
    }

    public static void main(String[] args) {
        int[] num = {-2,-3,4,-1,5,-3};
        print(num);
    }
}
