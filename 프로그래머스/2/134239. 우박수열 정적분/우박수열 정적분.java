class Solution {
    public static double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        int steps = computeSteps(k);

        double[] yValues = new double[steps + 1];
        yValues[0] = k;
        for (int i = 1; i <= steps; i++) {
            yValues[i] = calculateNextYValue(yValues[i - 1]);
        }

        double[] trapezoidAreas = new double[steps + 1];
        for (int i = 1; i <= steps; i++) {
            trapezoidAreas[i] = (yValues[i - 1] + yValues[i]) / 2;
        }

        double[] cumulativeSums = new double[steps + 1];
        cumulativeSums[1] = trapezoidAreas[1];
        for (int i = 2; i <= steps; i++) {
            cumulativeSums[i] = trapezoidAreas[i] + cumulativeSums[i - 1];
        }

        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = steps + ranges[i][1];

            if (end > start) {
                double integralValue = cumulativeSums[end] - cumulativeSums[start];
                answer[i] = Math.round(integralValue * 10) / 10.0; // 소수점 첫째 자리까지 반올림
            } else if (start > end) {
                answer[i] = -1.0;
            } else {
                answer[i] = 0.0;
            }
        }

        return answer;
    }

    private static int computeSteps(int n) {
        int steps = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            steps++;
        }
        return steps;
    }

    private static double calculateNextYValue(double previousValue) {
        if (previousValue % 2 == 0) {
            return previousValue / 2;
        } else {
            return 3 * previousValue + 1;
        }
    }
}
