import java.util.*;

public class triangles {
    public static void main(String[] args) {
        int[] arr = { 4, 6, 3, 7 };
        System.out.println(count(arr));
    }

    public static int count(int[] arr) {
        Arrays.sort(arr);
        int res = 0;
        for (int i = arr.length - 1; i >= 1; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (arr[i] < arr[l] + arr[r]) {
                    res += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }

        return res;
    }
}
