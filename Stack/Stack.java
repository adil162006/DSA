public class Stack<T> {
    T[] arr;
    int capacity;
    int top;
    Stack(int capacity){
        this.capacity=capacity;
        top =-1;
        arr = (T[]) new Object[capacity];
    }
    public void push(T data){
        if(isFull()){
            throw new RuntimeException("Stack overflow");
        }
        arr[++top] = data;
    }
    public T pop(){
        if(isEmpty()){
            throw  new RuntimeException(("Stack Underflow"));
        }
        return arr[top--];

    }
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("Stack underflow");
        }
        return arr[top];
    }


    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==capacity-1;
    }
}
