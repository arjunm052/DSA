import java.util.*;

public class countDis {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
        int k = 4;
        System.out.println(countDistinct(arr, k));
        ;
    }

    public static ArrayList<Integer> countDistinct(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k - 1; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (int j = 0, i = k - 1; i < arr.length; i++, j++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            res.add(map.size());

            int freq = map.get(arr[j]);
            if (freq == 1) {
                map.remove(arr[j]);
            } else {
                map.put(arr[j], map.get(arr[j]) - 1);
            }
        }

        return res;
    }
}
