import java.util.*;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Integer.MAX_VALUE;
        int left = 1, right=0;
        
        for(int diff:diffs){
            right = Math.max(diff, right);
        }
        
        while(left<=right){
            int mid = (left+right)/2;
            long sum = times[0];
            
            for(int i=1;i<diffs.length;i++){
                if(mid < diffs[i]){
                    long res =  (times[i] + times[i-1]) * (diffs[i]-mid) + times[i];
                    sum += res;
                } else{
                    sum += times[i];
                }
            }
            
            if(sum <= limit){
                answer = Math.min(answer, mid);
                right = mid - 1;
            }else if( sum > limit){
                left = mid + 1;
            }
        }
        
        return answer;
    }
}