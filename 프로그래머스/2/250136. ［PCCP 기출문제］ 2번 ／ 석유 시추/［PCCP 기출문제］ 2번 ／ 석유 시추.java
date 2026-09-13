import java.util.*;
class Solution {
    final int[][] DIR = {{-1,0},{1,0},{0,-1},{0,1}};
    public int solution(int[][] land) {
        boolean[][] visit = new boolean[land.length][land[0].length];
        int[] oil = new int[land[0].length];
        
        int[] size = new int[land[0].length];
        
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if (visit[i][j] || land[i][j] == 0)
                    continue;
                
                Deque<int[]> q = new ArrayDeque<>();
                q.offer(new int[]{i,j});
                visit[i][j] = true;
                
                int cnt= 0;
                boolean[] usedCol = new boolean[land[0].length];

                
                while(!q.isEmpty()){
                    int[] curPos = q.poll();
                    
                    cnt++;
                    usedCol[curPos[1]] = true;
                    
                    for(int[] dir:DIR){
                        int nextRow = curPos[0] + dir[0];
                        int nextCol = curPos[1] + dir[1];
                        
                        if(nextRow <0 || nextCol < 0 || nextRow >= land.length || nextCol >= land[0].length||visit[nextRow][nextCol] || land[nextRow][nextCol] == 0)
                            continue;

                        
                        visit[nextRow][nextCol] = true;
                        
                        q.offer(new int[]{nextRow,nextCol});
                    }   
            
                 }
                
                for (int col = 0; col < land[0].length; col++) {
                    if (usedCol[col]) {
                        oil[col] += cnt;
                    }
                }
            }
        }
        
        int answer = 0;

        for (int amount : oil) {
            answer = Math.max(answer, amount);
        }

        return answer;
    }
}