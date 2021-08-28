import java.util.*;

public class majority {
    public static void main(String[] args) {
        int[] arr = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
        System.out.println(majorityEle(arr));
    }

    public static int majorityEle(int[] arr) {
        int res = 0, count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[res] == arr[i]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                res = i;
                count = 1;
            }
        }
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[res] == arr[i]) {
                count++;
            }
        }
        if (count <= arr.length / 2) {
            res = -1;
        }
        return res;
    }
}
