import java.util.*;

public class zeroSum {
    public static void main(String[] args) {
        int[] arr = { -3, 2, 3, 1, 6 };
        System.out.println(exists(arr));
    }

    public static boolean exists(int[] arr) {
        HashSet<Integer> set = new HashSet<Integer>();
        int sum = 0;
        for (int x : arr) {
            sum += x;
            if (set.contains(sum)) {
                return true;
            }
            if (sum == 0) {
                return true;
            } else {
                set.add(sum);
            }
        }

        return false;
    }
}
