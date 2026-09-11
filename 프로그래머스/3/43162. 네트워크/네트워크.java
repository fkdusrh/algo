import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visit[i])
                continue;

            answer++;

            Deque<Integer> q = new ArrayDeque<>();
            q.offer(i);
            visit[i] = true;

            while (!q.isEmpty()) {
                int node = q.poll();

                for (int next = 0; next < n; next++) {
                    if (!visit[next] && computers[node][next] == 1) {
                        visit[next] = true;
                        q.offer(next);
                    }
                }
            }
        }

        return answer;
    }
}