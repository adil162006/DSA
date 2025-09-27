// Node class
class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList ADT with head and tail
class LinkedList1<T> {
    private Node<T> head;
    private Node<T> tail; // extra pointer to last node

    public LinkedList1() {
        head = null;
        tail = null;
    }

    // Insert at the beginning
    public void insertAtHead(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) { // empty list
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // Insert at the end (O(1) now!)
    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) { // empty list
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; // link last node
            tail = newNode;      // move tail
        }
    }

    // Delete first occurrence of a value
    public void delete(T key) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }

        // If head is the node to delete
        if (head.data.equals(key)) {
            head = head.next;
            if (head == null) { // if list became empty
                tail = null;
            }
            return;
        }

        Node<T> temp = head;
        while (temp.next != null && !temp.next.data.equals(key)) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Element not found!");
        } else {
            // If deleting the tail
            if (temp.next == tail) {
                tail = temp;
            }
            temp.next = temp.next.next;
        }
    }

    // Search for a value
    public boolean search(T key) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(key)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Display the list
    public void display() {
        Node<T> temp = head;
        if (temp == null) {
            System.out.println("List is empty!");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

// Test class
public class LinkedListADT {
    public static void main(String[] args) {
        LinkedList1<Integer> list = new LinkedList1<>();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtHead(5);
        list.insertAtEnd(30);

        list.display(); // 5 -> 10 -> 20 -> 30 -> null

        list.delete(20);
        list.display(); // 5 -> 10 -> 30 -> null

        list.delete(30);
        list.display(); // 5 -> 10 -> null  (tail updated!)

        System.out.println("Search 10: " + list.search(10)); // true
        System.out.println("Search 50: " + list.search(50)); // false
    }
}
