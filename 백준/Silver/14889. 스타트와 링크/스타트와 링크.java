import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
    public static int playerN;
    public static int minGap;
    public static int[][] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        playerN = Integer.parseInt(st.nextToken());
        scores = new int[playerN][playerN];
        minGap = Integer.MAX_VALUE;

        for (int i = 0; i < playerN; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < playerN; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        HashSet<Integer> teamA = new HashSet<>();
        combination(0, 0, teamA);
        System.out.println(minGap);
    }

    public static void combination(int start, int cnt, HashSet<Integer> teamA) {
        if (cnt == playerN / 2) {
            int totalA = 0, totalB = 0;
            for (int i = 0; i < playerN; i++) {
                for (int j = 0; j < playerN; j++) {
                    if (teamA.contains(i) && teamA.contains(j)) {
                        totalA += scores[i][j];
                    } else if (!teamA.contains(i) && !teamA.contains(j)) {
                        totalB += scores[i][j];
                    }
                }
            }
            minGap = Math.min(minGap, Math.abs(totalA - totalB));
            return;
        }
        if (start == playerN) {
            return;
        }

        teamA.add(start);
        combination(start + 1, cnt + 1, teamA);
        teamA.remove(start);
        combination(start + 1, cnt, teamA);
    }
}
