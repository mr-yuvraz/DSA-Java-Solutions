import java.util.*;

class DijkstraAlgorithm {
    static class Edge {
        int destination, weight;
        Edge(int d, int w) {
            destination = d;
            weight = w;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, cost;
        Node(int v, int c) {
            vertex = v;
            cost = c;
        }

        public int compareTo(Node other) {
            return Integer.compare(this.cost, other.cost);
        }
    }

    public static void dijkstra(List<List<Edge>> graph, int source) {
        int V = graph.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            for (Edge edge : graph.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < V; i++)
            System.out.println("To " + i + " -> " + dist[i]);
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Edge>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        graph.get(0).add(new Edge(1, 4));
        graph.get(0).add(new Edge(2, 3));
        graph.get(1).add(new Edge(3, 2));
        graph.get(1).add(new Edge(4, 3));
        graph.get(2).add(new Edge(4, 1));
        graph.get(3).add(new Edge(5, 1));
        graph.get(4).add(new Edge(5, 5));

        dijkstra(graph, 0);
    }
}
