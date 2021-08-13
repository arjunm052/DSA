import java.util.*;

public class IGraph {
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
        String psf;

        Pair(int v,String psf){
            this.v=v;
            this.psf=psf;
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

        System.out.println("Enter source: ");
        int source = sc.nextInt();   
        sc.close();

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[v];
        queue.add(new Pair(source,source+""));
        while(queue.size() > 0){
            // r m* w a*
            Pair rem = queue.removeFirst();

            if(visited[rem.v]){
                continue;
            }

            visited[rem.v]=true;

            System.out.println(rem.v+"@"+rem.psf);

            for(Edge edge : graph[rem.v]){
                if(!visited[edge.dest]){
                    queue.add(new Pair(edge.dest, rem.psf+edge.dest));
                }
            }

        }

    }
}
