import java.util.*;

public class GGraph {

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

        HashSet<Integer> visited = new HashSet<>();
        hamiltonian(graph,source,visited,source+"",source);

    }    

    public static void hamiltonian(ArrayList<Edge>[] graph,int source, HashSet<Integer> visited, String psf,int osrc){
        
        if(visited.size() == graph.length - 1){
            System.out.print(psf);
            boolean flag = false;
            for(Edge e: graph[source]){
                if(e.dest == osrc){
                    flag = true;
                    break;
                }
            }

            if(flag){
                System.out.println(" *");
            }else{
                System.out.println(" .");
            }
            return;
        }
        
        visited.add(source);
        for(Edge e: graph[source]){
            if(!visited.contains(e.dest)){
                hamiltonian(graph, e.dest, visited, psf+e.dest,osrc);
            }
        }
        visited.remove(source);
    }
}
