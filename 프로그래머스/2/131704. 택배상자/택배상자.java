import java.util.*;

class Solution {
    public int solution(int[] order) {
        int processedCount = 0;
        int[] priorities = new int[order.length];
        
        for (int i = 0; i < order.length; i++) {
            priorities[order[i] - 1] = i;
        }
        
        Stack<Integer> tempStack = new Stack<>();
        int expectedPosition = 0;
     
        for (int i = 0; i < priorities.length; i++) {
            if (priorities[i] == expectedPosition) {
                expectedPosition++;
            } else {
                tempStack.push(priorities[i]);
            }
            while (!tempStack.isEmpty() && tempStack.peek() == expectedPosition) {
                tempStack.pop();
                expectedPosition++;
            }
        }
        return expectedPosition;
    }
}
