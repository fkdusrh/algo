import java.util.*;
class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        while(st.hasMoreTokens()){
            int v = Integer.parseInt(st.nextToken());
            min = Math.min(min, v);
            max = Math.max(max, v);
        }
        
        return min+" "+max;
    }
}