import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        final int[][] DIR = {{-1,0},{1,0},{0,-1},{0,1}};

        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        dist[0][0] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int[] d : DIR) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m || maps[nr][nc] == 0)
                    continue;

                if (!visited[nr][nc]) {
                    visited[nr][nc] = true;
                    dist[nr][nc] = dist[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return dist[n - 1][m - 1] == 0 ? -1 : dist[n - 1][m - 1];
    }
}