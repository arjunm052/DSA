import java.util.*;

public class rat {

    public static void main(String[] args) {
        int maze[][]  =  {
            {1, 0, 0, 0, 0},
            {1, 1, 0, 1, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 1, 0},
            {1, 1, 1, 1, 1}
         };

        int n = 5;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter starting point:");
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println("Enter ending Point: ");
        int destx = sc.nextInt();
        int desty = sc.nextInt();

        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] res = new int[maze.length][maze[0].length];      
        if(solve(maze,visited,x,y,destx,desty,res)){
            printMaze(res);
        }else{
            System.out.println("Path does not exist");
        }
    }

        

        public static boolean solve(int[][] maze,boolean[][] visited,int row,int col,int destx,int desty,int[][] res) {
            if(row==destx && col==desty){
                res[row][col]=1;
                return true;
            }

            if(isSafe(maze, row, col) && visited[row][col]){
                return false;
            }

            if(isSafe(maze, row, col)){
                visited[row][col]=true;
                res[row][col] = 1;
                if(solve(maze,visited,row-1,col,destx,desty,res)){
                    return true;
                }
                if(solve(maze,visited,row,col+1,destx,desty,res)){
                    return true;
                }
                if(solve(maze,visited,row+1,col,destx,desty,res)){
                    return true;
                }
                if(solve(maze,visited,row,col-1,destx,desty,res)){
                    return true;
                }
                res[row][col]=0;
                return false;

            }

            return false;
        }

        public static void printMaze(int[][] maze) {
            for(int i=0;i<maze.length;i++){
                for(int j=0;j<maze[i].length;j++){
                    System.out.print(maze[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }

        public static boolean isSafe(int[][] maze,int row,int col) {
            return (row>=0 && row<maze.length && col>=0 && col<maze[row].length && maze[row][col]==1);
        }
}
