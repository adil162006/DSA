public class HalfPyramid {
    public static void pyramid(int n){
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= n-i ; j++) {
                System.out.print(" ");

            }
            for (int j = 1; j <=i ; j++) {
                System.out.print("*");
            }
//            for (int j = 2; j <=i ; j++) {
//                System.out.print("*");
//            }
            System.out.println();
        }
    }
    public static void inverted_half_pyramid_number(int n){
        for (int i = n; i >=1 ; i--) {
            for (int j = 1; j <=i ; j++) {
                System.out.print(j);

            }
            System.out.println();

        }
    }
    public static void zero_one(int n){
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=i ; j++) {
                if ((i + j) % 2 == 0) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
//        pyramid(4);
        inverted_half_pyramid_number(4);
        zero_one(6);
    }
}
