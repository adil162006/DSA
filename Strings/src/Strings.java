import java.util.Scanner;

public class Strings {
    static void print (String str){
        for (int i = 0 ;  i<str.length(); i++){
            System.out.println(str.charAt(i));
        }
    }
    public static void main(String[] args) {
        char[] arr = {'a','b','c','d'};
         String str = "abcd";
         String str2 = new String("xyz");
//        Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine();
//        System.out.println(input);
//        System.out.println(input.length());
        String firstName= "Adil";
        String lastName = "Ghazi";
        String FullName = firstName+ " " + lastName;
        System.out.println(FullName);
        System.out.println(FullName.charAt(5));
        print(FullName);
    }
}
