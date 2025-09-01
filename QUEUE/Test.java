class Node{
    int data;
    int rear;
    Node next;
    Node(int data){
        this.data=data;
        this.next = null;
    }
}
public class Test {
    static Node head;
    static Node tail;
    public static boolean isEmpty(){return head==null;}
    public static void add(int data){
        Node newNode = new Node(data);
        if(isEmpty()) {head = newNode; return;}
        if(head==null){
            head = tail = newNode;
        }
        tail.next = newNode;
        tail= newNode;

    }
    public static int pop(){
        if(isEmpty())return -1;
        int front = head.data;
        if(head==tail){
            tail=head=null;
        }else {
            head = head.next;
        }
        return front;
    }
    public static int peek(){
        if(isEmpty()) return -1;
        return head.data;

    }

}
