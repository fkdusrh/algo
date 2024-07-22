import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int P = sc.nextInt(); // 문제의 개수
        
        for (int p = 1; p <= P; p++) {
            int N = sc.nextInt(); // 후보 선물의 개수
            int W1 = sc.nextInt(); // 첫 번째 드론의 무게 한계
            int W2 = sc.nextInt(); // 두 번째 드론의 무게 한계
            
            int[] weights = new int[N];
            int[] values = new int[N];
            
            for (int i = 0; i < N; i++) {
                weights[i] = sc.nextInt();
            }
            
            for (int i = 0; i < N; i++) {
                values[i] = sc.nextInt();
            }
            
            // 이 문제에 대한 해결책 계산
            int maxValue = solveKnapsackProblem(N, W1, W2, weights, values);
            System.out.println("Problem " + p + ": " + maxValue);
        }
        
        sc.close();
    }
    
    public static int solveKnapsackProblem(int N, int W1, int W2, int[] weights, int[] values) {
        int[][][] dp = new int[N + 1][W1 + 1][W2 + 1];
        
        for (int i = 1; i <= N; i++) {
            int w = weights[i - 1];
            int v = values[i - 1];
            for (int j = 0; j <= W1; j++) {
                for (int k = 0; k <= W2; k++) {
                    dp[i][j][k] = dp[i - 1][j][k]; // 현재 선물을 드론에 싣지 않는 경우
                    if (j >= w) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - w][k] + v); // 첫 번째 드론에 싣는 경우
                    }
                    if (k >= w) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k - w] + v); // 두 번째 드론에 싣는 경우
                    }
                }
            }
        }
        
        return dp[N][W1][W2];
    }
}
