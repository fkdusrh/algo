import java.util.Stack;

public class Solution {
    public int[] solution(int[] numbers) {
        Stack<Integer> indexStack = new Stack<>();

        int[] result = new int[numbers.length];

        indexStack.push(0);

        for (int i = 1; i < numbers.length; i++) {
            while (!indexStack.isEmpty() && numbers[indexStack.peek()] < numbers[i]) {
                result[indexStack.pop()] = numbers[i];
            }
            indexStack.push(i);
        }

        while (!indexStack.isEmpty()) {
            result[indexStack.pop()] = -1;
        }

        return result;
    }
}
