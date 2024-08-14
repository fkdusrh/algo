import java.util.*;

class Solution {

    public int solution(int[] numbers, int target) {
        int count = 0;
        Queue<Integer> sumsQueue = new LinkedList<>();
        sumsQueue.add(0);

        for (int num : numbers) {
            int currentLevelSize = sumsQueue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                int currentSum = sumsQueue.poll();
                sumsQueue.add(currentSum + num);
                sumsQueue.add(currentSum - num);
            }
        }

        for (int possibleSum : sumsQueue) {
            if (possibleSum == target) {
                count++;
            }
        }
        return count;
    }
}
