class Solution {
    private static final int MOD = 1_000_000_007;
    private long[] tileCache = new long[5001];

    public long solution(int n) {
        tileCache[0] = 1;
        tileCache[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            tileCache[i] = (tileCache[i - 2] * 4 % MOD - tileCache[i - 4] % MOD + MOD) % MOD;
        }
        return tileCache[n];
    }
}
