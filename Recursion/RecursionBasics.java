public class RecursionBasics {
    public static void printdecr(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        printdecr(n-1);
    }
    public static void printInc(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        printInc(n-1);
        System.out.println(n);
    }
    public static int fact(int n)  {
        if(n==0){
        return 1;
        }
        return n*fact(n-1);
    }
public static int sum(int n){
        if(n==0){
            return 0;
        }
        return n+ sum(n-1);
}
public static int fib(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib(n-2) + fib(n-1);
}
public static boolean isSorted(int[]arr,int n){

        if(n==arr.length-1) return true;
        if(arr[n]>arr[n+1]) return false;
        return isSorted(arr,n+1);
}
public static int firstOccurence(int [] arr, int key,int i){
        if(i== arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstOccurence(arr,key, i+1);
    }
    public static int lastOccurence(int [] arr, int key,int i) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurence(arr, key, i + 1);
        if (isFound == -1 && arr[i] == key) {
            return i;
        }
        return isFound;
    }


        public static int power(int x, int n){
        if(n==0) {
            return 1;
        }
            return x * power(x,n-1);
        }
        public static int optimizedPower(int x , int n){
            if(n==0) {
                return 1;
            }
            int half = optimizedPower(x, n / 2);
            if(n%2!=0){
                return x*half*half;
            }
            return  half * half;
        }
        public static int tilling (int n){
        if(n==0||n==1) return 1;
        return tilling(n-1)+tilling(n-2);
        }
        public static void removeDuplicates(String str , int idx , StringBuilder newStr,boolean[] map){
        if(idx==str.length()){
            System.out.println(newStr);
            return;
        }
        char currChar = str.charAt(idx);
        if(map[currChar-'a']==true){
            removeDuplicates(str,idx+1,newStr,map);
        }else {

            map[currChar-'a'] = true;
            removeDuplicates(str,idx+1,newStr.append(currChar),map);
        }
    }
    public static void main(String[] args) {
//        int n =10;
//        System.out.println("Decending order");
//        printdecr(n);
//        System.out.println("Ascending order");
//        printInc(n);
//        int ans = fact(5);
//        System.out.println(sum(n));
//        System.out.println(tilling(4));
        String str ="appnacollege";
        removeDuplicates(str,0,new StringBuilder(""),new boolean[26]);


    }

}
