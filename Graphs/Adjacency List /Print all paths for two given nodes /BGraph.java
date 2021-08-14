//Print all the paths that exist between two given nodes in a graph

import java.util.*;

public class BGraph {

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

        boolean[] visited = new boolean[v];
        printAllPaths(graph, source, dest,visited, source+"");
        
        sc.close();
    }

    public static void printAllPaths(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited, String psf) {
        if(src==dest){
            System.out.println(psf);
            return ;
        }
        visited[src]=true;
        for(Edge edge: graph[src]){
            if(!visited[edge.dest]){
                printAllPaths(graph,edge.dest,dest,visited, psf + edge.dest);       
            }
        }

        visited[src] = false;
    }
}
