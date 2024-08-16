import java.util.*;

class Solution {
    public static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};
    public static int rowSize, colSize;

    public int[] solution(int m, int n, int[][] picture) {
        rowSize = m;
        colSize = n;
        boolean[][] visited = new boolean[m][n];
        Queue<Integer> queue = new LinkedList<>();
        int maxAreaSize = 0;
        int areaCnt = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || picture[i][j] == 0)
                    continue;

                queue.add(i * n + j);
                int curAreaSize = 1;
                visited[i][j] = true;
                areaCnt++;
                
                while (!queue.isEmpty()) {
                    int position = queue.poll();
                    int row = position / n;
                    int col = position % n;
                    int curColor = picture[row][col];
                    
                    for (int[] dir : DIRECTIONS) {
                        int nextRow = row + dir[0];
                        int nextCol = col + dir[1];

                        if (isAvailable(nextRow, nextCol) && picture[nextRow][nextCol] == curColor && !visited[nextRow][nextCol]) {
                            curAreaSize++;
                            queue.add(nextRow * n + nextCol);
                            visited[nextRow][nextCol] = true;
                        }
                    }
                }
                if (maxAreaSize < curAreaSize)
                    maxAreaSize = curAreaSize;
            }
        } 
        return new int[]{areaCnt, maxAreaSize};
    }

    public static boolean isAvailable(int row, int col) {
        return row >= 0 && row < rowSize && col >= 0 && col < colSize;
    }
}
