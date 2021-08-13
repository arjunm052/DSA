import java.util.*;

public class KGraph {
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
        int level;

        Pair(int v,String psf,int level){
            this.v=v;
            this.psf=psf;
            this.level=level;
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
        sc.close();

        int[] visited = new int[v];
        Arrays.fill(visited,-1);

        for(int i=0;i<v;i++){
            if(visited[i] == -1){
                boolean isCompBipartite = checkComponentForBipartiteness(graph,i,visited);
                if(!isCompBipartite){
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(true);
    }

    public static boolean checkComponentForBipartiteness(ArrayList<Edge>[] graph, int source, int[] visited) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(source, source+"",0));

        while(q.size()>0){
            Pair rem = q.removeFirst();
            
            
            if(visited[rem.v] != -1){
                if(rem.level != visited[rem.v]){
                    return false;
                }
            }
            else{
                visited[rem.v] = rem.level;
            }

            for(Edge e: graph[source]){
                if(visited[e.dest] == -1){
                    q.add(new Pair(e.dest, rem.psf+e.dest,rem.level+1));
                }
            }
        }

        return true;
    }
}
