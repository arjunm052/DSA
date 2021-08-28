import java.util.*;

public class rotate {
    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        clockwise(arr);
        printMatrix(arr);

    }

    static void printMatrix(int arr[][]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(arr[i][j] + " ");
            System.out.println();
        }
    }

    public static void antiClockwise(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr[i].length; j++) {
                swap(arr, i, j, j, i);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int low = 0, high = arr[i].length - 1;
            while (low < high) {
                swap(arr, low, i, high, i);
                low++;
                high--;
            }
        }
    }

    static void clockwise(int[][] arr) {

        int n = arr.length;

        // first rotation
        // with respect to main diagonal
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                swap(arr, i, j, j, i);
            }
        }
        // Second rotation
        // with respect to middle column
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n / 2; ++j) {
                swap(arr, i, j, i, n - j - 1);
            }
        }

    }

    public static void swap(int[][] arr, int i, int j, int k, int l) {
        int temp = arr[i][j];
        arr[i][j] = arr[k][l];
        arr[k][l] = temp;
    }
}