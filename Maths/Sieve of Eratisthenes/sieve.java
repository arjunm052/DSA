import java.util.Arrays;

public class sieve {
    public static void main(String[] args) {
        int n = 100;
        sieveOf(n);
    }

    public static void sieveOf(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                System.out.print(i + " ");
                for (int j = i * i; j <= n; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }
        System.out.println();
    }
}
