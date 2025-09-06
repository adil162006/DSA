import java.util.LinkedList;
import java.util.Queue;

public class Interleave {
    public static void interleave(Queue<Integer> q ){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size()/2;
        for (int i = 0; i <size ; i++) {
            firstHalf.add(q.remove());
        }
        while(!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }

    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= 8; i++) {
            q.add(i);
        }

        System.out.println("Original queue: " + q);
        interleave(q);
        System.out.println("Interleaved queue: " + q);
    }
}
