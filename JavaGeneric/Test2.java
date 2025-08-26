enum Operation {
    ADD, SUBTRACT, MULTIPLY, DIVIDE;

    public <T extends Number> double apply(T a, T b) {
        switch (this) {
            case ADD:
                return a.doubleValue() + b.doubleValue();
            case SUBTRACT:
                return a.doubleValue() - b.doubleValue();
            case MULTIPLY:
                return a.doubleValue() * b.doubleValue();
            case DIVIDE:
                return a.doubleValue() / b.doubleValue();
            default:
                throw new AssertionError("Unknown operation: " + this);
        }
    }
}
public class Test2 {
    public static void main(String[] args) {
    Test2 t = new Test2();
    Integer[] intArray = {1,2,4,5,6};
    t.printArray(intArray);
    t.display(134);
    t.display(134.454);
        double result1 = Operation.ADD.apply(10, 20);
        double result2 = Operation.MULTIPLY.apply(5.5, 4);
        System.out.println(result1);  // Output: 30.0
        System.out.println(result2);
    }

    public <T> void printArray (T[] array){
        for (T element : array){
            System.out.println(element+" ");
        }
        System.out.println();
    }

    public <T> void display (T element){
        System.out.println( " generic "  + element);
    }
    public void display(Integer element){
        System.out.println(" integer "+element);
    }
}
