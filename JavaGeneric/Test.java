public class Test {
    public static void main(String[] args) {
        Box<Integer> box = new Box();
        box.setValue(1);
        int i =  box.getValue();
        System.out.println(i);
        Pair<String , Integer> pair = new Pair<>("Age",56);

        MyNumber myNumber = new MyNumber(12);
        Boxx <MyNumber> boxx = new Boxx<>(myNumber);
    }
}
