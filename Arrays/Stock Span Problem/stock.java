import java.util.*;

public class stock {
    public static void main(String[] args) {
        int price[] = { 100, 80, 60, 70, 60, 75, 85 };
        System.out.println(Arrays.toString(calculateSpan(price)));
    }

    static int[] calculateSpan(int arr[]) {
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (st.size() == 0) {
                res[k++] = 0;
            } else if (st.size() > 0 && arr[st.peek()] > arr[i]) {
                res[k++] = i - st.peek();
            } else if (st.size() > 0 && arr[st.peek()] <= arr[i]) {
                while (st.size() > 0 && arr[st.peek()] <= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0) {
                    res[k++] = i + 1;
                } else {
                    res[k++] = i - st.peek();
                }
            }
            st.push(i);
        }
        res[0] = 1;
        return res;
    }

}
