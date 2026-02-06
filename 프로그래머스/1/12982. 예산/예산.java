import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int sum = 0, cnt=0;
        
        for(int i=0;i<d.length;i++){
            if(sum + d[i] > budget)
                break;
            sum+=d[i];
            cnt++;
        }
        
        return cnt;
    }
}