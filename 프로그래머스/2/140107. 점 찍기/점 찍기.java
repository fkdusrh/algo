public class Solution {
    public long solution(long k, long d) {
        long result = 0;

        for (long x = 0; x <= d; x += k) {
            long yLimit = (long) Math.sqrt(d * d - x * x);
            result += yLimit / k + 1;
        }
        return result;
    }
}
