import java.util.*;

public class BFS {
    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency list

    // Constructor
    public BFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++)
            adj[i] = new LinkedList<>();
    }

    // Function to add an edge
    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS Traversal from a given source node
    public void bfsTraversal(int s) {
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String args[]) {
        BFS g = new BFS(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        System.out.println("BFS Traversal starting from node 0:");
        g.bfsTraversal(0);
    }
}
