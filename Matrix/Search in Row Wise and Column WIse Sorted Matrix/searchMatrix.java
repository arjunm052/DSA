import java.util.*;

public class searchMatrix {
    public static void main(String[] args) {
        int arr[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
        int target = 29;
        search(arr, target);

    }

    public static void search(int[][] arr, int key) {
        int n = arr.length, m = arr[0].length;
        int i = 0, j = arr[0].length - 1;
        while (i >= 0 && i < n && j >= 0 && j < m) {
            if (arr[i][j] == key) {
                System.out.println(i + " " + j);
                return;
            } else if (arr[i][j] > key) {
                j--;
            } else if (arr[i][j] < key) {
                i++;
            }
        }

        System.out.println(-1);
    }
}
