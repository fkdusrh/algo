class Solution {
    public int solution(String name) {
        int totalOperations = 0; 
        int nameLength = name.length();
        int minMoves = nameLength - 1; 

        for (int i = 0; i < nameLength; i++) {
            char currentChar = name.charAt(i);
            int upDownMoves = Math.min(currentChar - 'A', 'Z' - currentChar + 1);
            totalOperations += upDownMoves;

            int nextIndex = i + 1;
            while (nextIndex < nameLength && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }

            int forwardThenBack = (i * 2) + nameLength - nextIndex; 
            int backwardThenForward = (nameLength - nextIndex) * 2 + i; 
            minMoves = Math.min(minMoves, forwardThenBack);
            minMoves = Math.min(minMoves, backwardThenForward);
        }
        
        totalOperations += minMoves;

        return totalOperations;
    }
}
