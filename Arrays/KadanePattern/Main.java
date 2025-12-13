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
    public int maximumSum(int[] arr) {
        int nodelete = arr[0];
        int onedelete = Integer.MIN_VALUE;
        int result = arr[0];
        for (int i=1;i<arr.length;i++){
            int prevnodelete = nodelete;
            int prevonedelete =onedelete;
            nodelete = Math.max(arr[i],nodelete+arr[i]);
            int v2;
            if(prevonedelete== Integer.MIN_VALUE){
                v2 = arr[i];
            }else{
                v2 = prevonedelete+arr[i];
            }
            onedelete = Math.max(v2,prevnodelete);
            result = Math.max(result,Math.max(onedelete,nodelete));
        }
        return result;
    }
    public int maxSubarraySumCircular(int[] arr) {
        int sum=0;
        for (int i =0;i<arr.length;i++){
            sum+=arr[i];
        }

        int maxres=arr[0];
        int minres=arr[0];
        int maxbest=arr[0];
        int minbest=arr[0];
        for(int i=1;i<arr.length;i++){
            maxbest = Math.max(arr[i],arr[i]+maxbest);
            minbest = Math.min(arr[i],arr[i]+minbest);
            minres = Math.min(minres,minbest);
            maxres = Math.max(maxres,maxbest);
        }
        if(maxres<0) return maxres;
        int CircularSum = sum-minres;

        return Math.max(CircularSum,maxres);
    }
    public static void main(String[] args) {

    }
}
