import java.util.*;
public class Main {
    public static void generateSubsets(int[] arr,int n,int idx , List<Integer> temp){
        //base case
        if(idx==n){
            System.out.println(temp);
            return;
        }
        //nahi lena hai
        generateSubsets(arr,n,idx+1,temp);
        //lena hai
        temp.add(arr[idx]);
        generateSubsets(arr,n,idx+1,temp);
        temp.remove(temp.size() - 1);
        return;
    }
    public static void generateParentheses(int open,int close , int n, StringBuilder temp){
        if(open==n && close ==n){
            System.out.println(temp);
            return;
        }
        //open

        if(open<n){
            temp.append("(");
            generateParentheses(open+1,close , n ,temp);
            temp.deleteCharAt(temp.length()-1);
        }
        //close
        if(close<open){
            temp.append(")");
            generateParentheses(open,close+1,n,temp);
            temp.deleteCharAt(temp.length()-1);
        }
        return;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> temp = new ArrayList<>();

//        generateSubsets(arr, arr.length, 0, temp);
        StringBuilder sb = new StringBuilder();
        generateParentheses(0,0,3,sb);
    }
}
