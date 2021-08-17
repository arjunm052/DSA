import java.util.*;

public class hcf {
    public static void main(String[] args) {
        int n1 = 10, n2 = 15;
        System.out.println(euclidOptimized(n1, n2));
    }

    public static int gcdNaive(int a, int b) {
        int res = Math.min(a, b);
        while (res > 0) {
            if (a % res == 0 && b % res == 0) {
                break;
            }
            res--;
        }
        return res;
    }

    public static int euclid(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static int euclidOptimized(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return euclidOptimized(b, a % b);
        }
    }
}
