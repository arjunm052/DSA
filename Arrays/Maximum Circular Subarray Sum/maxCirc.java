public class maxCirc {
    public static void main(String[] args) {
        int arr[] = { 8, -8, 9, -9, 10, -11, 12 };
        System.out.print(subSum(arr));
    }

    public static int subSum(int[] arr) {
        int maxNormal = kadanes(arr);
        if (maxNormal < 0) {
            return maxNormal;
        }

        int arrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
            arr[i] = -arr[i];
        }

        int maxCircular = arrSum + kadanes(arr);
        return Math.max(maxNormal, maxCircular);
    }

    public static int kadanes(int[] arr) {
        int currMax = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }
}
