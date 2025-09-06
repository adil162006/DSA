import java.util.ArrayList;

public class Pairsum2 {
    public static boolean sum(ArrayList<Integer> list,int target){
        int bp=-1;
        int n= list.size();
        for (int i = 0; i < n; i++) {
            if(list.get(i)> list.get(i+1)){
                bp=i;
                break;
            }
        }
        int rp=bp;
        int lp=bp+1;
        while(lp!=rp){
            if (list.get(rp)+ list.get(lp)==target){
                return true;
            }
            if(list.get(rp)+ list.get(lp)<target){
                lp=(lp+1)%n;
            }else{
                rp=(n+rp-1)%n;

            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        int target =16;
        System.out.println(sum(list,target));
    }
}
