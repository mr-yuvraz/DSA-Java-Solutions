import java.util.*;

public class DFS {
    private int V;
    private LinkedList<Integer> adj[];

    public DFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public void dfsTraversal(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                dfsTraversal(neighbor, visited);
            }
        }
    }

    public void dfs(int start) {
        boolean visited[] = new boolean[V];
        dfsTraversal(start, visited);
    }

    public static void main(String args[]) {
        DFS g = new DFS(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        System.out.println("DFS Traversal starting from node 0:");
        g.dfs(0);
    }
}
