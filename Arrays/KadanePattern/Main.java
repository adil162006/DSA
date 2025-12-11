public class Main {

        int maxSum(int[] arr){
            int res = arr[0];
            int bestend = arr[0];
            for(int i =1; i<arr.length;i++){
                bestend = Math.max(bestend+arr[i],arr[i]);
                res=Math.max(res,bestend);
            }
            return res;
        }
        int minSum(int[] arr){
            int res = arr[0];
            int bestend = arr[0];
            for(int i =1; i<arr.length;i++){
                bestend = Math.min(bestend+arr[i],arr[i]);
                res=Math.min(res,bestend);
            }
            return res;
        }
        public int maxAbsoluteSum(int[] arr) {
            int maxsum = Math.abs(maxSum(arr));
            int minsum = Math.abs(minSum(arr));

            return Math.max(maxsum,minsum);
        }

        public int maxProduct(int[] arr){
            int res = arr[0];
            int maxending = arr[0];
            int minending = arr[0];

            for(int i =1;i<arr.length;i++){
                int v1=arr[0];
                int v2 = maxending*arr[i];
                int v3= minending*arr[i];
                maxending=Math.max(v1,Math.max(v3,v2));
                maxending=Math.max(v1,Math.max(v3,v2));
                minending=Math.min(v1,Math.min(v3,v2));
                res = Math.max(res,Math.max(maxending,minending));
            }



            return res;
        }

    public static void main(String[] args) {

    }
}
