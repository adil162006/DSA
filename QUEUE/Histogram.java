import java.util.Stack;

public class Histogram {

    public static void area(int[] arr) {
        int n = arr.length;
        int maxArea = 0;
        int[] nsr = new int[n]; // Next Smaller Right
        int[] nsl = new int[n]; // Next Smaller Left

        // Compute Next Smaller Right (NSR)
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            nsr[i] = s.isEmpty() ? n : s.peek();
            s.push(i); // Push current index
        }

        // Compute Next Smaller Left (NSL)
        s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            nsl[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i); // Push current index
        }

        // Calculate maximum area
        for (int i = 0; i < n; i++) {
            int width = nsr[i] - nsl[i] - 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        System.out.println(maxArea);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 6, 2, 3};
        area(arr); // Output: 10
    }
}
