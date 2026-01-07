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

    public static void main(String[] args) {

        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;

        System.out.println("=================================");
        System.out.println("Array  : " + Arrays.toString(arr));
        System.out.println("Target : " + target);
        System.out.println("=================================\n");

        int bs = binarySearch(arr, target);
        System.out.println("[Binary Search]");
        System.out.println("Found at index: " + bs + "\n");

        int lb = lowerBound(arr, target);
        int ub = upperBound(arr, target);

        System.out.println("[Lower Bound]");
        System.out.println("First index >= target: " + lb);

        System.out.println("\n[Upper Bound]");
        System.out.println("First index > target : " + ub);

        System.out.println("\n[Search Range]");
        if (lb == -1 || arr[lb] != target) {
            System.out.println("Target not found → [-1, -1]");
        } else {
            int last = (ub == -1) ? arr.length - 1 : ub - 1;
            System.out.println("Range: [" + lb + ", " + last + "]");
        }

        System.out.println("=================================");
    }
}
