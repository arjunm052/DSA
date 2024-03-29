import java.util.*;

public class EGraph {
    public static void main(String[] args) {
        int arr[][] = new int[][] { { 1, 1, 0, 0, 0 },
                                  { 0, 1, 0, 0, 1 },
                                  { 1, 0, 0, 1, 1 },
                                  { 0, 0, 0, 0, 0 },
                                  { 1, 0, 1, 0, 1 } };

        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int count = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==0 && !visited[i][j]){
                    drawTreeForComponent(arr,i,j,visited);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void drawTreeForComponent(int[][] arr,int i,int j,boolean[][] visited){
        if(i<0 || j<0 || i>=arr.length || j>=arr[0].length || arr[i][j]==1 || visited[i][j]){
            return;
        }
        
        visited[i][j]=true;
        
        drawTreeForComponent(arr, i-1, j, visited);
        drawTreeForComponent(arr, i, j+1, visited);
        drawTreeForComponent(arr, i, j-1, visited);
        drawTreeForComponent(arr, i+1, j, visited);

        
    } 
  
}
