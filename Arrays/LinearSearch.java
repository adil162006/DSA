public class LinearSearch {
    public static int search(int[] arr,int key){
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]==key){
                return i ;
            }


        }
        return -1;
    }
    public static void main(String[] args) {
        int [] numbers = {1,2,3,4,10,33};
        int key = 10;
        int index = search(numbers,key);
        if (index == -1){
            System.out.println("value not found");
        }
        else {
            System.out.println(index);
        }
    }
}
