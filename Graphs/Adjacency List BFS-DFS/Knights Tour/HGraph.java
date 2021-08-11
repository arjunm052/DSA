import java.util.*;

public class HGraph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of chess board: ");
        int n = sc.nextInt();
        System.out.println("Enter position of knight: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

            int[][] chess = new int[n][n];
            printKnightsTour(chess,r,c,1);
    }

    private static void printKnightsTour(int[][] chess, int r, int c, int move) {

        if(r<0 || c<0 || r>=chess.length || c>=chess.length || chess[r][c]>0){
            return;
        }else if(move == chess.length*chess.length){
            chess[r][c] = move;
            printBoard(chess);
            chess[r][c]=0;
            return;
        }
        chess[r][c]=move;
        printKnightsTour(chess, r-2, c+1, move+1);
        printKnightsTour(chess, r-1, c+2, move+1);
        printKnightsTour(chess, r+1, c+2, move+1);
        printKnightsTour(chess, r+2, c+1, move+1);
        printKnightsTour(chess, r+2, c-1, move+1);
        printKnightsTour(chess, r+1, c-2, move+1);
        printKnightsTour(chess, r-1, c-2, move+1);
        printKnightsTour(chess, r-2, c-1, move+1);
        chess[r][c] = 0;
    }

    public static void printBoard(int[][] chess) {
        for(int i=0;i<chess.length;i++){
            for(int j=0;j<chess[i].length;j++){
                System.out.print(chess[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
