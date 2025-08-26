public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head and Tail should belong to LinkedList, not Node
    public static Node head;
    public static Node tail;
    public static int size = 0;

    // Insert at beginning
    public void insert_at_beggining(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }
    public void insert_at_end(int data){
        Node newNode = new Node(data);
        size++;

        if (head==null){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
         tail=newNode;

    }
    //insert at index
    public void add(int idx , int data){

        if(idx==0){
            insert_at_beggining(data);
            return;
        }
        Node newNode =  new Node(data);
        size++;
        int i =0;
        Node temp =head;
        while(i<idx-1){
            temp = temp.next;
            i++;

        }
        // If index is out of range
        if (temp == null) {
            System.out.println("Index out of bounds!");
            return;
        }

        newNode.next=temp.next;
        temp.next = newNode;
        // Update tail if inserted at end
        if (newNode.next == null) {
            tail = newNode;
        }
    }
    // Print function to see the list
    public void printList() {
        if(head==null){
            System.out.println("LinkedList is Empty");
            return;
        }
        Node temp = head;

        while(temp!=null){
            System.out.print(temp.data + "=>");
            temp = temp.next;

        }
        System.out.print("null");
        System.out.println();
    }
    //delete at beggining

    public int removeFirst(){
        if(head==null){
            System.out.println("Linked List is Empty");
            return 0;
        }
        int val = head.data;
        head = head.next;
        size--;
        if (head == null) {
            tail = null; // reset tail also
        }
        return val;
    }
    //delete at last
    public int removeLast(){
        if(size==0){
            System.out.println("Linked List is Empty");
            return Integer.MIN_VALUE;
        } else if (size==1) {
            int val =head.data;
            head = tail = null;
            return val;
        }
        Node prev = head;
        for (int i = 0; i <size-2 ; i++) {
            prev= prev.next;

        }
        int val = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }
    public int itrSearch(int key){
        int i = 0;
        Node temp=head;
        while(temp!=null){
            if(temp.data==key){
                System.out.println("found at index " + i);
                return i;
            }
            temp = temp.next;
            i++;

        }
        System.out.println("not found");
        return -1;
    }
    public void reverse(){
        Node prev=null;
        Node curr = tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        head = prev;

    }
    public void deleteNthfromEnd(int n){
        int sz=0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            sz++;
        }
        if(n==sz){
            head = head.next;
            return;
        }
        //sz-n+1

        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while(i<iToFind){
            prev = prev.next;
            i++;

        }
        prev.next = prev.next.next;
    }
    public Node findMid(Node head){
        Node fast = head;
        Node slow=head;
        while (fast.next != null && fast.next.next != null) {
            slow=slow.next;
            fast = fast.next.next;
        }
        return slow;//slow is my mid node
    }
    public boolean checkPallindrome(){
        if(head==null||head.next==null){
            return true;
        }
        //step1 find mid
        Node midNode =  findMid(head);
        //step 2 reverse

        Node prev=null;
        Node curr = midNode;
        Node next;

        while (curr!=null){
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }

        Node right = prev;
        Node left = head;

        while(right!=null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public static boolean  isCycle(){ //floyds cycle finding algorithm
        Node slow= head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void  removeCycle(){
        Node slow = head;
       Node fast = head;
       boolean cycle = false;
       while(fast!=null && fast.next!=null){
           slow = slow.next;
           fast = fast.next.next;
           if(slow == fast){
               cycle=true;
               break;
           }
       }
        if (!cycle) {
            return; // No cycle
       }
        slow=head;
        Node prev= null;
        while(slow!=fast){
            prev=fast;
           slow=slow.next;
           fast=fast.next;
       }
        prev.next=null;

    }

    private Node getMid(Node head){
        Node slow = head;
        Node fast=head.next;


        return slow;
    }
    private Node merge(Node head1 , Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while(head1 != null && head2!=null) {
            if(head1.data<= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;

            }
        }
        while ( head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while ( head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;


    }
    public Node mergeSort (Node head){
        if(head == null || head.next ==null){
            return head;
        }
        //find mid
        Node mid = getMid(head);
        // left & right
        Node rightHead = mid.next;
        mid.next=null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);
        //merge
        return merge(newLeft,newRight);

    }
    public void zigZag(){
        //find mid
        Node slow = head;
        Node fast =  head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast=fast.next.next;

        }
        Node mid  = slow;


        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while(curr!= null){
            next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;

        }
        Node left = head;
        Node right = prev;
        Node nextRight,nextLeft;
        //alt merge -zig-Zag merge
        while(left!=null && right!=null){
            nextLeft = left.next;
            left.next = right;
            nextRight = right.next;
            right.next = nextLeft;
            left=nextLeft;
            right = nextRight;
        }
    }



    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
//        ll.printList();
//        ll.insert_at_beggining(10);
//        ll.insert_at_beggining(20);
//        ll.insert_at_beggining(30);
//        ll.insert_at_end(4);
//        ll.insert_at_end(43);
//        ll.printList();
//
//        ll.add(2,12);
//        ll.printList();
//        ll.removeFirst();
//        ll.printList();
//        System.out.println(ll.size);
//        ll.removeLast();
//        ll.printList();
//        System.out.println(ll.size);
//        ll.itrSearch(12);
//        ll.reverse();
//        ll.printList();
        ll.insert_at_end(1);
        ll.insert_at_end(2);
        ll.insert_at_end(3);
        ll.insert_at_end(2);
        ll.insert_at_end(6);

        ll.printList();

        ll.zigZag();
        ll.printList();
//        System.out.println(ll.checkPallindrome());
//        head = new Node(1);
//        Node temp = new Node(2);
//        head.next = temp;
//        head.next.next = new Node(3);
//        head.next.next.next= temp;
//        System.out.println(isCycle());
//        removeCycle();
//        System.out.println(isCycle());
    }
}
