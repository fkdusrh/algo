import java.util.*;

class Solution {
    public long solution(int r1, int r2) {
        long totalPoints = 0;

        long r1Squared = (long) Math.pow(r1, 2);
        long r2Squared = (long) Math.pow(r2, 2);

        long point = 0;

        for (long x = 0; x <= r2; x++) {
            long y2Max = (long) Math.sqrt(r2Squared - (long) Math.pow(x, 2));
            long y1Max = (long) Math.sqrt(r1Squared - (long) Math.pow(x, 2));

            if (Math.sqrt(r1Squared - Math.pow(x, 2)) % 1 == 0) {
                point++;
            }

            totalPoints += (y2Max - y1Max) * 4;
        }

        totalPoints += point * 4 - 4;
        return totalPoints;
    }
}
