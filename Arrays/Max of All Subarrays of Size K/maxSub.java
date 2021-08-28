import java.util.*;

public class maxSub {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int k = 3;
        System.out.println(maxSubA(arr, k));
    }

    public static ArrayList<Integer> maxSubA(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<Integer> wf = new ArrayList<>();

        int i = 0, j = 0;
        for (j = 0; j < k; j++) {
            wf.add(arr[j]);
        }
        res.add(Collections.max(wf));

        for (j = k; j < arr.length; j++) {
            wf.add(arr[j]);
            wf.remove(0);
            res.add(Collections.max(wf));
        }

        return res;
    }
}
