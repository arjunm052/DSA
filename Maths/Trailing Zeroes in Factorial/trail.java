import java.util.*;

public class trail {
    public static void main(String[] args) {
        int n = 251;
        System.out.println(countZeros(n));
    }

    public static int trailingNaive(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }

        int res = 0;
        while (fact % 10 == 0) {
            res++;
            fact = fact / 10;
        }
        return res;
    }

    // O(log5 n)
    public static int countZeros(int n) {
        int res = 0;
        for (int i = 5; i <= n; i = i * 5) {
            res = res + n / i;
        }

        return res;
    }

}
