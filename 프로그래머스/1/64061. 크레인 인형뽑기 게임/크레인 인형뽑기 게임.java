import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Stack<Integer>> list = new LinkedList<>();
        for(int j = 0; j < board.length; j++) {
            Stack<Integer> s = new Stack<>();
            for(int i = board.length - 1; i >= 0; i--) {
                int num = board[i][j];
                if(num == 0)
                    break;
                s.push(num);
            }
            list.add(s);
        }
        Stack<Integer> box = new Stack<>();
        for(int move : moves) {
            Stack<Integer> stack = list.get(move - 1);
            if (!stack.isEmpty()) {
                int num = stack.pop();
                if(!box.isEmpty() && box.peek() == num) {
                    box.pop();
                    answer += 2;
                } else {
                    box.push(num);
                }
            }
        }
        return answer;
    }
}
