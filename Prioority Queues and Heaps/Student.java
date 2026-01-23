import java.util.*;

public class Student implements Comparable<Student> {
    String name;
    int rank;

    public Student(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    @Override
    public int compareTo(Student s2) {
        return this.rank - s2.rank; // smaller rank = higher priority
    }

    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();

        pq.add(new Student("Alice", 3));
        pq.add(new Student("Bob", 1));
        pq.add(new Student("Charlie", 2));

        while (!pq.isEmpty()) {
            Student s = pq.poll();
            System.out.println(s.name + " - Rank: " + s.rank);
        }
    }
}
