import java.util.*;

public class nge {
    public static void main(String[] args) {
        int[] arr = { 2, 7, 3, 5, 4, 6, 8 };
        System.out.println(Arrays.toString(nextGreatRight(arr)));
    }

    public static int[] nextGreatRight(int[] arr) {
        int[] res = new int[arr.length];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }
        return res;
    }

    public static int[] nextSmallerRight(int[] arr) {
        int[] res = new int[arr.length];
        Arrays.fill(res, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                res[st.pop()] = arr[i];
            }
            st.push(i);
        }
        return res;
    }
}