import java.util.Stack;
import java.util.*;
public class Main {
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

        // build answer
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Map.Entry<Character, Integer> e = stack.pop();
            sb.append(String.valueOf(e.getKey()).repeat(e.getValue()));
        }

        return sb.reverse().toString();
    }
    public static void main(String[] args) {

    }
}
