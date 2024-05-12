import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int diceCount, diceFaces[][], maximumSideSum;
    static int[] oppositeFaces = {0, 6, 4, 5, 2, 3, 1};
    static boolean[][] markedFaces;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        diceCount = Integer.parseInt(reader.readLine());
        diceFaces = new int[diceCount][7];

        for (int i = 0; i < diceCount; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 1; j <= 6; j++) {
                diceFaces[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        buildTower();

        System.out.println(maximumSideSum);
    }

    private static void buildTower() {

        int currentTop = 0;
        for (int firstTop = 1; firstTop <= 6; firstTop++) {

            markedFaces = new boolean[diceCount][7];
            for (int face = 1; face <= 6; face++) {
                if (diceFaces[0][face] == firstTop) {
                    currentTop = diceFaces[0][face];

                    markedFaces[0][face] = markedFaces[0][oppositeFaces[face]] = true;
                    break;
                }
            }

            for (int i = 1; i < diceCount; i++) {
                for (int face = 1; face <= 6; face++) {
                    if (diceFaces[i][face] == currentTop) {
                        currentTop = diceFaces[i][oppositeFaces[face]];

                        markedFaces[i][face] = markedFaces[i][oppositeFaces[face]] = true;
                        break;
                    }
                }
            }

            maximumSideSum = Math.max(maximumSideSum, calculateMaximumSum());
        }
    }

    private static int calculateMaximumSum() {

        int totalSum = 0;
        for (int i = 0; i < diceCount; i++) {
            int maxSide = 0;
            for (int j = 1; j <= 6; j++) {
                if (!markedFaces[i][j])
                    maxSide = Math.max(maxSide, diceFaces[i][j]);
            }
            totalSum += maxSide;
        }

        return totalSum;
    }

}
