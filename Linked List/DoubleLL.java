public class DoubleLL {
    public  class Node {
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data = data ;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;


    //addFirst
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if(head==null){
            head = tail = newNode;
            return;
        }
        newNode.next=head;
        head.prev= newNode;
        head = newNode;
    }
    //print
    public void print(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.print("mull");
        System.out.println();
    }
    //remove first
    public int removeFirst(){
        if(head==null){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = head.data;
            head=tail=null;
           size--;
           return val;
        }
        int val = head.data;
        head = head.next;
        head.prev=null;
        size--;
        return val;
    }
    //addLast
    public void addLast(int data){
        Node newNode= new Node(data);
        size++;
        if(size==0){
            head=tail = newNode;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    //removeLast
    public int removeLast(){
        if(head==null){
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        }
        if(size == 1){
            int val = tail.data;
            head=tail=null;
            size--;
            return val;
        }
       int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }
    public void reverse(){
        Node curr= tail = head;
        Node Prev = null;
        Node Next ;
        while(curr!=null){
            Next = curr.next;
            curr.next= Prev;
            curr.prev=Next;
            Prev=curr;
            curr=Next;

        }
        head=Prev;

    }

    public static void main(String[] args) {
        DoubleLL ll = new DoubleLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);

        ll.print(); // 3<->2<->1<->null

        ll.reverse();
//        ll.removeLast();
        ll.print();
    }


}
