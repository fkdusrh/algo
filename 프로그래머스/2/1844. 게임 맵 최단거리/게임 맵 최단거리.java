import java.util.*;
class Solution {
    final int[][] DIRECTION = {{-1,0},{1,0},{0,-1},{0,1}};
    public int solution(int[][] maps) {
        int answer = 0;
        Deque<int[]> st = new ArrayDeque<>(); //dfs
        boolean[][] visit = new boolean[maps.length][maps[0].length];
        int[][] board = new int[maps.length][maps[0].length];
        
        st.offer(new int[]{0,0});
        visit[0][0] = true;
        board[0][0] = 1;
        
        while(!st.isEmpty()){
            int[] curPos = st.poll();
            
            for(int[] dir: DIRECTION){
                int[] nextPos = new int[2];
                nextPos[0] = curPos[0] + dir[0];
                nextPos[1] = curPos[1] + dir[1];
                
                if(!isAvailable(dir, maps, nextPos))
                    continue;
                
                if(!visit[nextPos[0]][nextPos[1]] && maps[nextPos[0]][nextPos[1]] == 1){
                    st.offer(nextPos);
                    visit[nextPos[0]][nextPos[1]] = true;
                    board[nextPos[0]][nextPos[1]] += board[curPos[0]][curPos[1]]+1;
                }
                    
            }
        }
        
        int result = board[maps.length-1][maps[0].length-1];
        return result == 0 ? -1:result;
    }
    
    boolean isAvailable(int[] dir, int[][] maps, int[] pos){
        if(pos[0] < 0 || pos[1] <0 || pos[0] >= maps.length || pos[1] >= maps[0].length)
            return false;
        return true;
    }
}