import java.util.*;

public class NGraph {
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

    public static class Pair implements Comparable<Pair>{
        int v;
        int av;
        int wt;

        Pair(int v,int av,int wt){
            this.v = v;
            this.av = av;
            this.wt=wt;
        }

        public int compareTo(Pair o) {  
            return (this.wt - o.wt);
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

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[v]; 
        pq.add(new Pair(source,-1,0));


        while(pq.size()>0){
            Pair rem = pq.remove();

            if(visited[rem.v]){
                continue;
            }

            visited[rem.v] = true;
            if(rem.av != -1){
                System.out.println("["+rem.v+"-"+rem.av+" @ "+rem.wt+"]");
            }

            for(Edge edge: graph[rem.v]){
                if(!visited[edge.dest]){
                    pq.add(new Pair(edge.dest,rem.v,edge.wt));
                }
            }
        }
    }


}
