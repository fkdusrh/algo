import java.util.*;
class Solution {
    public int solution(int k, int[][] dungeons) {
        return permutation(dungeons, k, new boolean[dungeons.length]);
    }
    
    public int permutation(int[][] dungeons,int hp, boolean[] visited){     
        int max = 0;
        
        for(int i= 0;i< dungeons.length; i++){
            if(visited[i])
                continue;
            if(hp < dungeons[i][0])
                continue;
            
            visited[i] = true;
            max = Math.max(max, permutation(dungeons, hp - dungeons[i][1], visited)+1);
            visited[i] = false;
        }
        
        return max;
    }
}