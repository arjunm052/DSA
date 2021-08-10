import java.util.*;

public class Graph{

    private LinkedList<Integer> adj[];

    public Graph(int v){
        adj = new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int source,int dest){
        adj[source].add(dest);
        adj[dest].add(source);
    }

    public int bfs(int source,int dest){
        boolean[] visited = new boolean[adj.length];
        int[] parent = new int[adj.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        parent[source] = -1;
        visited[source] = true;

        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr==dest) break;

            for(int neighbour: adj[curr]){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    q.add(neighbour);
                    parent[neighbour]= curr;
                }
            }
        }
        int dist = 0;
        int curr = dest;
        while(parent[curr]!=-1){
            System.out.print(curr+" -> ");
            curr=parent[curr];
            dist++;
        }
        System.out.println(curr);
        return dist;
    }

    private boolean dfsUtil(int source,int dest,boolean vis[]){
        if(source==dest) return true;

        for(int neighbor: adj[source]){
            if(!vis[neighbor]){
                vis[neighbor] = true;
                boolean isConnected = dfsUtil(neighbor,dest,vis);
                if(isConnected) return true;
            }
        }

        return false;
    }

    public boolean dfs(int src,int dest){
        boolean[] vis = new boolean[adj.length];
        vis[src] = true;
        return dfsUtil(src, dest, vis);
    }

    public boolean dfsStack(int src,int dest){
        boolean[] vis = new boolean[adj.length];
        vis[src] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(src);
        
        while(!stack.isEmpty()){
            int curr = stack.pop();
            if(curr==dest) return true;
            for(int neighbor: adj[curr]){
                if(!vis[neighbor]){
                    vis[neighbor]=true;
                    stack.push(neighbor);                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of vertices");
        int v = sc.nextInt();
        Graph graph = new Graph(v);
        System.out.println("Enter no. of edges");
        int e = sc.nextInt();
        System.out.println("Enter the edges: ");
        for(int i=0;i<e;i++){
            int source = sc.nextInt();
            int dest = sc.nextInt();
            graph.addEdge(source, dest);
        }
        System.out.println("Enter source vertex: ");
        int src = sc.nextInt();
        System.out.println("Enter dest vertex: ");
        int dest = sc.nextInt();
        // System.out.println("Minimum path from " + src + " to " + dest + " is: ");
        // System.out.println("Distance is " + graph.bfs(src, dest));
        sc.close();
        if(graph.dfsStack(src, dest)){
            System.out.println("Path exists");
        }else{
            System.out.println("Path does not exist");
        }
    }
}