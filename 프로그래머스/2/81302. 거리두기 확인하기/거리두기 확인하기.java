import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int[] solution(String[][] places) {
        int[] result = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            result[i] = checkPlace(place) ? 1 : 0;
        }

        return result;
    }

    private static boolean checkPlace(String[] place) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (place[r].charAt(c) == 'P') {
                    if (!isSafeDistance(r, c, place)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isSafeDistance(int r, int c, String[] place) {
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { r, c });

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = current[0] + dr[i];
                int nc = current[1] + dc[i];

                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || (nr == r && nc == c)) {
                    continue;
                }

                int distance = Math.abs(nr - r) + Math.abs(nc - c);

                if (place[nr].charAt(nc) == 'P' && distance <= 2) {
                    return false;
                } else if (place[nr].charAt(nc) == 'O' && distance < 2) {
                    queue.offer(new int[] { nr, nc });
                }
            }
        }

        return true;
    }
}
