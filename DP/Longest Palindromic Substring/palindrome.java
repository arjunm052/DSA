//O(N^2) solution using DP

import java.util.*;

public class palindrome {
    public static void main(String[] args) {
        String str = "abccbc";
        System.out.println(countPalind(str));
    }

    public static int countPalind(String str) {
        int count = 0;
        boolean[][] dp = new boolean[str.length()][str.length()];
        for (int gap = 0; gap < str.length(); gap++) {
            for (int i = 0, j = gap; j < dp.length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }

                if (dp[i][j]) {
                    ++count;
                }
            }
        }

        return count;
    }

    public static int LongestPalind(String str) {
        int len = 0;
        boolean[][] dp = new boolean[str.length()][str.length()];
        for (int gap = 0; gap < str.length(); gap++) {
            for (int i = 0, j = gap; j < dp.length; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }

                if (dp[i][j]) {
                    len = gap + 1;
                }
            }
        }

        return len;
    }
}