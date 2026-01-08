import java.util.Arrays;

public class Main {

    // Standard binary search
    // Returns ANY index where x is found, or -1 if not found
    public static int binarySearch(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == x) return mid;

            if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // LOWER BOUND
    // First index where arr[index] >= x
    public static int lowerBound(int[] arr, int x) {
        int res = -1;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= x) {
                res = mid;        // possible answer
                right = mid - 1;  // move left to find earlier index
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    // UPPER BOUND
    // First index where arr[index] > x
    public static int upperBound(int[] arr, int x) {
        int res = -1;
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > x) {
                res = mid;        // possible answer
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }


    int firstOccurence (int [] arr,int x){
        int low=0; int high=arr.length - 1;
        int res = -1;

        while(low<=high){
            int mid=low + (high-low)/2;
            if(arr[mid]>x){
                high=mid-1;
            } else if (arr[mid]<x) {
                low = mid+1;
            }else{
                res=mid;
                high=mid-1;
            }
        }
        return res;
    }
    int lastOccurence (int [] arr,int x){
        int low=0; int high=arr.length - 1;
        int res = -1;

        while(low<=high){
            int mid=low + (high-low)/2;
            if(arr[mid]>x){
                high=mid-1;
            } else if (arr[mid]<x) {
                low = mid+1;
            }else{
                res=mid;
                low=mid+1;
            }
        }
        return res;
    }
    int[] startAndEndPoint(int[] arr,int target){
        int si=firstOccurence(arr,target);
        int ei=lastOccurence(arr,target);

        return new int[]{si,ei};
    }
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        int low=0;
        int high=n-1;
        int res=-1;
        while(low<=high){
            int mid=low + (high-low)/2;
            if(arr[mid]<arr[mid+1]){
                low=mid+1;
            }else{
                res=mid;
                high=mid-1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println("\n================= BINARY SEARCH =================");
        int[][] bsArrays = {
                {1, 3, 5, 7, 9},
                {2, 4, 6, 8, 10},
                {5, 7, 7, 8, 8, 10},
                {1},
                {10, 20, 30, 40}
        };
        int[] bsTargets = {7, 6, 8, 1, 25};

        for (int i = 0; i < bsArrays.length; i++) {
            System.out.println("Array  : " + Arrays.toString(bsArrays[i]));
            System.out.println("Target : " + bsTargets[i]);
            System.out.println("Index  : " + binarySearch(bsArrays[i], bsTargets[i]));
            System.out.println("----------------------------------");
        }


        System.out.println("\n================= LOWER & UPPER BOUND =================");
        int[][] boundArrays = {
                {1, 3, 3, 5, 7},
                {2, 4, 6, 8, 10},
                {5, 7, 7, 8, 8, 10},
                {1, 1, 1, 1},
                {10, 20, 30, 40}
        };
        int[] boundTargets = {3, 5, 8, 1, 25};

        for (int i = 0; i < boundArrays.length; i++) {
            System.out.println("Array  : " + Arrays.toString(boundArrays[i]));
            System.out.println("Target : " + boundTargets[i]);
            System.out.println("Lower Bound : " + lowerBound(boundArrays[i], boundTargets[i]));
            System.out.println("Upper Bound : " + upperBound(boundArrays[i], boundTargets[i]));
            System.out.println("----------------------------------");
        }


        System.out.println("\n================= FIRST & LAST OCCURRENCE =================");
        Main obj = new Main();

        int[][] occArrays = {
                {5, 7, 7, 8, 8, 10},
                {1, 1, 1, 1, 1},
                {2, 4, 6, 8, 10},
                {3, 3, 3, 3},
                {1, 2, 3, 4, 5}
        };
        int[] occTargets = {8, 1, 6, 3, 9};

        for (int i = 0; i < occArrays.length; i++) {
            System.out.println("Array  : " + Arrays.toString(occArrays[i]));
            System.out.println("Target : " + occTargets[i]);
            int start = obj.firstOccurence(occArrays[i], occTargets[i]);
            int end = obj.lastOccurence(occArrays[i], occTargets[i]);
            System.out.println("Range  : [" + start + ", " + end + "]");
            System.out.println("----------------------------------");
        }


        System.out.println("\n================= PEAK INDEX (MOUNTAIN ARRAY) =================");
        int[][] mountainArrays = {
                {0, 2, 4, 3, 1},
                {1, 3, 5, 7, 6, 4, 2},
                {0, 10, 5, 2},
                {3, 5, 9, 12, 11, 7},
                {1, 4, 6, 8, 7, 3}
        };

        for (int i = 0; i < mountainArrays.length; i++) {
            System.out.println("Mountain Array : " + Arrays.toString(mountainArrays[i]));
            int peak = obj.peakIndexInMountainArray(mountainArrays[i]);
            System.out.println("Peak Index     : " + peak);
            System.out.println("Peak Value     : " + mountainArrays[i][peak]);
            System.out.println("----------------------------------");
        }

        System.out.println("\n================= END =================\n");
    }


}
