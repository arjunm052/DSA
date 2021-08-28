import java.util.*;

public class transpose {
    public static void main(String[] args) {
        int arr[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
        transpose(arr);
        printMatrix(arr);
    }

    public static void transpose(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr[i].length; j++) {
                swap(arr, i, j, j, i);
            }
        }
    }

    public static void swap(int[][] arr, int i, int j, int k, int l) {
        int temp = arr[i][j];
        arr[i][j] = arr[k][l];
        arr[k][l] = temp;
    }

    static void printMatrix(int arr[][]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }
}
