import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int boardSize = board.length;
        List<Stack<Integer>> ls = new ArrayList<>();
        
        for(int i=0;i<board[0].length ; i++){//열
            Stack<Integer> s = new Stack<>();
            
            for(int j=board.length-1;j>= 0;j--){//행
                if(board[j][i] !=0)
                    s.add(board[j][i]);
            }
            
            ls.add(s);
        }
        
        Stack<Integer> box = new Stack<>();
          
        for(int move:moves){
            if(ls.get(move-1).size()==0)
                continue;
            
            int grab = ls.get(move-1).pop();
            if(box.size()==0){
                box.push(grab);
            } else {
                if( box.peek() == grab){
                    answer ++;
                    box.pop();
                }else{
                    box.push(grab);
                }
            }
        }
        
        return answer*2 ;
    }
    
    public void print(Stack s){
        System.out.print("바구니[");
        for(int i=0;i<s.size();i++){
            System.out.print(s.get(i)+" / ");
        }
        System.out.println("]");
    }
  
}