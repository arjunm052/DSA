import java.util.*;

public class longest {
    public static void main(String[] args) {
        int arr[] = { 1, 9, 3, 10, 4, 20, 2 };
        System.out.println(solve(arr));
    }

    public static int solve(int[] arr) {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int x : arr) {
            set.add(x);
        }
        int res = 1;
        for (int x : set) {
            if (set.contains(x - 1) == false) {
                int curr = 1;
                while (set.contains(x + curr)) {
                    curr++;
                }
                res = Math.max(res, curr);
            }
        }

        return res;
    }
}
