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


    public static void doorChoice(int n , int [] arr , int idx , List<String>temp){
        //base case
        if(idx==n){
            System.out.println(temp);
            return;
        }

        //left
        temp.add("left");
        doorChoice(n,arr,idx+1,temp);
        temp.removeLast();

        //right
        temp.add("rigth");
        doorChoice(n,arr,idx+1,temp);
        temp.removeLast();


        return;
    }
    static  HashMap<Character,String>f=new HashMap<>();
    public static List<String> letterCombinations(String digits) {
        f.put('2',"abc");
        f.put('3',"def");
        f.put('4',"ghi");
        f.put('5',"jkl");
        f.put('6',"mno");
        f.put('7',"pqrs");
        f.put('8',"tuv");
        f.put('9',"wxyz");

        List<String>res = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");
        createCombination(digits,digits.length(),0,sb,res);
        return res;
    }
    static void createCombination(String s,int n , int idx,StringBuilder diary , List<String>res){
        if(idx==n){
            res.add(diary.toString());
            return;
        }
        String choice = f.get(s.charAt(idx));

        //all choice
        for(int j=0;j<choice.length();j++){
            diary.append(choice.charAt(j));
            createCombination(s,n,idx+1,diary,res);
            diary.deleteCharAt(diary.length()-1);
        }
        return;

    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<String> temp = new ArrayList<>();

//        generateSubsets(arr, arr.length, 0, temp);
//        StringBuilder sb = new StringBuilder();
//        generateParentheses(0,0,3,sb);

//        doorChoice(arr.length,arr ,0,temp);
        String digits = "223"; // test input
        List<String> result = letterCombinations(digits);

        System.out.println(result);
    }
}
