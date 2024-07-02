import java.util.*;

class Solution {
    static ArrayList<Integer>[] adjacencyList;
    static int minimumDifference;

    public int solution(int n, int[][] wires) {
        initializeGraph(n, wires);

        for (int[] wire : wires) {
            int node1 = wire[0];
            int node2 = wire[1];

            boolean[] visited = new boolean[n + 1];

            removeEdge(node1, node2);

            int subtreeNodeCount = calculateSubtreeSize(1, visited);

            int difference = Math.abs(subtreeNodeCount - (n - subtreeNodeCount));
            minimumDifference = Math.min(minimumDifference, difference);

            addEdge(node1, node2);
        }

        return minimumDifference;
    }

    private void initializeGraph(int n, int[][] wires) {
        adjacencyList = new ArrayList[n + 1];
        minimumDifference = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int node1 = wire[0];
            int node2 = wire[1];
            addEdge(node1, node2);
        }
    }

    private void addEdge(int node1, int node2) {
        adjacencyList[node1].add(node2);
        adjacencyList[node2].add(node1);
    }

    private void removeEdge(int node1, int node2) {
        adjacencyList[node1].remove(Integer.valueOf(node2));
        adjacencyList[node2].remove(Integer.valueOf(node1));
    }

    private int calculateSubtreeSize(int node, boolean[] visited) {
        visited[node] = true;
        int nodeCount = 1;

        for (int adjacentNode : adjacencyList[node]) {
            if (!visited[adjacentNode]) {
                nodeCount += calculateSubtreeSize(adjacentNode, visited);
            }
        }

        return nodeCount;
    }
}
