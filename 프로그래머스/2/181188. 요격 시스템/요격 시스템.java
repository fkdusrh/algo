import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int count = 0;

        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));

        int prevEnd = -1;
        for (int[] interval : targets) {
            if (prevEnd == -1) {
                count++;
                prevEnd = interval[1] - 1;
                continue;
            }

            if (prevEnd >= interval[0] && prevEnd <= interval[1]) continue;

            count++;
            prevEnd = interval[1] - 1;
        }

        return count;
    }
}
