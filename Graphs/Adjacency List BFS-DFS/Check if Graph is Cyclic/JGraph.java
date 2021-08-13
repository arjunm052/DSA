import java.util.*;

public class JGraph {

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
        sc.close();

        
        boolean[] visited = new boolean[v];
        for(int i=0;i<v;i++){
            if(!visited[i]){
                boolean flag = isCyclic(graph, i, visited);
                if(flag){
                    System.out.println(true);
                    return;
                }
            }
        }
        
        System.out.println(false);
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph, int src,boolean[] visited) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(src);
        while(queue.size()>0){
            int rem = queue.removeFirst();
            if(visited[rem]==true){
                return true;
            }

            visited[rem] = true;
            for(Edge e : graph[rem]){
                if(!visited[e.dest]){
                    queue.add(e.dest);
                }
            }
        }

        return false;
    }
}
