import java.util.ArrayList;

public class MultiDimensional {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list  = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);
        mainList.add(list);
        ArrayList<Integer> list2= new ArrayList<>();
        list2.add(5); list2.add(6);list2.add(7);list2.add(9);
        mainList.add(list2);
        System.out.println(mainList);
        for (int i = 0; i < mainList.size() ; i++) {
            ArrayList<Integer> curr = mainList.get(i);
            for (int j = 0; j < curr.size() ; j++) {
                System.out.print(curr.get(j)+" ");
            }
            System.out.println();
        }
        ArrayList<ArrayList<Integer>> mainList2 = new ArrayList<>();

        ArrayList<Integer> sublist1  = new ArrayList<>();
        ArrayList<Integer> sublist2  = new ArrayList<>();
        ArrayList<Integer> sublist3  = new ArrayList<>();
        for (int i = 1; i <=5 ; i++) {
            sublist1.add(i*1);
            sublist2.add(i*2);
            sublist3.add(i*3);
        }
        mainList2.add(sublist1);
        mainList2.add(sublist2);
        mainList2.add(sublist3);
        System.out.println(mainList2);
    }
}
