import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        double[][] failRate = new double[N][2]; 
        for (int i = 1; i <= N; i++) failRate[i - 1][0] = i;

        int[] stayMembers = new int[N + 2];
        Arrays.sort(stages);

        for (int stage : stages) {
            if (stage == N + 1) break;
            stayMembers[stage]++;
        }

        int clearMember = stages.length;

        for (int i = 1; i <= N; i++) {
            failRate[i - 1][1] = (clearMember == 0) ? 0.0 : (double) stayMembers[i] / clearMember;
            clearMember -= stayMembers[i];
        }

        Arrays.sort(failRate, (a, b) -> {
            int cmp = Double.compare(b[1], a[1]);
            if (cmp != 0) return cmp;
            return Double.compare(a[0], b[0]);
        });

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) answer[i] = (int) failRate[i][0]; 
        return answer;
    }
}
