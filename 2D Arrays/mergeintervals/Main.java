import java.util.ArrayList;
import java.util.List;
import java.util.*;
class Main{
    public int minMeetingRooms(int[] start, int[] end) {
        // code here
        Arrays.sort(start);
        Arrays.sort(end);
        int n = start.length;
        int i=0;
        int j=0;
        int room=0;
        int res=0;
        while(i<n && j<n){
            if(start[i]<end[j]){
                room++;
                res = Math.max(res,room);
                i++;
            }else{
                room--;
                j++;
            }            
        }
        return res;
    }
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i=0;
        int j=0;
        int n = firstList.length;
        int m = secondList.length;

        List<int[]>res = new ArrayList<>();

        while(i<n && j<m){
            int start1=firstList[i][0];
            int end1=firstList[i][1];
            int start2=secondList[j][0];
            int end2=secondList[j][1];
            if(start1<=start2){
                if(end1>=start2){
                    int s = Math.max(start1,start2);
                    int e = Math.min(end1,end2);
                    res.add(new int[]{s,e});
                }
            }else{
                if(end2>=start1){
                    int s = Math.max(start1,start2);
                    int e = Math.min(end1,end2);
                    res.add(new int[]{s,e});
                }
            }
            if(end1<=end2){
                i++;
            }else{
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    public static void main(String[] args) {
        
    }
}