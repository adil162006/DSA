public class RotateSorting {
    public static int search(int[]arr,int si,int ei,int tar){
        if (si > ei) return -1;
        int mid = si + (ei-si)/2;
        if(arr[mid]==tar){
            return mid;
        }
        //case 1 : on line 1
        if(arr[si]<=arr[mid]){
            if (arr[si]<=tar && tar<=arr[mid]) {
                return search(arr, si, mid - 1, tar);
            }
            else{
                return search(arr,mid+1,ei,tar);
            }
        }
        //case 2 : on line2
        else{
            if(arr[mid]<=tar && tar<=arr[ei]){
                return search(arr,mid+1,ei,tar);
            }
            else {
                return search(arr,si,mid-1,tar);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        int index = search(arr, 0, arr.length - 1, target);
        System.out.println("Target " + target + " found at index: " + index);

        target = 3;
        index = search(arr, 0, arr.length - 1, target);
        System.out.println("Target " + target + " found at index: " + index);
    }
}
