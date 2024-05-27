import java.util.*;

public class Main {
    static int rows, cols;
    static char[][] map;
    static int[][] distance;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rows = scanner.nextInt();
        cols = scanner.nextInt();
        map = new char[rows][cols];
        scanner.nextLine(); 

        for (int i = 0; i < rows; i++) {
            map[i] = scanner.nextLine().toCharArray();
        }

        int maxDistance = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (map[i][j] == 'L') {
                    maxDistance = Math.max(maxDistance, bfs(i, j));
                }
            }
        }

        System.out.println(maxDistance);
    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[rows][cols];
        distance = new int[rows][cols];
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        int maxDist = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && map[nx][ny] == 'L' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[x][y] + 1;
                    maxDist = Math.max(maxDist, distance[nx][ny]);
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return maxDist;
    }
}
