import  java.util.Stack;
public class StockSpanProblem {
    public static void stockSpan(int[] stock,int[] span){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for (int i = 1  ; i < stock.length; i++) {
            while (!s.isEmpty()&& stock[s.peek()]<=stock[i]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }else{
                int preHigh = s.peek();
                span[i]=i-preHigh;
            }
            s.push(i);
        }
     }
    public static void main(String[] args) {

    }
}
