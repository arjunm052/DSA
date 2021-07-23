import java.util.*;

public class sort {
    public static void main(String[] args) {
        int[] arr =  {13, 7, 6, 45, 21, 9, 2, 100};
        Stack<Integer> st = new Stack<>();
        for(int x: arr){
            st.push(x);
        }
        recsort(st);
        System.out.println(st);
    }

    private static void recsort(Stack<Integer> st) {
        if(st.size()==1){
            return;
        }

        int temp = st.pop();
        recsort(st);
        insert(st,temp);
    }

    private static void insert(Stack<Integer> st, int temp) {
        if(st.size()==0 || st.peek()<=temp){
            st.push(temp);
            return;
        } 

        int val = st.pop();
        insert(st,temp);
        st.push(val);
    }
}
