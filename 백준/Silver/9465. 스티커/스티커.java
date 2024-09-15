import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(bufferedReader.readLine());

        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            int columns = Integer.parseInt(bufferedReader.readLine());

            int[][] stickers = new int[2][columns + 1];
            int[][] dp = new int[2][columns + 1];

            for (int row = 0; row < 2; row++) {
                String[] stickerRow = bufferedReader.readLine().split(" ");
                for (int col = 1; col <= columns; col++) {
                    stickers[row][col] = Integer.parseInt(stickerRow[col - 1]);
                }
            }

            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            for (int col = 2; col <= columns; col++) {
                dp[0][col] = Math.max(dp[1][col - 1], dp[1][col - 2]) + stickers[0][col];
                dp[1][col] = Math.max(dp[0][col - 1], dp[0][col - 2]) + stickers[1][col];
            }

            System.out.println(Math.max(dp[0][columns], dp[1][columns]));
        }
    }
}
