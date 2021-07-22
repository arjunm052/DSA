import java.util.*;

public class reverse {
    public static void main(String[] args) {
        int[] arr =  {6,5,4,3,2,1};
        Stack<Integer> st = new Stack<>();
        for(int x: arr){
            st.push(x);
        }
        reverseS(st);
        System.out.println(st);
    }

    public static void reverseS(Stack<Integer> st) {
        if(st.size()==1){
            return;
        }

        int temp = st.pop();
        reverseS(st);
        insert(st,temp);
    }

    public static void insert(Stack<Integer> st,int temp) {
        if(st.size()==0){
            st.push(temp);
            return;
        }

        int val = st.pop();
        insert(st,temp);
        st.push(val);
    }
}
