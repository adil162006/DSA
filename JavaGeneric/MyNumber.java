public class MyNumber extends Number implements Printable{
    private final int value;

    MyNumber(int value){
        this.value=value;
    }

    @Override
    public void print() {
        System.out.println("Number : " + value);
    }

    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}

class Boxx < T extends Number & Printable>{
    private T value;

    public Boxx(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}