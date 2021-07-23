import java.util.*;

public class toh {
    public static void main(String[] args) {
        int n=3;
        towerOfHanoi(n,"Start","Dest","Auxilary");
    }

    public static void towerOfHanoi(int n,String start,String dest,String aux) {
        if(n==1){
            System.out.println("Move disk " + n + " from " + start + " to " + dest);
            return;
        }
        towerOfHanoi(n-1, start, aux, dest);
        System.out.println("Move disk " + n + " from " + start + " to " + dest);
        towerOfHanoi(n-1, aux, dest, start);
    }
}
