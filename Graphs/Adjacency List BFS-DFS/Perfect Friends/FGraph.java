import java.util.*;

public class FGraph {
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
        System.out.println("Enter no. of friends: ");
        int v = sc.nextInt();
        System.out.println("Enter total no. of friendships: ");
        int e = sc.nextInt();

        ArrayList<Edge>[] graph = new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i] = new ArrayList<Edge>();
        }

        System.out.println("Enter friendships: ");
        for(int i=0;i<e;i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            graph[src].add(new Edge(src,dest));
            graph[dest].add(new Edge(dest,src));
        }
        boolean[] visited = new boolean[v];
        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        for(int i=0;i<v;i++){
            if(!visited[i]){
                ArrayList<Integer> comp = new ArrayList<Integer>();
                getComponents(graph, comp, i, visited);
                comps.add(comp);
            }
        }

        int pairs = 0;
        for(int i=0;i<v;i++){
            for(int j=i+1;j<comps.size();j++){
                int count = comps.get(i).size()*comps.get(j).size();
                pairs += count;
            }
        }

        System.out.println(pairs);

        sc.close();
    }

    public static void getComponents(ArrayList<Edge>[] graph,ArrayList<Integer> comp,int src,boolean[] visited) {
        visited[src]=true;
        comp.add(src);
        for(Edge e : graph[src]){
            if(!visited[e.dest]){
                getComponents(graph, comp, e.dest, visited);
            }
        }
    }
}
