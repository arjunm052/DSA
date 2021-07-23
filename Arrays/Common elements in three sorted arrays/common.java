import java.util.*;

public class common {
    public static void main(String[] args) {
        int ar1[] = { 1, 5, 10, 20, 40, 80, 80 };
        int ar2[] = { 6, 7, 20, 80, 80, 100 };
        int ar3[] = { 3, 4, 15, 20, 30, 70, 80, 80, 120 };
        System.out.println(printCommon(ar1, ar2, ar3));
    }

    public static ArrayList<Integer> printCommon(int[] a,int[] b,int[] c) {
        ArrayList<Integer> res = new ArrayList<>();
        int i=0,j=0,k=0;
        while(i<a.length && j<b.length && k<c.length){
            if(a[i]==b[j] && b[j]==c[k]){
                res.add(a[i]);
                i++;
                j++;
                k++;
            }
            else if(a[i]<b[j]){
                i++;
            }
            else if(b[j]<c[k]){
                j++;
            }
            else{
                k++;
            }

            while(i>=1 && i<a.length && a[i]==a[i-1]){
                i++;
            }
            while(j>=1 && i<b.length && b[j]==b[j-1]){
                j++;
            }
            while(k>=1 && k<c.length && c[k]==c[k-1]){
                k++;
            }
        }

        return res;
    }
}
