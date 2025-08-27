public class Stock {
    public static int sellStock(int[] prices){
        int maxProfit = 0;
        int bp = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length ; i++) {
            int profit = 0;
            if(bp<prices[i]){
                profit = prices[i] - bp;
               maxProfit= Math.max(profit,maxProfit);
            }
            else{
                bp=prices[i];
            }
        }



        return maxProfit;
    }
    public static void main(String[] args) {
        int[] arr = {1,5,6,4,7};
        System.out.println(sellStock(arr));
    }
}
