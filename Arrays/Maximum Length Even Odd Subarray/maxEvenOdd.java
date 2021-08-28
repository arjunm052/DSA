import java.util.*;

public class maxEvenOdd {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 7, 9 };
        System.out.println(longest(arr));
    }

    public static int longest(int[] arr) {
        int res = 1;
        int curr = 1;
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0) || (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0)) {
                curr++;
                res = Math.max(res, curr);
            } else {
                curr = 1;
            }
        }

        return res;
    }
}
