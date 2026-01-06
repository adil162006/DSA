import java.util.Stack;
import java.util.*;


public class Main {

    // Remove adjacent duplicates where k consecutive duplicates are removed
    public String removeDuplicates(String s, int k) {
        Stack<Map.Entry<Character, Integer>> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().getKey() == c) {
                Map.Entry<Character, Integer> top = stack.pop();
                int cnt = top.getValue() + 1;

                if (cnt < k) {
                    stack.push(new AbstractMap.SimpleEntry<>(c, cnt));
                }
            } else {
                stack.push(new AbstractMap.SimpleEntry<>(c, 1));
            }
        }

        // Build result string
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Map.Entry<Character, Integer> e = stack.pop();
            sb.append(String.valueOf(e.getKey()).repeat(e.getValue()));
        }

        return sb.reverse().toString();
    }

    // Previous Greater Element
    public int[] prevNext(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        res[0] = -1;
        st.push(arr[0]);

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }

        return res;
    }

    // Previous Smaller Element
    public int[] prevSmall(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        res[0] = -1;
        st.push(arr[0]);

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }

        return res;
    }

    // Next Greater Element
    public int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        res[n - 1] = -1;
        st.push(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }

        return res;
    }

    // Next Smaller Element
    public int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        res[n - 1] = -1;
        st.push(arr[n - 1]);

        for (int i = n - 2; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }

        return res;
    }

    // Remove adjacent duplicates (k=2 case)
    public String removeDuplicates(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> st = new Stack<>();
        if (s.isEmpty()) return "";
        st.push(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!st.isEmpty() && c == st.peek()) {
                st.pop();
            } else {
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            res.append(st.pop());
        }

        return res.reverse().toString();
    }

    // Helper method to print array
    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Main obj = new Main();

        // Test removeDuplicates with k
        String s1 = "deeedbbcccbdaa";
        System.out.println(obj.removeDuplicates(s1, 3)); // Output: "aa"

        // Test removeDuplicates without k
        String s2 = "abbaca";
        System.out.println(obj.removeDuplicates(s2)); // Output: "ca"

        // Test prevNext (previous greater element)
        int[] arr = {2, 1, 5, 3, 4};
        printArray(obj.prevNext(arr)); // Output: [-1, 2, -1, 5, 5]

        // Test prevSmall (previous smaller element)
        printArray(obj.prevSmall(arr)); // Output: [-1, -1, 1, 1, 3]

        // Test nextGreater (next greater element)
        printArray(obj.nextGreater(arr)); // Output: [5, 5, -1, 4, -1]

        // Test nextSmaller (next smaller element)
        printArray(obj.nextSmaller(arr)); // Output: [1, -1, 3, -1, -1]
    }
}
