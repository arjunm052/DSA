import java.util.*;

public class findp {
    public static void main(String[] args) {
        int arr[] = {5,7,9,13,11,6,6,3,3};
        System.out.println(countDistinctPairs(arr, 12));
    }

    public static int countPair(int[] arr,int k) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++){
            if(set.contains(k-arr[i])){
                res++;
                set.add(arr[i]);
            }
            else{
                set.add(arr[i]);
            }
        }

        return res;
    }

    public static int countDistinctPairs(int[] arr,int k) {
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],1);
            }else{
                map.put(arr[i],map.get(arr[i])+1);
            }
        }
        for(Map.Entry<Integer,Integer> m : map.entrySet()){
            int key = m.getKey();
            if(2*key==k){
                if(map.get(key)>1);
                res+=2;
            }
            else{
                if(map.containsKey(k-key)){
                    res+=1;
                }
            }
        }

        return res/2;

    }
}
