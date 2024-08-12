import java.util.*;

class Solution {
    private int[] parent;

    private int findRoot(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = findRoot(parent[node]);
    }

    private void mergeSets(int node1, int node2) {
        int root1 = findRoot(node1);
        int root2 = findRoot(node2);
        if (root1 != root2) {
            parent[root2] = root1;
        }
    }

    public int solution(int n, int[][] costs) {
        int totalCost = 0;
        parent = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, Comparator.comparingInt(edge -> edge[2]));

        for (int[] edge : costs) {
            int node1 = edge[0];
            int node2 = edge[1];
            int edgeCost = edge[2];

            if (findRoot(node1) != findRoot(node2)) {
                mergeSets(node1, node2);
                totalCost += edgeCost;
            }
        }

        return totalCost;
    }
}
