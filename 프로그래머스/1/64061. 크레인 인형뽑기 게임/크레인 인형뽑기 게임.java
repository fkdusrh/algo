import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int move:moves){
            move --;
            
            for(int i=0;i<board.length;i++){
                int item = board[i][move];
                
                if(item > 0){
                    if(st.size()>0 && st.peek() == item){
                        st.pop();
                        answer+=2;
                    }else{
                        st.push(item);
                    }
                    
                    board[i][move] = 0;
                    break;
                 }
            }
            
        }
        
        return answer;
    }
}