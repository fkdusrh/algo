import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(int[][] edges) {
        Map<Integer, int[]> nodeCount = new HashMap<>();
        int[] result = new int[4];

        Arrays.stream(edges).forEach(edge -> {
            int nodeA = edge[0];
            int nodeB = edge[1];
            nodeCount.putIfAbsent(nodeA, new int[2]);
            nodeCount.putIfAbsent(nodeB, new int[2]);
            nodeCount.get(nodeA)[0]++;
            nodeCount.get(nodeB)[1]++;
        });

        for (int key : nodeCount.keySet()) {
            int[] counts = nodeCount.get(key);

            if (counts[0] >= 2 && counts[1] == 0) {
                result[0] = key;
            } else if (counts[0] == 0 && counts[1] > 0) {
                result[2]++;
            } else if (counts[0] >= 2 && counts[1] >= 2) {
                result[3]++;
            }
        }

        if (result[0] != 0) {
            result[1] = nodeCount.get(result[0])[0] - result[2] - result[3];
        }

        return result;
    }
}