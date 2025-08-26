import java.util.ArrayList;
import java.util.Collections;

public class Test {
    static void swap (ArrayList<Integer> list , int idx1,int idx2){
        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2,temp);
    }
    public static void main(String[] args) {
        ArrayList<Integer> list =  new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        System.out.println(list.get(2));
        System.out.println(list.remove(1));
        System.out.println(list);
        list.set(2,18);
        System.out.println(list);
        System.out.println(list.contains(11));
        System.out.println(list.contains(18));
//        for (int i = list.size()-1; i >=0 ; i++) {
//            System.out.println(list.get(i));
//        }
        Collections.sort(list);
        Collections.sort(list, Collections.reverseOrder());

    }
}
