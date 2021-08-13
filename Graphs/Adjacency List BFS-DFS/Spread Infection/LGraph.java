import java.util.*;

public class LGraph {

    static class Edge{
        int src;
        int dest;
        int wt;
    
        Edge(int src,int dest,int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }      
    }

    static class Pair{
        int v;
        int time;

        Pair(int v,int time){
            this.v=v;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of Vertices");
        int v = sc.nextInt();
        System.out.println("Enter no. of edges");
        int e = sc.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i] = new ArrayList<Edge>();
        }

        System.out.println("Enter the edges: ");
        for(int i=0;i<e;i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int wt = sc.nextInt();
            graph[src].add(new Edge(src,dest,wt));
            graph[dest].add(new Edge(dest,src,wt));
        } 

        System.out.println("Enter source");
        int source = sc.nextInt();
        System.out.println("Enter time: ");
        int time = sc.nextInt();
        sc.close();

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(source,1));
        int[] visited = new int[v];
        int count = 0;

        while(q.size()>0){
            Pair rem = q.removeFirst();

            if(visited[rem.v] > 0){
                continue;
            }

            visited[rem.v] = rem.time;
            if(rem.time>time) break;
            count++;

            for(Edge edge : graph[rem.v]){
                if(visited[edge.dest] == 0){
                    q.add(new Pair(edge.dest, rem.time + 1));
                }
            }
        }

        System.out.println(count);
        
    }    
}
