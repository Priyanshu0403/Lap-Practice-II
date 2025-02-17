//Implement depth first search algorithm and Breadth First Search algorithm, Use an undirected
//graph and develop a recursive algorithm for searching all the vertices of a graph or tree data
//structure
import java.util.*;

public class GraphTraversal {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();

    // Add an edge to the undirected graph
    public void addEdge(int v, int w) {
        adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(w);
        adjList.computeIfAbsent(w, k -> new ArrayList<>()).add(v);
    }

    // Recursive DFS function
    private void dfsUtil(int v, Set<Integer> visited) {
        visited.add(v);
        System.out.print(v + " ");  // Process the node

        for (int neighbor : adjList.getOrDefault(v, new ArrayList<>())) {
            if (!visited.contains(neighbor)) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    // Public method to start DFS
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS Traversal: ");
        dfsUtil(start, visited);
        System.out.println();
    }

    // BFS implementation
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");  // Process the node

            for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Main method to test the algorithms
    public static void main(String[] args) {
        GraphTraversal graph = new GraphTraversal();
        
        // Creating a sample graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        System.out.println("Graph Traversal Example:");
        graph.dfs(0);  // Perform DFS starting from node 0
        graph.bfs(0);  // Perform BFS starting from node 0
    }
}
