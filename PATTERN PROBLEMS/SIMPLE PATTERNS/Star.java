public class Star {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {         // Outer loop for rows
            for (int j = 1; j <= i; j++) {     // Inner loop for printing numbers
                System.out.print("*");           // Print the current row number
            }
            System.out.println();              // Move to the next line
        }
    }
}
