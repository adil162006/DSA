import java.util.*;
public class InbuiltSort {
    static void print(Integer [] arr){
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");

        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] arr = {5, 2, 9, 1, 6};
        Integer[] arr2 = {5, 2, 3, 1, 4};
        Arrays.sort(arr,Collections.reverseOrder() );
        Arrays.sort(arr2,0,3,Collections.reverseOrder());
        print(arr);
        print(arr2);
    }
}
