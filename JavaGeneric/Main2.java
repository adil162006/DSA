import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<?> list =  new ArrayList<String>();

    }
    public <T> void printAarrayList(ArrayList<T> list){
        for(T o : list){
            System.out.println(0);
        }
    }
    public <T> void copy(ArrayList<T> source , ArrayList<T> destination){
        for(T item : source){
            destination.add(item);
        }
    }
    public static double sum(ArrayList<? extends Number> numbers){
        double sum = 0;
        for( Number o : numbers){
            sum+=o.doubleValue();
        }
        return sum;
     }
}
