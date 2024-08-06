class Solution {
    private static int[] queenPositions;  
    private static int totalSolutions;

    public int solution(int n) {
        queenPositions = new int[n];
        totalSolutions = 0;

        findSolutions(0, n);

        return totalSolutions;
    }

    private static void findSolutions(int currentRow, int totalRows) {
        if (currentRow == totalRows) {
            totalSolutions++;
            return;
        }
        
        for (int column = 0; column < totalRows; column++) {
            queenPositions[currentRow] = column; 
            if (isSafePosition(currentRow)) {
                findSolutions(currentRow + 1, totalRows);
            }
        }
    }

    private static boolean isSafePosition(int currentRow) {
        for (int previousRow = 0; previousRow < currentRow; previousRow++) {
            
            if (queenPositions[currentRow] == queenPositions[previousRow] || 
                Math.abs(currentRow - previousRow) == Math.abs(queenPositions[currentRow] - queenPositions[previousRow])) {
                return false;
            }
        }
        return true;
    }
}
