import java.util.*;

class Solution {
    public int solution(int n, int m, String[] board) {
        int answer = 0;
        char[][] map = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            boolean[][] toRemove = new boolean[n][m];

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m - 1; j++) {
                    char current = map[i][j];
                    if (current != '0' && 
                        current == map[i][j + 1] && 
                        current == map[i + 1][j] && 
                        current == map[i + 1][j + 1]) {
                        toRemove[i][j] = true;
                        toRemove[i][j + 1] = true;
                        toRemove[i + 1][j] = true;
                        toRemove[i + 1][j + 1] = true;
                    }
                }
            }

            boolean foundBlock = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (toRemove[i][j]) {
                        foundBlock = true;
                        if (map[i][j] != '0') {
                            map[i][j] = '0';
                            answer++;
                        }
                    }
                }
            }
            if (!foundBlock) break;

            for (int col = 0; col < m; col++) {
                for (int row = n - 1; row >= 0; row--) {
                    if (map[row][col] == '0') {
                        int nextRow = row - 1;
                        while (nextRow >= 0 && map[nextRow][col] == '0') {
                            nextRow--;
                        }
                        if (nextRow >= 0) {
                            map[row][col] = map[nextRow][col];
                            map[nextRow][col] = '0';
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}
