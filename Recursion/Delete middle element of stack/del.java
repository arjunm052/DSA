import java.util.*;

public class del {
    public static void main(String[] args) {
        int[] arr =  {1,2,3,4,5,6};
        Stack<Integer> st = new Stack<>();
        for(int x: arr){
            st.push(x);
        }
        int middle = (st.size()/2)+1;
        deleteMiddle(st,st.size()-middle+1);
        System.out.println(st);
    }

    public static void deleteMiddle(Stack<Integer> st, int k) {
        if(k==1){
            st.pop();
            return;
        }

        int temp = st.pop();
        deleteMiddle(st, k-1);
        st.push(temp);

        return;
    }
}
