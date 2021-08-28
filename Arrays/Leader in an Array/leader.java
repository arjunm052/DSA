import java.util.*;

public class leader {
    public static void main(String[] args) {
        int arr[] = { 16, 17, 4, 3, 5, 2 };
        printLeader(arr);
    }

    public static void printLeader(int[] arr) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int max = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                res.add(0, arr[i]);
                max = arr[i];
            }
        }
        System.out.println(res);
    }
}
