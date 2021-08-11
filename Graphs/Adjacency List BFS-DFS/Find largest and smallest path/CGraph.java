import java.util.*;

public class CGraph {

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

        System.out.println("Enter source and destination: ");
        int source = sc.nextInt();
        int dest = sc.nextInt();
        System.out.println("Enter criteria and k: ");
        int criteria = sc.nextInt();
        int k = sc.nextInt();

        boolean[] visited = new boolean[v];
        multiSolver(graph, source, dest,visited,criteria,k,source+"",0);
        System.out.println("Shortest Path: " + spath + "@" + spathwt);
        System.out.println("Longest Path: " + lpath + "@"+lpathwt);
        System.out.println("Floor Path: " + fpath + "@"+fpathwt);
        System.out.println("Ceil Path: " + cpath + "@"+cpathwt);

        sc.close();
    }

   static String spath;
   static Integer spathwt = Integer.MAX_VALUE;
   static String lpath;
   static Integer lpathwt = Integer.MIN_VALUE;
   static String cpath;
   static Integer cpathwt = Integer.MAX_VALUE;
   static String fpath;
   static Integer fpathwt = Integer.MIN_VALUE;
 

    public static void multiSolver(ArrayList<Edge>[] graph,int source,int dest,boolean[] visited,int criteria,int k,String psf,int wsf){
        if(source==dest){
            if(wsf < spathwt){
                spathwt = wsf;
                spath = psf;
            }
    
            if(wsf > lpathwt){
                lpathwt = wsf;
                lpath = psf;
            }
    
            if(wsf > criteria && wsf < fpathwt){
                fpathwt = wsf;
                fpath = psf;
            }
    
            if(wsf < criteria && wsf < cpathwt){
                cpathwt = wsf;
                cpath = psf;
            }
            return;
        }

        


        visited[source] = true;

        for(Edge edge: graph[source]){
            if(!visited[edge.dest]){
                multiSolver(graph, edge.dest, dest, visited, criteria, k, psf+edge.dest, wsf+edge.wt);
            }
        }
    }
    
}
