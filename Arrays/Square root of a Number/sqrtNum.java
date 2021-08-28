import java.util.*;

public class sqrtNum {
    public static void main(String[] args) {
        int n = 25;
        System.out.println(solve(n));
    }

    public static int solve(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2 || n == 3) {
            return 1;
        }
        int res = -1;
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midSq = mid * mid;

            if (midSq == n) {
                return mid;
            } else if (midSq > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
                res = mid;
            }
        }

        return res;
    }
}
