import java.util.*;

class Solution {
    
    private static final int[] DIRECTION_X = {-1, 0, 1, 0}; 
    private static final int[] DIRECTION_Y = {0, -1, 0, 1};
    private static final char START = 'S';
    private static final char END = 'E';
    private static final char LEVER = 'L';
    private static final char WALL = 'X';

    private int endX; 
    private int endY; 

    public int solution(String[] maps) {
        int startX = 0, startY = 0, leverX = 0, leverY = 0; 

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char current = maps[i].charAt(j);
                if (current == START) {
                    startX = i;
                    startY = j;
                } else if (current == END) {
                    endX = i;
                    endY = j;
                } else if (current == LEVER) {
                    leverX = i;
                    leverY = j;
                }
            }
        }

        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        int stepToLever = bfs(new Node(startX, startY, 0), leverX, leverY, maps, visited, false);
        if (stepToLever == -1) return -1; 
        int stepToDestination = bfs(new Node(startX, startY, stepToLever * 2), endX, endY, maps, visited, true);

        return Math.min(stepToDestination, bfs(new Node(leverX, leverY, stepToLever), endX, endY, maps, visited, true));
    }

    private int bfs(Node start, int targetX, int targetY, String[] maps, boolean[][] visited, boolean refresh) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(start);

        if (refresh) {
            for (int i = 0; i < visited.length; i++) {
                Arrays.fill(visited[i], false);
            }
        }

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.x == targetX && current.y == targetY) {
                return current.step;
            }

            if (visited[current.x][current.y]) {
                continue;
            }
            
            visited[current.x][current.y] = true; 

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + DIRECTION_X[i];
                int nextY = current.y + DIRECTION_Y[i];

                if (isValid(nextX, nextY, maps, visited)) {
                    queue.add(new Node(nextX, nextY, current.step + 1));
                }
            }
        }
        return -1; 
    }

    // 유효한 범위인지 확인하는 메서드
    private boolean isValid(int x, int y, String[] maps, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < maps.length && y < maps[x].length()
                && !visited[x][y] && maps[x].charAt(y) != WALL;
    }

    class Node {
        int x;
        int y;
        int step;

        Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
}
