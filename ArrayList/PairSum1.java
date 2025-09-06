import java.util.ArrayList;

public class PairSum1 {
    public static boolean sum(ArrayList<Integer> list,int target){
        int lp=0;
        int rp = list.size();
        while(lp!=rp){
            if(list.get(lp)+ list.get(rp)==target){
                return true;
            }
            if(list.get(lp)+ list.get(rp)<target){
                lp++;
            }else{
                rp++;
            }
        }
        return false;
    }
}
