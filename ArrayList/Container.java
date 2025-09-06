import java.util.ArrayList;

public class Container {
    public static int mostWater(ArrayList<Integer>heights){
        int maxWater=0;
        int lp=0;
        int rp = heights.size()-1;
        while(lp<rp){
            int ht = Math.min(heights.get(lp),heights.get(rp));
            int width=rp-lp;
            int currWater= ht*width;
            maxWater=Math.max(currWater,maxWater);
            if(heights.get(lp)<heights.get(rp)){
                lp++;
            }else {
                rp--;
            }
        }

        return maxWater;
    }
}
