package assignment;

import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
        int n=2;
        int m =3;
        int[][] matrix = new int[n][m];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements");
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                matrix[i][j] = sc.nextInt();
            }

        }
        System.out.println("The Matrix is ");
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <m ; j++) {
                System.out.print(matrix[i][j] + " ") ;
            }
            System.out.println();

        }
        int[][] transpose = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        System.out.println("The Transpose Matrix is ");
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(transpose[i][j] + " ") ;
            }
            System.out.println();

        }
    }
}
