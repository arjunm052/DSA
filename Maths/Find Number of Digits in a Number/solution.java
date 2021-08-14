import java.util.*;

public class solution{
    public static void main(String[] args) {
        int n = 123456;
        System.out.println(countDigits(n));
        System.out.println(countDigitsRec(n));
        System.out.println((int)countDigitsLog(n));

        
    }

    public static int countDigits(int n) {
        int count = 0;
        while(n!=0){
            n=n/10;
            ++count;
        }

        return count;
    }

    public static int countDigitsRec(int n) {
        if(n==0){
            return 0;
        }
        return 1+countDigits(n/10);
    }

    public static double countDigitsLog(int n){
        return Math.floor((Math.log10(n))+1);
    }
}