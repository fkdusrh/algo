import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
    int[] steps = new int[y + 1];
    for (int i = x; i <= y; i++) {
        if (i != x && steps[i] == 0) {
            steps[i] = -1;
            continue;
        }
        if (i * 2 <= y) {
            steps[i * 2] = (steps[i * 2] == 0) ? steps[i] + 1 : Math.min(steps[i] + 1, steps[i * 2]);
        }
        if (i * 3 <= y) {
            steps[i * 3] = (steps[i * 3] == 0) ? steps[i] + 1 : Math.min(steps[i] + 1, steps[i * 3]);
        }
        if (i + n <= y) {
            steps[i + n] = (steps[i + n] == 0) ? steps[i] + 1 : Math.min(steps[i] + 1, steps[i + n]);
        }
    }
    return steps[y];
}

}