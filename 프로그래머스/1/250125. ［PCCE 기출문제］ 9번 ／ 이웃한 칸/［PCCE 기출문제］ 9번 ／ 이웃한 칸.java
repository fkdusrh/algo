class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        String curCol = board[h][w];
        
        for(int i=0;i<dh.length;i++){
            int row = h + dh[i];
            int col = w + dw[i];
            
            if(available(row, col, board.length))
                if(board[row][col].equals(curCol))
                    answer++;
        }
        
        return answer;
    }
    
    public boolean available(int i, int j, int size){
        if(i<0 || i >= size || j<0 || j>= size)
            return false;
        
        return true;
    }
}