import java.util.*;

public class maxArea {
    public static void main(String[] args) {
        int arr[] = { 6, 2, 5, 4, 5, 1, 6 };
        System.out.println(maxA(arr));
    }

    public static int maxA(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int[] nsl = new int[n];
        int[] nsr = new int[n];
        int[] width = new int[n];
        int k = 0;
        int pseudo = -1;

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (st.size() == 0) {
                nsl[k++] = pseudo;
            } else if (st.size() > 0 && arr[st.peek()] < arr[i]) {
                nsl[k++] = st.peek();
            } else if (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0) {
                    nsl[k++] = pseudo;
                } else {
                    nsl[k++] = st.peek();
                }
            }

            st.push(i);

        }

        st.clear();
        pseudo = n;
        k = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (st.size() == 0) {
                nsr[k--] = pseudo;
            } else if (st.size() > 0 && arr[st.peek()] < arr[i]) {
                nsr[k--] = st.peek();
            } else if (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                while (st.size() > 0 && arr[st.peek()] >= arr[i]) {
                    st.pop();
                }
                if (st.size() == 0) {
                    nsr[k--] = pseudo;
                } else {
                    nsr[k--] = st.peek();
                }
            }

            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            width[i] = nsr[i] - nsl[i] - 1;
            max = Math.max(max, arr[i] * width[i]);
        }

        return max;
    }
}
