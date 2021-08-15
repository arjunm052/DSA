//Without DP complexity is O(n!)
// With dp complexity reduces to O(2^n * n)

import java.util.*;

public class tsp {

    static int VISITED_ALL;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of cities: ");
        int n = sc.nextInt();
        System.out.println("Enter the distance matrix: ");
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = sc.nextInt();
            }
        }
        sc.close();
        initialize(n);
        System.out.println(tspSolve(dist, 1, 0, n));
    }

    public static int tspSolve(int[][] dist, int mask, int pos, int n) {
        if (mask == VISITED_ALL) {
            return dist[pos][0];
        }

        if (dp[mask][pos] != -1) {
            return dp[mask][pos];
        }

        int ans = Integer.MAX_VALUE;

        for (int city = 0; city < n; city++) {
            if ((mask & (1 << city)) == 0) {
                int newAns = dist[pos][city] + tspSolve(dist, mask | (1 << city), city, n);
                ans = Math.min(newAns, ans);
            }
        }
        return dp[mask][pos] = ans;
    }

    public static void initialize(int n) {
        VISITED_ALL = (1 << n) - 1;
        dp = new int[(1 << n)][n];

        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
    }
}