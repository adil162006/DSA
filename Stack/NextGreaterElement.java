import java.util.Stack;
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3};
        int[] nextGreater = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i] ){
                s.pop();
            }
            if (s.isEmpty()){
                nextGreater[i] = -1;
            }else{
                nextGreater[i] = arr[s.peek()];
            }
            s.push(i);


        }
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(nextGreater[i]);
        }
    }
}
