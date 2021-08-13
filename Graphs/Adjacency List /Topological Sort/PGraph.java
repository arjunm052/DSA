import java.util.*;

public class PGraph {

    static class Edge{
        int source;
        int dest;

        Edge(int source,int dest){
            this.source = source;
            this.dest = dest;
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
            graph[src].add(new Edge(src,dest));
        }

        boolean[] visited = new boolean[v];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<v;i++){
            if(!visited[i]){
                topologicalSort(graph, i, visited, st);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(st.size()>0){
            res.add(st.pop());
        }

        System.out.println(res);

    }

    public static void topologicalSort( ArrayList<Edge>[] graph,int source,boolean[] visited,Stack<Integer> st){
        visited[source] = true;
        for(Edge edge: graph[source]){
            if(!visited[edge.dest]){
                topologicalSort(graph, edge.dest, visited, st);
            }
        }
        st.push(source);
    }
    
}
