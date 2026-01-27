import java.util.*;
class HeapADT{
    ArrayList<Integer> arr = new ArrayList<>();
    public void add (int data){
        arr.add(data);
        int x = arr.size()-1;
        int par = (x-1)/2;
        while(arr.get(x)<arr.get(par)){
            int temp = arr.get(x);
            arr.set(x,arr.get(par));
            arr.set(par,temp);
            x=par;
            par = (x-1)/2;
        }
    }
    public int peek(){
        return arr.get(0);
    }
    public void heapify(int i){
        int left = 2*i + 1;
        int right = 2*i + 2;

        int minIdx =i;
        if(left<arr.size() && arr.get(minIdx)>arr.get(left)){
            minIdx=left;
        }if(right<arr.size() && arr.get(minIdx)>arr.get(right)){
            minIdx=right;
        }
        if(minIdx!=i){
            //swap
            int temp = arr.get(i);
            arr.set(i,arr.get(minIdx));
            arr.set(minIdx,temp);
            heapify(minIdx);
        }
    }
    public int remove(){
        int data = arr.get(0);
        //swap first and last
        int temp = arr.get(0);
        arr.set(0,arr.get(arr.size()-1));
        arr.set(arr.size()-1,temp);

        arr.remove(arr.size() - 1);
        heapify(0);
        return data;
    }
}

public class Main2 {
    public static void main(String[] args) {
        HeapADT heap = new HeapADT();

        // Insert elements
        heap.add(5);
        heap.add(20);
        heap.add(10);
        heap.add(40);
        heap.add(50);
        heap.add(30);

        // Peek (minimum)
        System.out.println("Peek (min): " + heap.peek()); // 5

        // Remove elements one by one
        System.out.println("Removed: " + heap.remove()); // 5
        System.out.println("Removed: " + heap.remove()); // 10
        System.out.println("Removed: " + heap.remove()); // 20
        System.out.println("Removed: " + heap.remove()); // 30
        System.out.println("Removed: " + heap.remove()); // 40
        System.out.println("Removed: " + heap.remove()); // 50
    }
}
