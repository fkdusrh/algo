import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        for(int[] size:sizes){
            if(size[0]<size[1]){
                int tmp = size[0];
                size[0] = size[1];
                size[1] = tmp;
            }
        }
        int maxWidth = 0, maxHeight = 0;
        for(int[] size:sizes){
            maxWidth = Math.max(size[0], maxWidth);
            maxHeight = Math.max(size[1],maxHeight);
        }
        return maxWidth * maxHeight;
    }
}