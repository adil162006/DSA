public class BitManupulation {



    public static void oddOrEven(int n){
     int bitMask=0;
     if((n & bitMask)==0 ){
         System.out.println("even");
     }else{
         System.out.println("odd");
     }
    }
    //operations on bit
 public static int getIthBit(int n,int i){
    int bitMask = i<<i;
    if((n & bitMask)==1){
        return 1;
    }else{
        return 0;
    }
 }
 public static int setIthBit(int n , int i){
        int bitMask = 1<<n;
        return n|bitMask;

    }

    public static int clearIthBit(int n , int i){
        int bitMask = ~(1<<i);
        return n & bitMask;
    }

    public static int updateIthBit(int n,int i, int newBit){
        int bitMask = newBit<<i;

        return n|bitMask;
    }
     public static int clearLastBits(int n,int i){
        int bitMask = (~0)<<i;
        return n&bitMask;
     }
public static int clearIbits(int n,int i, int j){
        int a = ((~0)<<j+1);
        int b = (1<<i)-1;
        int bitMask = a|b;
        return n & bitMask;
}
public static boolean isPowerOfTwo(int n){

        return  (n & (n-1)) ==0;
}
public static int countSetBits(int n) {
    int count = 0;
    while (n > 0) {
        if ((n & 1) != 0) {
            count++;
        }
        n = n >> 1;
    }
    return  count;
}
public static int fastExpo(int a,int n){
        int ans =1;
        while(n>0) {
            if ((n & 1) != 0) {
                ans = ans * a;

            }
            a = a * a;
            n = n >> 1;
        }
        return ans;
}
    public static void main(String[] args) {
        System.out.println((5&8)); // AND operator
        System.out.println((5|6)); //OR Operator
        System.out.println((5^6)); //XOR Operator
        System.out.println(~5); // 1's Complement
        System.out.println((5<<2)); // Left Shift Operator
        System.out.println((float)(6>>4));// Right Shift OPerator
    }
}

