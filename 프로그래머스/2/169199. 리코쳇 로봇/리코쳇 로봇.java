import java.util.*;

class Solution {
    private final int[] rowMoves = {-1, 1, 0, 0};
    private final int[] colMoves = {0, 0, -1, 1};

    private final char ROBOT = 'R', OBSTACLE = 'D', GOAL = 'G';

    private int numRows, numCols;

    private class Position {
        int x, y, depth;

        public Position(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public int solution(String[] board) {
        numRows = board.length;
        numCols = board[0].length();

        Position start = null;
        Position end = null;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                char currentCell = board[i].charAt(j);

                if (currentCell == ROBOT) {
                    start = new Position(i, j, 0);
                } else if (currentCell == GOAL) {
                    end = new Position(i, j, 0);
                }
            }
        }

        return performBFS(board, start, end);
    }

    private int performBFS(String[] board, Position start, Position end) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(start);
        boolean[][] visited = new boolean[numRows][numCols];
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (current.x == end.x && current.y == end.y) {
                return current.depth;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = current.x;
                int nextY = current.y;

                while (isWithinBounds(nextX, nextY) && board[nextX].charAt(nextY) != OBSTACLE) {
                    nextX += rowMoves[i];
                    nextY += colMoves[i];
                }

                nextX -= rowMoves[i];
                nextY -= colMoves[i];

                if (visited[nextX][nextY] || (current.x == nextX && current.y == nextY)) continue;

                visited[nextX][nextY] = true;
                queue.add(new Position(nextX, nextY, current.depth + 1));
            }
        }

        return -1;
    }

    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < numRows && y < numCols;
    }
}
