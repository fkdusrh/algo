import java.util.Arrays;

class Solution {
    public static int solution(int[][] data, int col, int rowBegin, int rowEnd) {
        int result = 0;

        col -= 1;
        rowBegin -= 1;

        int columnToSort = col;
        Arrays.sort(data, (row1, row2) -> {
            if (row1[columnToSort] == row2[columnToSort]) {
                return row2[0] - row1[0];
            }
            return row1[columnToSort] - row2[columnToSort];
        });

        for (int i = rowBegin; i < rowEnd; i++) {
            int index = i + 1;
            int sum = Arrays.stream(data[i])
                            .map(value -> value % index)
                            .sum();

            result ^= sum;
        }

        return result;
    }
}
