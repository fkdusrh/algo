import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int maxA = 0;
        int maxB = 0;
        
        for(int i=0;i<sizes.length;i++){
            if(sizes[i][0] < sizes[i][1]){
                int tmp = sizes[i][0];
                sizes[i][0] = sizes[i][1];
                sizes[i][1] =tmp;
            }
        }
        
        for(int i=0;i<sizes.length;i++){
            maxA = Math.max(sizes[i][0], maxA);
            maxB = Math.max(sizes[i][1], maxB);
        }
        
        return maxA * maxB;
    }
}