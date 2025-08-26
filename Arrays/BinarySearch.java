public class BinarySearch {
    public static  int search(int[] arr, int key){

        int start = 0 , end = arr.length-1;
            while(start<=end){
                int mid = (start+end)/2;
                if(arr[mid]==key){
                    return mid;
                }
                if(arr[mid] <key){
                    start = mid +1;
                }
                else{
                    end = mid-1;
                }
            }
        return -1;
    }
    public static void main(String[] args) {
        int key =7;
    int [] numbers = {1,2,3,4,5,6,7};
    int result = search(numbers,key);
        System.out.println(result);
    }
}
