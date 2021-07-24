import java.util.*;

public class nkele {
    public static void main(String[] args) {
        int arr1[] = { 4, 2, 2, 7 };
        int k = 3;
        System.out.println(nBykElement(arr1, k));
    }

    public static int nBykElement(int[] arr,int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],map.get(arr[i])+1);
            }
        }

        int x = (int)(arr.length/k);

        for(Map.Entry<Integer,Integer> m: map.entrySet()){
            if(m.getValue()>x){
                return m.getKey();
            }
        }
        return -1;
    }
}
