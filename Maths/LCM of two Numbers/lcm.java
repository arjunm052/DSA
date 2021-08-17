import java.util.*;

public class lcm {
    public static void main(String[] args) {
        int n1 = 5, n2 = 6;
        System.out.println(lcmOptimized(n1, n2));
    }

    public static int lcmNaive(int a, int b) {
        int res = Math.max(a, b);
        while (true) {
            if (res % a == 0 && res % b == 0) {
                return res;
            }
            res++;
        }
    }

    public static int lcmOptimized(int a, int b) {
        return ((a * b) / euclidOptimized(a, b));
    }

    public static int euclidOptimized(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return euclidOptimized(b, a % b);
        }
    }
}
