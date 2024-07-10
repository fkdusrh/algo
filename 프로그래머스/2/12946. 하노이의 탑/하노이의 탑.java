import java.util.*;

class Solution {
    private static List<int[]> arr = new ArrayList<>();

    public int[][] solution(int n) {
        performHanoi(n, 1, 2, 3);
        return arr.stream()
                .toArray(int[][]::new);
    }

    private static void performHanoi(int disks, int source, int auxiliary, int target) {
        if (disks == 0) {
            return;
        }
        performHanoi(disks - 1, source, target, auxiliary);
        arr.add(new int[]{source, target});
        performHanoi(disks - 1, auxiliary, source, target);
    }
}
