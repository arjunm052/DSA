import java.util.*;

public class DGraph {

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

        System.out.println("Enter source: ");
        int source = sc.nextInt();   
        sc.close();

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean[] visited = new boolean[v];

        for(int i=0;i<v;i++){
            if(!visited[i]){
                ArrayList<Integer> comp = new ArrayList<>();
                getComponents(graph,comp,i,visited);
                comps.add(comp);
            }
        }

        System.out.println(comps);
    }

    public static void getComponents(ArrayList<Edge>[] graph,ArrayList<Integer> comp,int source,boolean[] visited) {
        visited[source] = true;
        comp.add(source);
        for(Edge edge : graph[source]){
            if(!visited[edge.dest]){
                getComponents(graph,comp,edge.dest,visited);
            }
        }
    }
 
    
}
