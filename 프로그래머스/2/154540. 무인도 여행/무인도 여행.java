import java.util.*;

class Solution {

    public int[] solution(String[] maps) {
        int X = maps.length;
        int Y = maps[0].length();
        int[][] map = new int[X][Y];

        // maps를 2차원 int 배열로 변경
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                map[i][j] = maps[i].charAt(j) == 'X' ? 0 : maps[i].charAt(j) - '0';
            }
        }

        List<Integer> days = new ArrayList<>();
        boolean[][] visited = new boolean[X][Y];

        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                if (!visited[i][j] && map[i][j] > 0) {
                    int day = dfs(map, visited, i, j);
                    days.add(day);
                }
            }
        }

        if (days.isEmpty()) {
            return new int[]{-1};
        }

        Collections.sort(days);
        return days.stream().mapToInt(Integer::intValue).toArray();
    }

    private int dfs(int[][] map, boolean[][] visited, int x, int y) {
        int X = map.length;
        int Y = map[0].length;
        int day = 0;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int cx = current[0];
            int cy = current[1];

            if (visited[cx][cy]) {
                continue;
            }

            visited[cx][cy] = true;
            day += map[cx][cy];

            int[] upAndDown = {1, -1, 0, 0};
            int[] leftAndRight = {0, 0, 1, -1};

            for (int i = 0; i < 4; i++) {
                int newX = cx + upAndDown[i];
                int newY = cy + leftAndRight[i];

                if (newX >= 0 && newY >= 0 && newX < X && newY < Y && !visited[newX][newY] && map[newX][newY] > 0) {
                    stack.push(new int[]{newX, newY});
                }
            }
        }

        return day;
    }
}
